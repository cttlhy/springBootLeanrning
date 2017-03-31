package com.cc.sys.core.dao;

import org.springframework.stereotype.Component;

import com.cc.sys.core.bootConfig.mybaitsCF.MyMapper;
import com.cc.sys.core.dto.SysUser;

@Component
public interface UserDao extends MyMapper<SysUser>{
	public SysUser selectUserById(String id);
}
