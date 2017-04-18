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
import com.cc.sys.core.util.PageParameter;
import com.cc.sys.core.util.QueryReqBean;
import com.cc.sys.core.util.QueryResponseBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
		List<SysUser> users = userDao.listUsers(new SysUser());
		return users;
	}
	@Cacheable(value = "listUsers1",keyGenerator="wiselyKeyGenerator")
	public QueryResponseBean<SysUser> listUsers2(QueryReqBean<SysUser> reqBean) {
		
		PageParameter pageParameter = reqBean.getPageParameter();
		SysUser searchParams = reqBean.getSearchParams();
		PageHelper.startPage(pageParameter.getPage(), pageParameter.getRows());
		Page<SysUser> listUsers = userDao.listUsers(searchParams);
		QueryResponseBean<SysUser> queryRespBean =new QueryResponseBean<SysUser>();
		queryRespBean.setResult(listUsers);
		logger.info("listUsers2获取结果集请求数据库成功并返回【"+listUsers.getResult().size()+"】条记录");
		return queryRespBean;
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
		return "删除完毕。";
	}

}
