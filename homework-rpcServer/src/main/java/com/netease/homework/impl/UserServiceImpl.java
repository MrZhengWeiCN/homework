package com.netease.homework.impl;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;

import com.netease.homework.mapper.UserMapper;
import com.netease.homework.pojo.User;
import com.netease.homework.pojo.UserExample;
import com.netease.homework.pojo.UserExample.Criteria;
import com.netease.homework.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> validate(String username, String password) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(example);
		return users;
	}

}
