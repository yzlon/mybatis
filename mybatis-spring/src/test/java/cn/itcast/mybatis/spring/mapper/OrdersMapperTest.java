package cn.itcast.mybatis.spring.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.mybatis.spring.pojo.Orderscustom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class OrdersMapperTest {
	private static final Logger logger = LoggerFactory.getLogger(OrdersMapperTest.class);

	@Autowired
	private OrdersMapper ordersMapper;

	@Test
	public final void testFindOrdersUser() throws Exception {
		List<Orderscustom> list = ordersMapper.findOrdersUser();
		if (list != null)
			logger.info(list.toString());
		else
			logger.info("没查到记录");

	}

}
