package com.netease.homework.service;

import java.util.List;

import com.netease.homework.pojo.User;

public interface UserService {

	public List<User> validate(String username, String password);

}
