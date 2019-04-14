package com.netease.homework.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.netease.homework.mapper.ContentMapper;
import com.netease.homework.mapper.OrderMapper;
import com.netease.homework.mapper.OrderitemMapper;
import com.netease.homework.pojo.ContentWithBLOBs;
import com.netease.homework.pojo.Order;
import com.netease.homework.pojo.OrderExample;
import com.netease.homework.pojo.OrderExample.Criteria;
import com.netease.homework.pojo.Orderitem;
import com.netease.homework.pojo.OrderitemExample;
import com.netease.homework.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderitemMapper iteMapper;
	@Autowired
	private ContentMapper contentMapper;

	@Override
	public List<Order> getOrders(Integer userId) {
		OrderExample orderExample = new OrderExample();
		Criteria criteria = orderExample.createCriteria();
		criteria.andUidEqualTo(userId);
		List<Order> orders = orderMapper.selectByExample(orderExample);
		return orders;
	}

	@Override
	public List<Orderitem> getOrderitems(Integer orderId) {
		OrderitemExample example = new OrderitemExample();
		com.netease.homework.pojo.OrderitemExample.Criteria criteria = example
				.createCriteria();
		criteria.andOrderidEqualTo(orderId);
		List<Orderitem> orderitems = iteMapper.selectByExample(example);
		return orderitems;
	}

	/**
	 * 这个方法太简陋了
	 */
	@Override
	public void genOrder(List<Orderitem> orderitems, Integer userId) {
		int totalPrice = 0;
		for (Orderitem orderitem : orderitems) {
			totalPrice += orderitem.getNum() * orderitem.getSingleprice();
		}
		Order order = new Order();
		order.setUid(userId);
		order.setPrice(totalPrice);
		order.setTime(new Date());
		orderMapper.insertSelective(order);
		// 将orderId补全
		for (Orderitem orderitem : orderitems) {
			orderitem.setOrderid(order.getOid());
			iteMapper.insertSelective(orderitem);
		}
		//简易的修改库存：实际库存数量变化更加复杂
		for (Orderitem orderitem : orderitems) {
			ContentWithBLOBs contentWithBLOBs = contentMapper.selectByPrimaryKey(orderitem.getContentid());
			contentWithBLOBs.setRepertory(contentWithBLOBs.getRepertory()+orderitem.getNum());
			contentMapper.updateByPrimaryKeyWithBLOBs(contentWithBLOBs);
		}
	}

}
