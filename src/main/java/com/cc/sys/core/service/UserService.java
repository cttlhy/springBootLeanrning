package com.cc.sys.core.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cc.sys.core.dao.UserDao;
import com.cc.sys.core.dto.SysUser;
import com.cc.sys.core.exception.DaoException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service(value="UserService")
@Transactional(propagation=Propagation.REQUIRED,value="UserService")
public class UserService {
	@Resource
	private UserDao userDao;
	
	public SysUser selectUserById(String id){
		return userDao.selectUserById(id);
	}
	
	
	public List<SysUser> listUsers(){
		Page<SysUser> users = PageHelper.startPage(1,3);
		users.addAll(userDao.listUsers());
		return users;
	}
	
	public int deleteById(int id)  throws Exception{
		try {
			int res = userDao.deleteById(id);
			System.out.println("删除成功！");
			if(res>0){
				throw new DaoException("数据删除异常，将要回滚！");
			}
			return res;
		} catch (DaoException e) {
			throw new DaoException(e.getMessage(),e);
		}
		
	}
	
	public int insert()  throws Exception{
		try {
			int res = 0;
			for(int i=0;i<5;i++){
				SysUser user = new SysUser();
				user.setId(UUID.randomUUID().toString());
				if(i==2){
					user.setAddress("陕西1111111111111111111111");
				}else{
					user.setAddress("陕西");
				}
				user.setEmail("123@112.com");
				userDao.insertSysUser(user);
				res++;
			}
			return res;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(),e);
		}
		
	}

}
