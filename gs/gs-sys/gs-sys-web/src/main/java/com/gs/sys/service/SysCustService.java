package com.gs.sys.service;

import com.gs.common.PaginationExample;
import com.gs.sys.model.SysCust;

public interface SysCustService {
	public Object list(PaginationExample example);

	public void add(SysCust cust);

	public void delete(Long id);

	public SysCust selectByPrimaryKey(Long custId);

	public void update(SysCust cust);
}
