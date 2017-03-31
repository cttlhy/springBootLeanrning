package com.cc.sys.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.sys.core.dao.UserDao;
import com.cc.sys.core.dto.SysUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	public SysUser selectUserById(String id){
		return userDao.selectUserById(id);
	}
	
	
	public List<SysUser> listUsers(){
		Page<SysUser> users = PageHelper.startPage(2,5);
		users.addAll(userDao.listUsers());
		return users;
	}

}
