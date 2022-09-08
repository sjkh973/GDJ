package repository;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import domain.ContactDTO;

public class ContactDAO {

	// DAO는 하나의 객체만 생성할 수 있도록
	// Singleton Pattern으로 생성
	
	/***************************** Singleton ****************************/
	
	// Singleton 패턴 - 1
	// ContactDAO 객체를 하나를 만들어 둔다.
	private static ContactDAO contactDAO = new ContactDAO();
	
	// Singleton 패턴 - 2
	// 외부에서는 ContactDAO 객체를 못 만들도록 제한한다.
	// private 생성자
	private ContactDAO() {
		
	}	
	
	// Singleton 패턴 - 3
	// 만들어 둔 ContactDAO 객체를 외부에 반환한다.
	public static ContactDAO getInstance() {
		return contactDAO;
	}
	
	/***************************** Field ****************************/
	// 데이터베이스에 접근할 때 사용하는 공통 요소
	private Connection con;       // DB 접속
	private PreparedStatement ps; // 쿼리문 실행
	private ResultSet rs;         // SELECT 결과
	private String sql;			  // 쿼리문
	private int result;           // INSERT, UPDATE, DELETE 결과
	/***************************** Method ****************************/
	
	// 모든 데이터베이스 작업(CRUD : CREATE/READ/UPDATE/DELETE)
	// 1. Connection 객체 생성
	// 2. close
	
	// 공통 메소드 -1
	public Connection getConnection() throws Exception{
		
		// OracleDriver 클래스 로드
		Class.forName("oracle.jdbc.OracleDriver");
		
		// Connection 객체 반환
		// db.properties 파일의 접속 정보 읽기
		Properties p = new Properties();
		p.load(new FileReader("db.properties")); // 경로가 없는 파일은 동일한 프로젝트 디렉터리에 있다는 의미
		String url = p.getProperty("url");
		String user = p.getProperty("user");
		String password = p.getProperty("password");
		return DriverManager.getConnection(url, user, password);
	}
	
	// 공통 메소드 -2
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			
			ContactDAO dao = ContactDAO.getInstance();
			Connection con = dao.getConnection();
			
			System.out.println("접속 성공");
			
		}catch (Exception e) {
			System.out.println("오류");
			e.printStackTrace();
		}
	}
	
	// 연락처 추가 메소드
	// 1. 매개변수 : ContactDTO
	// 2. 반환값   : 0 또는 1
	public int insertContact(ContactDTO contact) {
		try {
			con = getConnection();
			sql = "INSERT INTO CONTACT VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";	
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			
			result = ps.executeUpdate(); // executeUpdate의 결과값이 성공이면 1 실패면 0  						
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	// 연락처 수정 메소드
	// 1. 매개변수 : ContactDTO
	// 2. 반환값   : 0 또는 1
	public int updateContact(ContactDTO contact) {
		
		try {
			con = getConnection();
			sql = "UPDATE CONTACT SET NAME = ?, TEL = ?, EMAIL = ? WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getTel());
			ps.setString(3, contact.getEmail());
			ps.setInt(4, contact.getContact_no());
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
		
	}
	
	// 연락처 삭제 메소드
	// 1. 매개변수 : contact_no
	// 2. 반환값   : 0 또는 1
	public int deleteContact(int contact_no) {
		
		try {
			con = getConnection();
			sql = "DELETE FROM CONTACT WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 연락처 조회 메소드
	// 1. 매개변수 : contact_no
	// 2. 반환값   : ContactDTO 또는 null
	public ContactDTO selectContactByNo(int contact_no) {
		
		ContactDTO contact = null;
		try {
			
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, REG_DATE FROM CONTACT WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
			if(rs.next()) { // rs.next가 true이면 contact객체를만들어 rs.?? 값을 가져와서 set해준다
				contact = new ContactDTO();
				contact.setContact_no(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setTel(rs.getString(3));
				contact.setEmail(rs.getString(4));
				contact.setReg_date(rs.getDate(5));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return contact;
	}
	
	
	// 연락처 목록 메소드
	// 1. 매개변수 : 없음
	// 2. 반환값   : List<ContactDTO>
	public List<ContactDTO> selectALLContacts(){
		
		List<ContactDTO> contacts = new ArrayList<ContactDTO>();
		
		try {
			con = getConnection();
			sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, REG_DATE FROM CONTACT";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ContactDTO contact = ContactDTO.builder()
						.contact_no(rs.getInt(1))
						.name(rs.getString(2))
						.tel(rs.getString(3))
						.email(rs.getString(4))
						.reg_date(rs.getDate(5))
						.build();
				
				contacts.add(contact);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return contacts;
		
	}
	
}
