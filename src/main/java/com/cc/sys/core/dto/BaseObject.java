package com.cc.sys.core.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class BaseObject {
	@Column(name="remark")
	private String remark; 			//备注
	
	@Column(name="create_time")
	private Date createTime;		//创建时间
	
	@Column(name="last_update_time")
	private Date lastUpdateTime;	//最后更新日期
	
	@Column(name="create_by")
	private String createBy;		//创建人
	
	@Column(name="last_update_ip")
	private String lastUpdateIp;	//最后更新IP
	
	@Column(name="last_update_by")
	private String lastUpdateBy;	//最后更新人
	
	@Column(name="version")
	private Long version;			//版本

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

	public BaseObject(String remark, Date createTime, Date lastUpdateTime, String createBy, String lastUpdateIp,
			String lastUpdateBy, Long version) {
		super();
		this.remark = remark;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
		this.createBy = createBy;
		this.lastUpdateIp = lastUpdateIp;
		this.lastUpdateBy = lastUpdateBy;
		this.version = version;
	}

	public BaseObject() {
		super();
		// TODO Auto-generated constructor stub
	}
}
