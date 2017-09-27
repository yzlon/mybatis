package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;
import cn.itcast.mybatis.pojo.UserCustom;
import cn.itcast.mybatis.pojo.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		InputStream ins = ClassLoader.getSystemResourceAsStream("SqlMapConfig.xml");
		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);

	}

	@Test
	public final void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建Mapper对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = null;
		try {
			user = userMapper.findUserById(16);
			user = userMapper.findUserById(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		System.out.println(user);

	}

	@Test
	public final void testFindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建Mapper对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		List<UserCustom> userCustoms = null;
		int count = 0;
		try {
			userCustom.setSex("男");
			userCustom.setUserName("三");
			userQueryVo.setUserCustom(userCustom);
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(2);
			ids.add(10);
			ids.add(16);
			userQueryVo.setIds(ids);
			userCustoms = userMapper.findUserList(userQueryVo);
			count = userMapper.findUserCount(userQueryVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		System.out.println(userCustoms + " : " + count);

	}

	@Test
	public final void findUserByIdResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 创建Mapper对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = null;
		try {
			user = userMapper.findUserByIdResultMap(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		System.out.println(user);

	}

}
