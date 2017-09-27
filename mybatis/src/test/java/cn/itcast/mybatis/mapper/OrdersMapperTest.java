package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.pojo.Orderscustom;
import cn.itcast.mybatis.pojo.User;

public class OrdersMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		InputStream ins = ClassLoader.getSystemResourceAsStream("SqlMapConfig.xml");
		// 创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);

	}

	@Test
	public final void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orderscustom> list = ordersMapper.findOrdersUser();
		System.out.println(list);
		sqlSession.close();

	}

	@Test
	public final void testFindOrdersUserMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orderscustom> list = ordersMapper.findOrdersUserMap();
		System.out.println(list);
		sqlSession.close();

	}

	@Test
	public final void testFindOrdersUserOrderdetailMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<Orderscustom> list = ordersMapper.findOrdersUserOrderdetailMap();
		System.out.println(list);
		sqlSession.close();

	}

	@Test
	public final void testFindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
		List<User> list = ordersMapper.findUserAndItemsResultMap();
		System.out.println(list);
		sqlSession.close();

	}
}
