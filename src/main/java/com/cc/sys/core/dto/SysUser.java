package com.cc.sys.core.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SysUser")
public class SysUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;				//ID
	private String name;			//姓名
	private String loginName; 		//登录名
	private String loginPassword;	//登录密码
	private String no; 				//编号
	private String secretLevle; 	//密级等级
	private Date birthday;			//出生日期
	private String sex;				//性别
	private String address; 		//住址
	private String phoneNo;			//电话号码
	private String email;			//邮箱
	private String  LockedType;		//锁定状态
	private String remark; 			//备注
	private Date createTime;		//创建时间
	private Date lastUpdateTime;	//最后更新日期
	private String createBy;		//创建人
	private String lastUpdateIp;	//最后更新日期
	private String lastUpdateBy;	//最后更新人
	private Long version;			//版本
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSecretLevle() {
		return secretLevle;
	}
	public void setSecretLevle(String secretLevle) {
		this.secretLevle = secretLevle;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLockedType() {
		return LockedType;
	}
	public void setLockedType(String lockedType) {
		LockedType = lockedType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getLastUpdateIp() {
		return lastUpdateIp;
	}
	public void setLastUpdateIp(String lastUpdateIp) {
		this.lastUpdateIp = lastUpdateIp;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
