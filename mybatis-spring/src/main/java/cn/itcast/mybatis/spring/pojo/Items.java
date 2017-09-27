package cn.itcast.mybatis.spring.pojo;

import java.util.Date;

public class Items {
	private int id;
	private String name;
	private double price;
	private String detail;
	private String pic;
	private Date createtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Date getCreatetimie() {
		return createtime;
	}

	public void setCreatetimie(Date createtimie) {
		this.createtime = createtimie;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", pic=" + pic
				+ ", createtimie=" + createtime + "]";
	}

}
