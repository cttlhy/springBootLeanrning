package com.cc.sys.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cc.sys.core.dto.SysUser;
@Mapper
public interface UserDao{
	public SysUser selectUserById(String id);
	
	public List<SysUser> listUsers();
}
