package com.netease.homework.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.fabric.xmlrpc.base.Array;
import com.netease.homework.mapper.ContentMapper;
import com.netease.homework.mapper.OrderitemMapper;
import com.netease.homework.pojo.CartItem;
import com.netease.homework.pojo.ContentWithBLOBs;
import com.netease.homework.pojo.Orderitem;
import com.netease.homework.pojo.OrderitemExample;
import com.netease.homework.pojo.OrderitemExample.Criteria;
import com.netease.homework.service.OrderItemService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderitemMapper orderitemMapper;
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public List<Orderitem> getAll() {
		OrderitemExample example = new OrderitemExample();
		
		List<Orderitem> orderitems = orderitemMapper.selectByExample(example);
		return orderitems;
	}

	@Override
	public List<Orderitem> getFromcartItem(List<CartItem> cartItems,Integer userid) {
		// 根据id找到图片
		List<Orderitem> orderitems = new ArrayList<>(cartItems.size());
		for (CartItem cartItem : cartItems) {
			ContentWithBLOBs contentWithBLOBs = contentMapper.selectByPrimaryKey(Integer.valueOf(cartItem.getId()));
			Orderitem orderitem = new Orderitem();
			orderitem.setImage(contentWithBLOBs.getImage());
			orderitem.setContentid(contentWithBLOBs.getCid());
			orderitem.setNum(Short.valueOf(cartItem.getNum()));
			orderitem.setTitle(contentWithBLOBs.getTitle());
			orderitem.setSingleprice(contentWithBLOBs.getPrice());
			orderitems.add(orderitem);
			orderitem.setUserid(userid);
		}
		return orderitems;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Orderitem getOrderitem(Integer userId, Integer contentId) {
		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		criteria.andContentidEqualTo(contentId);
		List<Orderitem> orderitems = orderitemMapper.selectByExample(example);
		if(orderitems==null || orderitems.size()==0){
			return null;
		}
		java.util.Collections.sort(orderitems);
		//返回最新订单的条目
		return orderitems.get(0);
	}

}
