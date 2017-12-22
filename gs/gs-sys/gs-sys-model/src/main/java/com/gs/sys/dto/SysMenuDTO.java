package com.gs.sys.dto;

import java.util.List;
import java.util.Map;

public class SysMenuDTO {
	private Integer menuId;
	private String text;
	private Integer orderSeq;
	private Integer menuPid;
	private String state;
	private String menuDesc;
	private String action;
	private Integer leaf;
	private Map<String, Object> attributes;
	private List<SysMenuDTO> children;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getOrderSeq() {
		return orderSeq;
	}
	public void setOrderSeq(Integer orderSeq) {
		this.orderSeq = orderSeq;
	}
	public Integer getMenuPid() {
		return menuPid;
	}
	public void setMenuPid(Integer menuPid) {
		this.menuPid = menuPid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMenuDesc() {
		return menuDesc;
	}
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<SysMenuDTO> getChildren() {
		return children;
	}
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	public Integer getLeaf() {
		return leaf;
	}
	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public void setChildren(List<SysMenuDTO> children) {
		this.children = children;
	}
	
}
