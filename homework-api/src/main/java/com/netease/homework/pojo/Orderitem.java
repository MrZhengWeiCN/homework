package com.netease.homework.pojo;

import java.io.Serializable;

public class Orderitem implements Serializable, Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 517870434081091828L;

	private Integer itemid;

	private Integer contentid;

	private Integer orderid;

	private Short num;

	private String title;

	private Integer singleprice;

	private String image;

	private Integer userid;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getContentid() {
		return contentid;
	}

	public void setContentid(Integer contentid) {
		this.contentid = contentid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Short getNum() {
		return num;
	}

	public void setNum(Short num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Integer getSingleprice() {
		return singleprice;
	}

	public void setSingleprice(Integer singleprice) {
		this.singleprice = singleprice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public int compareTo(Object o) {
		Orderitem o1 = (Orderitem) o;
		if (this.orderid <= o1.orderid) {
			return 1;
		} else {
			return -1;
		}
	}

	public static Orderitem getFromcartItem(CartItem cartItem) {
		Orderitem orderitem = new Orderitem();
		orderitem.setNum(Short.valueOf(cartItem.getNum()));
		orderitem.setItemid(Integer.valueOf(cartItem.getId()));
		orderitem.setSingleprice(Integer.valueOf(cartItem.getPrice()));
		cartItem.setTitle(cartItem.getTitle());
		return orderitem;
	}
}