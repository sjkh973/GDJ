package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Notice;



public class NoticeDao {
	// field -- SqlSessionFactory
	private SqlSessionFactory factory;
	
	//singleton - pattern
	
	private static NoticeDao dao = new NoticeDao();
	
	private NoticeDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static NoticeDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.notice.";
	
	public int selectAllNoticesCnt() {
		SqlSession ss = factory.openSession();
		int cnt = ss.selectOne(mapper + "selectAllNoticesCnt");
		ss.close();
		return cnt;
	}
	
	public List<Notice> selectAllNotices(Map<String, Object> map){
		SqlSession ss =factory.openSession();
		List<Notice> notices = ss.selectList(mapper + "selectAllNotices", map);
		ss.close();
		return notices;
	}
	
	
	
}
