package com.cc.sys.core.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cc.sys.core.dto.SysUser;
import com.github.pagehelper.Page;
@Mapper
public interface UserDao{
	public SysUser selectUserById(String id);
	
	public Page<SysUser> listUsers();
}
