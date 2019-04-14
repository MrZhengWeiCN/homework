package com.netease.homework.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.netease.homework.commons.HResult;
import com.netease.homework.commons.JsonUtils;
import com.netease.homework.pojo.CartItem;
import com.netease.homework.pojo.ContentWithBLOBs;
import com.netease.homework.pojo.Orderitem;
import com.netease.homework.pojo.User;
import com.netease.homework.service.ContentService;
import com.netease.homework.service.OrderItemService;
import com.netease.homework.service.OrderService;

@Controller
public class ProcessController {

	@Autowired
	private ContentService contentService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping("/publicSubmit")
	public String publicSubmit(HttpServletRequest request, Model model) {
		// 由于发布表单的各个字段name与ContentWithBLOBs有一些差别，所以还要转换
		HResult result = contentService.putAway(ContentWithBLOBs
				.buildFromPublicForm(request));
		model.addAttribute("cid", Integer.valueOf(result.getResult()));
		return "submit";
	}

	@RequestMapping("/editSubmit")
	public String editSubmit(@RequestParam Integer cid, Model model,
			HttpServletRequest request) {
		contentService.editContent(ContentWithBLOBs.buildFromPublicForm(
				request, cid));
		model.addAttribute("cid", cid);
		return "submit";

	}

	@RequestMapping("/api/upload")
	@ResponseBody
	public HResult uploadFile(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		if (!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			String realPath = request.getSession().getServletContext()
					.getRealPath("WEB-INF/image");
			System.out.println(realPath);
			File newFile = new File(realPath, filename);
			try {
				file.transferTo(newFile);
				String imageURL = "/image" + "/" + filename;
				return HResult.build(200, imageURL);
			} catch (IllegalStateException | IOException e) {
				return HResult.build(500, "error upload");
			}
		}
		return HResult.build(500, "文件上传错误");
	}

	@RequestMapping("/api/delete")
	@ResponseBody
	public HResult delete(@RequestParam Integer id) {
		return contentService.delContent(id);
	}

	@RequestMapping("/api/buy")
	@ResponseBody
	public HResult buy(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("products")) {
				List<CartItem> cartItems = JsonUtils.jsonToList(
						cookie.getValue(), CartItem.class);
				List<Orderitem> orderitems = new ArrayList<>(cartItems.size());
				for (CartItem cartItem : cartItems) {
					orderitems.add(Orderitem.getFromcartItem(cartItem));
				}
				User user = (User) request.getSession().getAttribute("user");
				orderService.genOrder(orderitems, user.getUserid());
				break;
			}
		}
		return HResult.ok();
	}
}
