package cn.itcast.mybatis.spring.pojo;

import java.sql.Date;
import java.util.List;

public class User {
	// 属性名和数据库字段对应
	private int id;
	private String userName;
	private String sex;
	private Date birthday;
	private String address;

	// 订单
	private List<Orders> ordersList;

	public List<Orders> getOrders() {
		return ordersList;
	}

	public void setOrders(List<Orders> orders) {
		this.ordersList = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", sex=" + sex + ", birthday=" + birthday + ", address="
				+ address + ", orders=" + ordersList + "]";
	}

}
