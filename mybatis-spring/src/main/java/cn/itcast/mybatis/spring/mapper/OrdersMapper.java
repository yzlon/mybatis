package cn.itcast.mybatis.spring.mapper;

import java.util.List;

import cn.itcast.mybatis.spring.pojo.Orderscustom;
import cn.itcast.mybatis.spring.pojo.User;

/*相当于dao*/
public interface OrdersMapper {
	public List<Orderscustom> findOrdersUser() throws Exception;

	public List<Orderscustom> findOrdersUserMap() throws Exception;

	public List<Orderscustom> findOrdersUserOrderdetailMap() throws Exception;

	public List<User> findUserAndItemsResultMap() throws Exception;

}
