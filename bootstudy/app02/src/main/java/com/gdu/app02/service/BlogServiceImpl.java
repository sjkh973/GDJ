package com.gdu.app02.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app02.domain.BlogDTO;
import com.gdu.app02.domain.SummernoteImageDTO;
import com.gdu.app02.mapper.BlogMapper;
import com.gdu.app02.util.MyFileUtil;
import com.gdu.app02.util.PageUtil;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogMapper blogMapper;
	private PageUtil pageUtil;
	private MyFileUtil myFileUtil;
	
	@Autowired
	public void set(BlogMapper blogMapper, PageUtil pageUtil, MyFileUtil myFileUtil) {
		this.blogMapper = blogMapper;
		this.pageUtil = pageUtil;
		this.myFileUtil = myFileUtil;
	}
	
	@Override
	public void getBlogList(Model model) {
		
		// Model에 저장된 request 꺼내기
		Map<String, Object> modelMap = model.asMap();  // model을 map으로 변신
		HttpServletRequest request = (HttpServletRequest) modelMap.get("request");
		
		// page 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 블로그 개수
		int totalRecord = blogMapper.selectBlogListCount();
		
		// 페이징 처리에 필요한 변수 계산
		pageUtil.setPageUtil(page, totalRecord);
		
		// 조회 조건으로 사용할 Map 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		// 뷰로 전달할 데이터를 model에 저장하기 
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("blogList", blogMapper.selectBlogListByMap(map));
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/blog/list"));
		
	}
	
	@Override
	public Map<String, Object> saveSummernoteImage(MultipartHttpServletRequest multipartRequest) {
		
		// 파라미터 files
		MultipartFile multipartFile = multipartRequest.getFile("file");
			
		// 저장 경로
		String path = "C:" + File.separator + "summernoteImage";
				
		// 저장할 파일명
		String filesystem = myFileUtil.getFilename(multipartFile.getOriginalFilename());
		
		// 저장 경로가 없으면 만들기
		File dir = new File(path);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 저장할 File 객체
		File file = new File(path, filesystem);  // new File(dir, filesystem)도 가능
		
		// HDD에 File 객체 저장하기
		try {
			multipartFile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 저장된 파일을 확인할 수 있는 매핑을 반환
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("src", multipartRequest.getContextPath() + "/load/image/" + filesystem);  // 이미지 mapping값을 반환
		map.put("filesystem", filesystem);  // HDD에 저장된 파일명 반환
		return map;
		
	}
	
	@Transactional
	@Override
	public void saveBlog(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 title, content
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 작성자의 ip
		// 작성된 내용이 어딘가를 경유해서 도착하면 원래 ip가 X-Forwarded-For라는 요청헤더에 저장된다.
		
		// 출발                  도착
		// 1.1.1.1               1.1.1.1 : request.getRemoteAddr()
		//                       null    : request.getHeader("X-Forwarded-For")
		
		// 출발       경유       도착
		// 1.1.1.1    2.2.2.2    2.2.2.2 : request.getRemoteAddr()
		//                       1.1.1.1 : request.getHeader("X-Forwarded-For")
		
		Optional<String> opt = Optional.ofNullable(request.getHeader("X-Forwarded-For"));
		String ip = opt.orElse(request.getRemoteAddr());
		
		// DB로 보낼 BlogDTO
		BlogDTO blog = BlogDTO.builder()
				.title(title)
				.content(content)
				.ip(ip)
				.build();
		
		// DB에 Blog 저장
		int result = blogMapper.insertBlog(blog);
		
		// 응답
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				
				// 파라미터 summernoteImageNames
				String[] summernoteImageNames = request.getParameterValues("summernoteImageNames");
				
				// DB에 SummernoteImage 저장
				if(summernoteImageNames !=  null) {
					for(String filesystem : summernoteImageNames) {
						SummernoteImageDTO summernoteImage = SummernoteImageDTO.builder()
								.blogNo(blog.getBlogNo())
								.filesystem(filesystem)
								.build();
						blogMapper.insertSummernoteImage(summernoteImage);
					}
				}
				
				out.println("alert('삽입 성공');");
				out.println("location.href='" + request.getContextPath() + "/blog/list';");
			} else {
				out.println("alert('삽입 실패');");
				out.println("history.back();");
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int increseBlogHit(int blogNo) {
		return blogMapper.updateHit(blogNo);		
	}
	
	@Override
	public BlogDTO getBlogByNo(int blogNo) {
		
		
		// 블로그를 새로 등록하거나 수정할 때
		// 써머노트에 이미지를 넣는 것은 ajax로 실시간 처리가 되지만,
		// 써머노트에 넣은 이미지를 제거하는 것은 summernote에서 제공하는 처리 방법이 없다.
		// 따라서, 써머노트에 이미지를 넣은 다음 이미지를 다시 제거해도 HDD에는 이미지가 그대로 남아 있다.
		
		// 실제로 써머노트에서 사용한 이미지는
		// Blog의 content에 <img src="/app02/load/image/xxxxx.jpg"> 태그로 포함되어 있으므로
		// 저장된 이미지 목록과 Blog의 content를 비교해서 일치하지 않는 이미지 파일은 지운다.
		
		
		// DB에서 블로그 정보 가져오기
		BlogDTO blog = blogMapper.selectBlogByNo(blogNo);
		
		// 블로그에서 사용한 것으로 되어 있는 써머노트 이미지(저장된 파일명이 DB에 저장되어 있고, 실제로 HDD에도 저장되어 있음)
		List<SummernoteImageDTO> summernoteImageList = blogMapper.selectSummernoteImageListInBlog(blogNo);
		
		// 블로그에서 사용한 것으로 저장되어 있으나 블로그 내용(content)에는 없는 써머노트 이미지를 찾아서 제거
		if(summernoteImageList != null && summernoteImageList.isEmpty() == false) {
			for(SummernoteImageDTO summernoteImage : summernoteImageList) {
				if(blog.getContent().contains(summernoteImage.getFilesystem()) == false) {
					File file = new File("C:" + File.separator + "summernoteImage", summernoteImage.getFilesystem());
					if(file.exists()) {
						file.delete();  // HDD에 저장된 파일 지우기
					}
					blogMapper.deleteSummernoteImage(summernoteImage.getFilesystem());  // DB에 목록에서 지우기
				}
			}
		}
		
		// 블로그 반환
		return blog;
		
	}
	
	@Transactional
	@Override
	public void modifyBlog(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 title, content, blogNo
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int blogNo = Integer.parseInt(request.getParameter("blogNo"));
		
		// DB로 보낼 BlogDTO
		BlogDTO blog = BlogDTO.builder()
				.title(title)
				.content(content)
				.blogNo(blogNo)
				.build();
		
		// DB 수정
		int result = blogMapper.updateBlog(blog);
		
		// 응답
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				
				// 파라미터 summernoteImageNames
				String[] summernoteImageNames = request.getParameterValues("summernoteImageNames");
				
				// DB에 SummernoteImage 저장
				if(summernoteImageNames != null) {
					for(String filesystem : summernoteImageNames) {
						SummernoteImageDTO summernoteImage = SummernoteImageDTO.builder()
								.blogNo(blog.getBlogNo())
								.filesystem(filesystem)
								.build();
						blogMapper.insertSummernoteImage(summernoteImage);
					}
				}
				
				out.println("alert('수정 성공');");
				out.println("location.href='" + request.getContextPath() + "/blog/detail?blogNo=" + blogNo + "';");
			} else {
				out.println("alert('수정 실패');");
				out.println("history.back();");
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void removeBlog(HttpServletRequest request, HttpServletResponse response) {
		
		// 파라미터 blogNo
		int blogNo = Integer.parseInt(request.getParameter("blogNo"));
		
		// HDD에서 삭제해야 하는 SummernoteImage 리스트 
		List<SummernoteImageDTO> summernoteImageList = blogMapper.selectSummernoteImageListInBlog(blogNo);
		
		// DB 삭제
		int result = blogMapper.deleteBlog(blogNo);  // 외래키 제약조건에 의해서 SummernoteImage도 모두 지워짐
		
		// 응답
		try {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			if(result > 0) {
				
				// HDD에서 SummernoteImage 리스트 삭제
				if(summernoteImageList != null && summernoteImageList.isEmpty() == false) {
					for(SummernoteImageDTO summernoteImage : summernoteImageList) {
						File file = new File("C:" + File.separator + "summernoteImage", summernoteImage.getFilesystem());
						if(file.exists()) {
							file.delete();
						}
					}
				}
				
				out.println("alert('삭제 성공');");
				out.println("location.href='" + request.getContextPath() + "/blog/list';");
			} else {
				out.println("alert('삭제 실패');");
				out.println("history.back();");
			}
			out.println("</script>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}