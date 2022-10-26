package repository;

import java.io.InputStream;
import java.util.List;

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
	
	// 모든 method는 SqlSessionFactory로부터 SqlSession을 얻어서 사용
	// method
	String mapper = "mybatis.mapper.member.";
	
	// 1. 회원 목록
	public List<Member> selectAllMembers(){
		SqlSession ss = factory.openSession();
		List<Member> members = ss.selectList(mapper + "selectAllMembers");
		ss.close();
		return members;
	}
	// 2. 회원 수
	public int selectAllAllMembersCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllAllMembersCount");
		return count;
	}
	
	// 3. 회원 상세
	public Member selectMemberByNo(int memberNo) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne(mapper + "selectMemberByNo", memberNo);
		ss.close();
		return member;
	}
	
	
	// 회원 정보가 바뀌는 쿼리문의 리턴값은 int 타입이다
	
	// 4. 회원 등록
	
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession();
		int result = ss.insert(mapper + "insertMember", member);
		if(result > 0 ) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int updateMember(Member member) {
		SqlSession ss = factory.openSession();
		int result = ss.update(mapper + "updateMember", member); // ss.???() update, delete, insert중 아무거나 넣어도 쿼리문에 맞춰서 동작함
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteMember(int memberNo) {
		SqlSession ss = factory.openSession();
		int result = ss.delete(mapper + "deleteMember", memberNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
}
