package ex02_writer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {

	public static void main(String[] args) {
		
		/*
		 *  1. eXtensible Markup Language
		 *  2. 확장 마크업 언어
		 *  3. 표준 마크업 언어인 HTML의 확장 버전
		 *  4. 정해진 태그(< >) 외 사용자 정의 태그 사용
		 *  // 태그 하나 하나를 element라고 한다.
		 * <products> 
		 *  	<product>
		 *  	<number>100</number>
		 *  	<name>새우깡</name>
		 *  	<price>1500</price>
		 *  	</product>
		 *  
		 *  	<product>
		 *  	<number>101</number>
		 *  	<name>양파링</name>
		 *  	<price>2000</price>
		 *  	</product>
		 *  
		 *  	<product>
		 *  	<number>102</number>
		 *  	<name>홈런볼</name>
		 *  	<price>3000</price>
		 *  	</product>
		 * </products> 
		 */

		try {
			
			// Document 생성(문서 생성)
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlStandalone(true); //xml 문서 첫줄 태그에 standalone = "no" 제거
			
			// Document에 products 태그 추가
			Element products = document.createElement("products");
			document.appendChild(products);
			
			//태그 생성
			 
			List<String> product1 = Arrays.asList("100", "새우깡", "1500");
			List<String> product2 = Arrays.asList("101", "양파링", "2000");
			List<String> product3 = Arrays.asList("102", "홈런볼", "3000");
			
			List<List<String>> list = Arrays.asList(product1, product2, product3);
			
			for(List<String> line : list) {
				// 태그 생성
				Element product  = document.createElement("product"); // "" 큰따옴표 안에 이름이 element(< >)의 이름임
				Element number  = document.createElement("number"); // // 태그이름
				number.setTextContent(line.get(0)); //태그에 list 첫번째 인덱스 값 set해주기 
				Element name  = document.createElement("name"); // 
				name.setTextContent(line.get(1));
				Element price  = document.createElement("price"); // 
				price.setTextContent(line.get(2));
				// 태그 배치
				products.appendChild(product);
				product.appendChild(number);
				product.appendChild(name);
				product.appendChild(price);
			}
			
			// XML 생성
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "UTF-8");
			transformer.setOutputProperty("indent", "yes"); // indent < = 들여쓰기
			transformer.setOutputProperty("doctype-public", "yes");  // document.setXmlStandalone(true); 하면 개행이 안 되기 때문에 추가
			
			Source source = new DOMSource(document);
			File file = new File("C:\\storage", "product.xml");
			StreamResult result = new StreamResult(file);
			
			transformer.transform(source, result);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
