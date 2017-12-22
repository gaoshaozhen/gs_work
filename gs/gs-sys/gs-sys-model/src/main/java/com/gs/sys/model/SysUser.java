package com.gs.sys.model;

import java.util.Date;

public class SysUser {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.user_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private Long userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.user_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private String userCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.password
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.user_type
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private Integer userType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.cust_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private Long custId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.role_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private Long roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.mobile
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private String mobile;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.email
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.created_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private String createdCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.created_dt
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private Date createdDt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.updated_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private String updatedCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column sys_user.updated_dt
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	private Date updatedDt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.user_id
	 * @return  the value of sys_user.user_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.user_id
	 * @param userId  the value for sys_user.user_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.user_code
	 * @return  the value of sys_user.user_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.user_code
	 * @param userCode  the value for sys_user.user_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.password
	 * @return  the value of sys_user.password
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.password
	 * @param password  the value for sys_user.password
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.user_type
	 * @return  the value of sys_user.user_type
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Integer getUserType() {
		return userType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.user_type
	 * @param userType  the value for sys_user.user_type
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.cust_id
	 * @return  the value of sys_user.cust_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Long getCustId() {
		return custId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.cust_id
	 * @param custId  the value for sys_user.cust_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setCustId(Long custId) {
		this.custId = custId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.role_id
	 * @return  the value of sys_user.role_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.role_id
	 * @param roleId  the value for sys_user.role_id
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.mobile
	 * @return  the value of sys_user.mobile
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.mobile
	 * @param mobile  the value for sys_user.mobile
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.email
	 * @return  the value of sys_user.email
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.email
	 * @param email  the value for sys_user.email
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.created_code
	 * @return  the value of sys_user.created_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getCreatedCode() {
		return createdCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.created_code
	 * @param createdCode  the value for sys_user.created_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setCreatedCode(String createdCode) {
		this.createdCode = createdCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.created_dt
	 * @return  the value of sys_user.created_dt
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Date getCreatedDt() {
		return createdDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.created_dt
	 * @param createdDt  the value for sys_user.created_dt
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.updated_code
	 * @return  the value of sys_user.updated_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getUpdatedCode() {
		return updatedCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.updated_code
	 * @param updatedCode  the value for sys_user.updated_code
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setUpdatedCode(String updatedCode) {
		this.updatedCode = updatedCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column sys_user.updated_dt
	 * @return  the value of sys_user.updated_dt
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Date getUpdatedDt() {
		return updatedDt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column sys_user.updated_dt
	 * @param updatedDt  the value for sys_user.updated_dt
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}
}