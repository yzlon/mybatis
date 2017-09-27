package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

public class MybatisFirst {

	@Test
	public void findUserByIdTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1、创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2、通过工厂获取会话sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3、通过SqlSession操作
		// 第一个参数命名空间+statement的id
		User user = sqlSession.selectOne("test.findUserById", 2);
		System.out.println(user);
		// 释放资源
		sqlSession.close();
	}

	/*
	 * 模糊查询
	 */
	@Test
	public void findUserByUsernameTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1、创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2、通过工厂获取会话sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3、通过SqlSession操作
		// 第一个参数命名空间+statement的id
		List<User> users = sqlSession.selectList("test.findUserByUsername", "三");
		System.out.println(users);
		// 释放资源
		sqlSession.close();
	}/*
		 * 模糊查询
		 */

	@Test
	public void insertUserTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1、创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2、通过工厂获取会话sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3、通过SqlSession操作
		// 第一个参数命名空间+statement的id
		User user = new User();
		user.setUserName("钱雨鑫");
		user.setBirthday(new Date(new java.util.Date().getTime()));
		user.setSex("男");
		user.setAddress("山东省额日照市");
		int ret = sqlSession.insert("test.insertUser", user);
		System.out.println("update :" + ret + " user.id:" + user.getId());
		// 提交事务
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}

	@Test
	public void deleteUserTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1、创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2、通过工厂获取会话sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3、通过SqlSession操作
		// 第一个参数命名空间+statement的id
		int ret = sqlSession.delete("test.deleteUser", 15);
		System.out.println("update :" + ret);
		// 提交事务
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}

	@Test
	public void updateUserTest() throws IOException {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 1、创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 2、通过工厂获取会话sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 3、通过SqlSession操作
		// 第一个参数命名空间+statement的id
		User user = new User();
		user.setId(16);
		user.setUserName("全玉鑫");
		user.setBirthday(new Date(new java.util.Date().getTime()));
		user.setSex("女");
		user.setAddress("山东省额日照市");
		int ret = sqlSession.update("test.updateUser", user);
		System.out.println("update :" + ret + " user.id:" + user.getId());
		// 提交事务
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}
}
