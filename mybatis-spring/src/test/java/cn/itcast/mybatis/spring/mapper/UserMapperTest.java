package cn.itcast.mybatis.spring.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.mybatis.spring.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserMapperTest {
	private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper userMapper;

	@Test
	public final void testFindUserById() throws Exception {
		User user = userMapper.findUserById(16);
		if (user != null)
			logger.info(user.toString());
		else
			logger.info("没查到记录");
	}

}
