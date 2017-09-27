package cn.itcast.mybatis.spring.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.mybatis.spring.dao.UserDao;
import cn.itcast.mybatis.spring.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserDaoImplTest {
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);

	@Autowired
	UserDao userDao;

	@Test
	public final void testFindUserById() throws Exception {
		User user = userDao.findUserById(16);
		logger.info("*******************************");
		logger.info(user.toString());
		logger.info("*******************************");
	}

}
