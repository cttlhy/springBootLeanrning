package com.cc.sys.core.util;

import java.util.Date;

import com.cc.sys.core.counst.PlatformConstant;
import com.cc.sys.core.dto.BaseObject;

/**
 * 该类主要用于对父类的字段进行复制
 * 
 * @author chenchao
 *
 */
public class CopyProperties {

	public static void setSysProperties(BaseObject base, PlatformConstant.ActionType type) {
		switch (type) {
		case insert:
			base.setCreateBy("");
			base.setCreateTime(new Date());
			base.setLastUpdateTime(new Date());
			base.setLastUpdateBy("");
			base.setLastUpdateIp("");
			break;
		case update:
			base.setLastUpdateTime(new Date());
			base.setLastUpdateBy("");
			base.setLastUpdateIp("");
			break;
		default:
			break;
		}
	}

}
