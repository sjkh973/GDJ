package repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Member;



public class MemberDao {
	// field -- SqlSessionFactory
	private SqlSessionFactory factory;
	
	//singleton - pattern
	
	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.member.";
	
	public Member login(Member member) {
		SqlSession ss = factory.openSession();
		Member login = ss.selectOne(mapper + "login", member);
		ss.close();
		return login;
	}
	
	// 모든 method는 SqlSessionFactory로부터 SqlSession을 얻어서 사용
	// method
	
	
	
	
	
	
}
