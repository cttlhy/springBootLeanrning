package com.cc.sys.core.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cc.sys.core.dao.UserDao;
import com.cc.sys.core.dto.SysUser;
import com.cc.sys.core.exception.DaoException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Resource
	private UserDao userDao;
	
	@Resource
	private StringRedisTemplate redis; 
	
	public SysUser selectUserById(String id) {
		return userDao.selectUserById(id);
	}

	@Cacheable(value = "listUsers",keyGenerator="wiselyKeyGenerator")
	public List<SysUser> listUsers() {
		//Page<SysUser> users = PageHelper.startPage(1, 3);
		//users.addAll(userDao.listUsers());
		List<SysUser> users = userDao.listUsers();
		System.out.println("1111=============>查询数据库获取列表成功！");
		
		return users;
	}
	@Cacheable(value = "listUsers1",keyGenerator="wiselyKeyGenerator")
	public PageInfo<SysUser> listUsers2() {
		PageHelper.startPage(10, 10);
		Page<SysUser> listUsers = userDao.listUsers();
		System.out.println(listUsers.size());
		PageInfo<SysUser> pinfo = new PageInfo<SysUser>(listUsers);
		System.out.println("22222=============>查询数据库获取列表成功！");
		return pinfo;
	}

	public int deleteById(int id) throws Exception {
		try {
			int res = userDao.deleteById(id);
			System.out.println("删除成功！");
			if (res > 0) {
				throw new DaoException("数据删除异常，将要回滚！");
			}
			return res;
		} catch (DaoException e) {
			throw new DaoException(e.getMessage(), e);
		}

	}

	public int insert() throws Exception {
		try {
			int res = 0;
			for (int i = 0; i < 1000; i++) {
				SysUser user = new SysUser();
				user.setId(UUID.randomUUID().toString());
				user.setName("admin"+i);
				user.setAddress("陕西");
				user.setEmail("123@112.com");
				userDao.insertSysUser(user);
				logger.info("插入数据第["+(i+1)+"]条");
				if(i>100){
					//throw new DaoException("插入数据过多，回滚！");
				}
				res++;
			}
			return res;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}

	}
	
	@CacheEvict(allEntries=true,value="*",key="*")
	public String removeAllCache(){
//		redis.delete("*");
		return "删除完毕。";
	}

}
