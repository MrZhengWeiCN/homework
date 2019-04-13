package com.netease.homework.service;

import java.util.List;

import com.netease.homework.pojo.CartItem;
import com.netease.homework.pojo.Orderitem;

public interface OrderItemService {
	
	public List<Orderitem> getAll();

	public List<Orderitem> getFromcartItem(List<CartItem> cartItems,Integer userid);
	
	public Orderitem getOrderitem(Integer userId,Integer contentId);
}
