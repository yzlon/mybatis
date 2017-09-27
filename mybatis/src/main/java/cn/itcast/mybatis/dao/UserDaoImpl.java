package cn.itcast.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	// 定义一个工厂属性，通过构造函数注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		// 释放资源
		sqlSession.close();

		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int ret = sqlSession.insert("test.insertUser", user);
		System.out.println("ret:" + ret + " user.id:" + user.getId());
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int ret = sqlSession.delete("test.deleteUser", id);
		System.out.println("ret:" + ret);
		sqlSession.commit();
		// 释放资源
		sqlSession.close();
	}

}
