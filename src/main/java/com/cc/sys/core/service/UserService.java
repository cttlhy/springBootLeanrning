package com.cc.sys.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cc.sys.core.dao.UserDao;
import com.cc.sys.core.dto.SysUser;

@Service
public class UserService {
	@Resource
	private UserDao userDao;
	
	public SysUser selectUserById(String id){
		return userDao.selectUserById(id);
	}

}
