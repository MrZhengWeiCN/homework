package com.netease.homework.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1460481692353157206L;

	private Integer oid;

    private Integer uid;

    private Date time;

    private Integer price;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}