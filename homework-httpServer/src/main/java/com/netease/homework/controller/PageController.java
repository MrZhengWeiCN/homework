package com.netease.homework.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.homework.pojo.ContentWithBLOBs;
import com.netease.homework.pojo.ContentWithTag;
import com.netease.homework.pojo.Order;
import com.netease.homework.pojo.Orderitem;
import com.netease.homework.pojo.User;
import com.netease.homework.service.ContentService;
import com.netease.homework.service.OrderItemService;
import com.netease.homework.service.OrderService;


/**
 * TODO 
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>github: </p>
 * @date 2019-2-2 下午9:41:43
 * @author Zhwei
 */
@Controller
public class PageController {

	@Autowired
	private ContentService contentService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemService;
	

	@RequestMapping("/")
	public String indexPage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		User user = (User)request.getSession().getAttribute("user");
		//获取未购买商品列表
		List<ContentWithTag> allContents;
		//获取所有的
		if(user==null){
			allContents = contentService.getAllContents(0);
		}else {
			//展示未购买的
			if(request.getParameter("type")!=null && request.getParameter("type").equals("1")){
				allContents = contentService.getBuyingContents(user.getUserid());
			}else {
				//登录展示所有的
				allContents = contentService.getAllContents(user.getUserid());
			}
		}
		model.addAttribute("contentWithTags", allContents);
		return "index";
	}

	@RequestMapping("/account")
	public String accountPage(HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		List<Order> orders = orderService.getOrders(user.getUserid());
		model.addAttribute("orders", orders);
		List<Orderitem> orderItems = orderItemService.getAll();
		model.addAttribute("orderItems", orderItems);
		
		return "account";
	}

	@RequestMapping("/public")
	public String publicPage() {
		return "public";
	}

	@RequestMapping("/show")
	public String contentDetail(Model model,HttpServletRequest request ,@RequestParam Integer cid) {
		ContentWithBLOBs content = contentService.getContent(cid);
		model.addAttribute("contentWithBLOBs", content);
		User user = (User) request.getSession().getAttribute("user");
		Orderitem orderitem = orderItemService.getOrderitem(user==null?0:user.getUserid(), cid);
		if(orderitem!=null){
			model.addAttribute("oldPrice", orderitem.getSingleprice());
		}
		return "content";
	}

	@RequestMapping("/edit")
	public String editPage(Integer cid, Model model) {
		ContentWithBLOBs content = contentService.getContent(cid);
		model.addAttribute("content", content);
		return "edit";
	}

	@RequestMapping("/settleAccount")
	public String settleAccount() {
		return "settleAccount";
	}
}
