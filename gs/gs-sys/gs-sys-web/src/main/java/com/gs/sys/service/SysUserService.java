package com.gs.sys.service;

import java.util.List;

import com.gs.sys.model.SysUser;
import com.gs.sys.model.SysUserExample;

public interface SysUserService {
	SysUser selectByPrimaryKey(Long userId);

	List<SysUser> selectByExample(SysUserExample example);

	int insert(SysUser user);

	int deleteByPrimaryKey(Long sysUserId);
}
