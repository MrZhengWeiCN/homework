package com.netease.homework.pojo;

import java.io.Serializable;

public class ContentWithTag implements Serializable {

	private Integer buy;
	private ContentWithBLOBs contentWithBLOBs;

	public ContentWithTag(ContentWithBLOBs contentWithBLOBs, Integer buy) {
		this.buy = buy;
		this.contentWithBLOBs = contentWithBLOBs;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1962542541018754352L;

	public Integer getBuy() {
		return buy;
	}

	public void setBuy(Integer buy) {
		this.buy = buy;
	}

	public ContentWithBLOBs getContentWithBLOBs() {
		return contentWithBLOBs;
	}

	public void setContentWithBLOBs(ContentWithBLOBs contentWithBLOBs) {
		this.contentWithBLOBs = contentWithBLOBs;
	}
}
