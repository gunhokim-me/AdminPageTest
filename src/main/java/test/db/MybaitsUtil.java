package test.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaitsUtil {
	static SqlSessionFactory sqlSessionFactory;
	
	//class 로딩시 실행되는 블럭
	static {
		try {
			String resource = "test/config/mybatis/config.xml";
			InputStream	inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
