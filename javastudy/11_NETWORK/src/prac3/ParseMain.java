package prac3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParseMain {

	public static void main(String[] args) {
		
		// 영화 한 편: Movie 객체
		// 영화 전체 : List<Movie> 리스트
	
		File file = new File("C:\\storage","boxoffice.xml");
		List<Movie> movies = new ArrayList<>();
	
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			
			NodeList boxOfficeList = doc.getElementsByTagName("dailyBoxOffice");
			for(int i = 0; i < boxOfficeList.getLength(); i++) {
				Element boxOffice = (Element)boxOfficeList.item(i);
				String movieCd = boxOffice.getElementsByTagName("movieCd").item(0).getTextContent();
				String movieNm = boxOffice.getElementsByTagName("movieNm").item(0).getTextContent();
				String openDt = boxOffice.getElementsByTagName("openDt").item(0).getTextContent();
				String salesAcc = boxOffice.getElementsByTagName("salesAcc").item(0).getTextContent();
				String audiAcc = boxOffice.getElementsByTagName("audiAcc").item(0).getTextContent();
				
				//5개를 하나의 객체로 만듬
				// builder() 패턴
				Movie movie = Movie.builder()
						.movieCd(movieCd)
						.movieNm(movieNm)
						.openDt(openDt)
						.salesAcc(salesAcc)
						.audiAcc(audiAcc)
						.build();
	
				movies.add(movie);
				
				
			} // for
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(Movie movie : movies) {
			System.out.println(movie);
		}
	}

}
