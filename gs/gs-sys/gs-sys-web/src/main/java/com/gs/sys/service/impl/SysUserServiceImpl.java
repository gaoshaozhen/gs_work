package com.gs.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gs.sys.mapper.SysUserMapper;
import com.gs.sys.model.SysUser;
import com.gs.sys.model.SysUserExample;
import com.gs.sys.service.SysUserService;

@Transactional
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	SysUserMapper mapper;

	@Override
	public int insert(SysUser user) {
		// TODO Auto-generated method stub
		return mapper.insert(user);
	}

	@Override
	public int deleteByPrimaryKey(Long sysUserId) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(sysUserId);
	}

	@Override
	public SysUser selectByPrimaryKey(Long userId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> selectByExample(SysUserExample example) {
		// TODO Auto-generated method stub
		return mapper.selectByExample(example);
	}
}
