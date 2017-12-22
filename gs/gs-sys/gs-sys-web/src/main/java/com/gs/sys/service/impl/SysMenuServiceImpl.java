package com.gs.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.sys.dto.SysMenuDTO;
import com.gs.sys.mapper.SysMenuMapper;
import com.gs.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	SysMenuMapper mapper;

	@Override
	public List<SysMenuDTO> getAllMenu() {
		List<SysMenuDTO> list = mapper.getAllMenu();
		List<SysMenuDTO> menuList1 = new ArrayList<>();
		for (SysMenuDTO menu1 : list) {
//			menu1.setState(Objects.equals(menu1.getLeaf(), 1) ? "closed" : null);
			Map<String, Object> attributes = new HashMap<>();
			if(StringUtils.isNotBlank(menu1.getAction())){
				attributes.put("url", menu1.getAction());
			}
			menu1.setAttributes(attributes);
			if (Objects.equals(menu1.getMenuPid(), 0)) {				
				List<SysMenuDTO> menuList2 = new ArrayList<>();
				for (SysMenuDTO menu2 : list) {
					if (Objects.equals(menu2.getMenuPid(), menu1.getMenuId())) {
						menuList2.add(menu2);// 添加第二层菜单
					}
					menu1.setChildren(menuList2);
				}
				menuList1.add(menu1);
			}
		}
		return menuList1;
	}
}
