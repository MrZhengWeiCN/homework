package com.netease.homework.pojo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

public class ContentWithBLOBs extends Content implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4935094712622746305L;

	private String digest;

	private String article;

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest == null ? null : digest.trim();
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article == null ? null : article.trim();
	}

	// 用于修改
	public static ContentWithBLOBs buildFromPublicForm(
			HttpServletRequest request, Integer cid) {
		ContentWithBLOBs contentWithBLOBs = new ContentWithBLOBs();
		contentWithBLOBs.setTitle(request.getParameter("title"));
		contentWithBLOBs.setDigest(request.getParameter("summary"));
		contentWithBLOBs.setArticle(request.getParameter("detail"));
		contentWithBLOBs.setImage(request.getParameter("image"));
		int price = (int) (Double.valueOf(request.getParameter("price")) * 100);
		contentWithBLOBs.setPrice(price);
		if (cid != null) {
			contentWithBLOBs.setCid(cid);
		}
		return contentWithBLOBs;
	}

	// 用于发布
	public static ContentWithBLOBs buildFromPublicForm(
			HttpServletRequest request) {
		return buildFromPublicForm(request, null);
	}
}