package cn.itcast.mybatis.spring.pojo;

import java.util.List;

//包装类
public class UserQueryVo {
	private List<Integer> ids;
	// 在这里包装查询条件
	// 用户查询条件
	private UserCustom userCustom;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	// 可以包装其他查询条件，比如订单、商品

}
