package com.gdu.app15.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app15.domain.BlogDTO;

@Mapper
public interface BlogMapper {

	public int selectBlogListCount();
	public List<BlogDTO> selectBlogListByMap(Map<String, Object> map);
	public int insertBlog(BlogDTO blog);
	public int updateHit(int blogNo);
	public BlogDTO selectBlogByNo(int blogNo);
	public int deleteBlog(int blogNo);
	public int updateBlog(BlogDTO blog);
}
