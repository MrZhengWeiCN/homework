package com.netease.homework.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.homework.commons.HResult;
import com.netease.homework.commons.JsonUtils;
import com.netease.homework.mapper.ContentMapper;
import com.netease.homework.mapper.OrderMapper;
import com.netease.homework.mapper.OrderitemMapper;
import com.netease.homework.pojo.Content;
import com.netease.homework.pojo.ContentExample;
import com.netease.homework.pojo.ContentExample.Criteria;
import com.netease.homework.pojo.ContentWithBLOBs;
import com.netease.homework.pojo.ContentWithTag;
import com.netease.homework.pojo.Order;
import com.netease.homework.pojo.OrderExample;
import com.netease.homework.pojo.Orderitem;
import com.netease.homework.pojo.OrderitemExample;
import com.netease.homework.service.ContentService;

public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderitemMapper iteMapper;

	/**
	 * w沒登錄userid默认为0
	 */
	@Override
	public List<ContentWithTag> getAllContents(Integer userId) {
		ContentExample contentExample = new ContentExample();
		Criteria criteria = contentExample.createCriteria();
		criteria.andStatusEqualTo((byte) 1);
		// 找到所有商品
		List<ContentWithBLOBs> contentList = contentMapper
				.selectByExampleWithBLOBs(contentExample);
		List<ContentWithTag> contentWithTags = new ArrayList<>(
				contentList.size());
		for (ContentWithBLOBs contentWithBLOBs : contentList) {
			ContentWithTag contentWithTag;
			// 没登录或者没购买
			if (userId == 0 || !buyedContent(userId, contentWithBLOBs.getCid())) {
				contentWithTag = new ContentWithTag(contentWithBLOBs, 0);
			} else {
				contentWithTag = new ContentWithTag(contentWithBLOBs, 1);
			}
			contentWithTags.add(contentWithTag);
		}
		return contentWithTags;
	}

	@Override
	public boolean editContent(ContentWithBLOBs editedContent) {
		try {
			contentMapper.updateByPrimaryKeySelective(editedContent);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public HResult putAway(ContentWithBLOBs newContent) {
		try {
			contentMapper.insertSelective(newContent);
			return HResult.ok(newContent.getCid().toString());
		} catch (Exception e) {
			e.printStackTrace();
			return HResult.build(500, "上架失败:" + e.getMessage());
		}
	}

	/**
	 * 判断是否已经购买
	 */
	@Override
	public boolean buyedContent(Integer userId, Integer contentId) {
		// 直接查找订单明细表
		OrderitemExample example = new OrderitemExample();
		com.netease.homework.pojo.OrderitemExample.Criteria criteria = example
				.createCriteria();
		criteria.andContentidEqualTo(contentId);
		criteria.andUseridEqualTo(userId);
		List<Orderitem> orderitems = iteMapper.selectByExample(example);
		if (orderitems != null && orderitems.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 未购买的商品，效率有点低，需要N次打开连接，应该是直接查找出购买的商品然后和 总的商品列表进行聚合，找出未购买的商品
	 */
	@Override
	public List<ContentWithTag> getBuyingContents(Integer userId) {
		// 首先获得所有的商品
		List<ContentWithTag> allContents = getAllContents(userId);
		List<ContentWithTag> buyingContents = new ArrayList<>();
		// 判断是否已经购买
		for (ContentWithTag contentWithTag : allContents) {
			if (contentWithTag.getBuy() == 0) {
				buyingContents.add(contentWithTag);
			}
		}
		return buyingContents;
	}

	@Override
	public ContentWithBLOBs getContent(Integer contentId) {
		return contentMapper.selectByPrimaryKey(contentId);
	}

	@Override
	public HResult delContent(Integer cid) {
		ContentWithBLOBs contentWithBLOBs = contentMapper
				.selectByPrimaryKey(cid);
		contentWithBLOBs.setStatus((byte) 0);
		try {
			contentMapper.updateByPrimaryKeySelective(contentWithBLOBs);
			return HResult.ok();
		} catch (Exception e) {
			return HResult.build(500, "下架失败，错误：" + e.getMessage());
		}
	}
}
