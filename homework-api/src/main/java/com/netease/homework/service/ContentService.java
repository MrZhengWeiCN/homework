package com.netease.homework.service;

import java.util.List;

import com.netease.homework.commons.HResult;
import com.netease.homework.pojo.Content;
import com.netease.homework.pojo.ContentWithBLOBs;
import com.netease.homework.pojo.ContentWithTag;

public interface ContentService {

	public List<ContentWithTag> getAllContents(Integer integer);


	public boolean editContent(ContentWithBLOBs editedContent);

	public HResult putAway(ContentWithBLOBs newContent);

	/**
	 * 判断是否已经购买
	 * 
	 * @param userId
	 * @param contentId
	 * @return
	 */

	public boolean buyedContent(Integer userId, Integer contentId);

	/**
	 * 未购买的商品
	 * 
	 * @param userId
	 * @return
	 */
	public List<ContentWithTag> getBuyingContents(Integer userId);

	public ContentWithBLOBs getContent(Integer contentId);
	
	public HResult delContent(Integer cid);
}
