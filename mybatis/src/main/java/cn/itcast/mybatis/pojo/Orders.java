package cn.itcast.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class Orders {
	private int id;
	private int user_id;
	private String number;
	private Date createtime;
	private String note;

	private User user;

	// 订单明细
	List<Orderdetail> orderdetails;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", user_id=" + user_id + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", user=" + user + ", orderdetails=" + orderdetails + "]";
	}
}
