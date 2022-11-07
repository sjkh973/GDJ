package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import domain.Free;


public class FreeDao {

	private SqlSessionFactory factory;
	
	private static FreeDao dao = new FreeDao();
	
	
	private FreeDao() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static FreeDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.free.";
	
	public List<Free> selectAllFree(){
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectAllFree");
		ss.close();
		return frees;
	}
	
	public Free selectFreeByNo(int freeNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectFreeByNo",freeNo);
		ss.close();
		return free;
	}
	
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update(mapper + "updateFree", free);
		if(result > 0 ) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteFree(int freeNo) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteFree", freeNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
}
