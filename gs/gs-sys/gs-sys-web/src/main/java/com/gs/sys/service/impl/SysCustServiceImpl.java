package com.gs.sys.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.common.Page;
import com.gs.common.PaginationExample;
import com.gs.sdk.web.auth.AuthAccessUtil;
import com.gs.sys.mapper.SysCustMapper;
import com.gs.sys.model.SysCust;
import com.gs.sys.service.SysCustService;

@Service
public class SysCustServiceImpl implements SysCustService {
	@Autowired
	SysCustMapper mapper;

	@Override
	public Object list(PaginationExample example) {
		Page<SysCust> page = new Page<SysCust>();
		long total = mapper.countByPageExample(example);
		page.setTotal(total);
		if (total > 0) {
//			List<SysCust> list = new ArrayList<>();
//			List<SysCust> temp = mapper.selectByPageExample(example);
//			for(int i =0; i< 30; i++){
//				list.addAll(temp);
//			}
//			page.setRows(list);
			page.setRows(mapper.selectByPageExample(example));
		}
		return page;
	}

	@Override
	public void add(SysCust cust) {
		cust.setCreatedDt(new Date());
		cust.setCreatedCode(AuthAccessUtil.getSession().getAttribute("userCode"));
		cust.setCustPid(Long.parseLong(AuthAccessUtil.getSession().getAttribute("custId")));
		mapper.insert(cust);
	}

	@Override
	public void delete(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public SysCust selectByPrimaryKey(Long custId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(custId);
	}

	@Override
	public void update(SysCust cust) {
		// TODO Auto-generated method stub
		SysCust sysCust = mapper.selectByPrimaryKey(cust.getCustId());
		sysCust.setCustName(cust.getCustName());
		sysCust.setCustPlateName(cust.getCustPlateName());
		sysCust.setAddress(cust.getAddress());
		sysCust.setUpdatedCode(AuthAccessUtil.getAttribute("userCode", String.class));
		sysCust.setUpdatedDt(new Date());
		mapper.updateByPrimaryKey(sysCust);
	}
}
