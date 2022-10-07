package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;



public class Main {

	public static void m1() {
		
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉터리
		// 3. 생성 방법
		//	1) new File(경로, 파일)
		//	2) new File(파일)
		// 4. 윈도우의 경로 구분 방법 : 백슬래시(\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시(/)
		
		// 폴더 (디렉터리) 만들기
		// c드라이브 안에 storage
		File dir = new File("c:\\storage");  // 역슬래시(\\) 2개를 해야 됨 
		
		// 존재하지 않으면 만들겠다.
		//.exists() 존재 여부 확인 메소드
		if(dir.exists() == false){ //if(! dir.exists())
			dir.mkdirs();
		}
		//존재하면 삭제하겠다
		else {
			//dir.delete(); // 지금 지운다.
			dir.deleteOnExit(); //JVM이 종료되면 지운다.
		}
		
	}
	
	public static void m2() {
		
		File file = new File("C:\\storage", "my.txt");
		
		try {
			if(file.exists() == false) {
				file.createNewFile();
			}
			else {
				file.deleteOnExit();
			}
		}catch(IOException e){
			//개발할 때 넣는 catch 블록 코드
			e.printStackTrace(); // 에러를 콘솔에 찍어라.
		}
	}
	
	public static void m3() {
		File file = new File("C:\\storage", "my.txt");
		System.out.println("파일명: " + file.getName());
		System.out.println("경로: " + file.getParent()); 
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModifiedDate = file.lastModified();
		System.out.println(lastModifiedDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastModified = sdf.format(lastModifiedDate);
		// 수정한 날짜 : 오전 09:50 2022-08-20
		System.out.println("수정한 날짜 : " + lastModified);
	
		long size = file.length(); //바이트 단위
		System.out.println("파일크기: " +size + "byte");
		
	}
	
	public static void m4() {
		
		File dir = new File("C:\\GDJ");
		
		File[] list = dir.listFiles(); //디렉터리 내부의 모든 ㅍ ㅏ일/디렉터리를 File 객체로 가져옴
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
		
	}
	
	public static void m5() {
		
		//플랫폼마다 다른 경로 구분자 지원
		//File.separator < == 윈도우, 리눅스 경로 구분하는게 서로 다르기때문에 이 메소드로 \\ or // 를 자동으로 처리
		File file = new File("C:" + File.separator + "storage"+File.separator +"my.txt");
		
		System.out.println(file.getName());
		
		file.deleteOnExit();
	}
	
	public static void q1() {
		
		File dir = new File("C:\\GDJ");
		File[] list = dir.listFiles();
		
		int dirCnt = 0;
		int fileCnt = 0;
		long totalSize = 0;
		
		for(File file : list) {
			if(file.isHidden()) {
				continue;
			}
			//수정한 날짜
			String lastModified = new SimpleDateFormat("yyyy-MM-dd a hh:mm").format(file.lastModified());
			
			String directory = "";
			String size = "";
			
			if(file.isDirectory()) {
				directory = "<DIR>";
				size = "     ";
				dirCnt++;
			} else if(file.isFile()){
				directory = "     ";
				size = new DecimalFormat("#,##0").format(file.length()) +  "";
				fileCnt++;
				totalSize += Long.parseLong(size.replace(",",  ""));
				
			}
			String name = file.getName();
			System.out.println(lastModified + " " + directory + " " + size + " " + name);			
		}
		System.out.println(dirCnt + "개 디렉터리");
		System.out.println(fileCnt + "개 파일" + new DecimalFormat("#,##0").format(totalSize)+ "byte");
		
	}
	
	public static void q2() {
		
		// C:\storage 디렉터리 삭제하기
		
		String sep = File.separator;
		
		File file = new File("C:" + sep + "storage" + sep + "my.txt");
		//.exists() 존재 여부 확인 메소드
		if(file.exists()) {
			file.delete();
		}
		
		File dir = new File("C:" + sep + "storage"); //< == storage안에 내용물이 있으면 안지워짐
		
		if(dir.exists()) {
			dir.delete();
		}
		
	}
	
	
	public static void main(String[] args) {
		m3();
	}

}
