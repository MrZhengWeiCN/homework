package com.netease.homework.service;

import java.util.List;

import com.netease.homework.commons.HomeworkResult;
import com.netease.homework.pojo.Order;
import com.netease.homework.pojo.Orderitem;

public interface OrderService {

	//账单
	public List<Order> getOrders(Integer userId);
	//账单详情
	public List<Orderitem> getOrderitems(Integer orderId);
	//产生账单，也就是购买
	public void genOrder(List<Orderitem> orderitems,Integer userId);
}
