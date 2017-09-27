package cn.itcast.mybatis.spring.pojo;

/**
 * 继承字段较多的pojo类
 * 
 * @author Q
 *
 */
public class Orderscustom extends Orders {
	private String username;
	private String sex;
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Orderscustom [username=" + username + ", sex=" + sex + ", address=" + address + ", toString()="
				+ super.toString() + "]";
	}

}
