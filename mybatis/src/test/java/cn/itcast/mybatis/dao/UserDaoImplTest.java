package cn.itcast.mybatis.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;

	// 执行Test执行
	@Before
	public void setUp() throws Exception {
		InputStream ins = ClassLoader.getSystemResourceAsStream("SqlMapConfig.xml");
		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
	}

	@Test
	public void testFindUserById() {
		// 创建UserDao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		try {
			User user = userDao.findUserById(16);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
