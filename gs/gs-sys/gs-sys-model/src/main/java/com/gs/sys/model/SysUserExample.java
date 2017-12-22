package com.gs.sys.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public SysUserExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNull() {
			addCriterion("user_code is null");
			return (Criteria) this;
		}

		public Criteria andUserCodeIsNotNull() {
			addCriterion("user_code is not null");
			return (Criteria) this;
		}

		public Criteria andUserCodeEqualTo(String value) {
			addCriterion("user_code =", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotEqualTo(String value) {
			addCriterion("user_code <>", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThan(String value) {
			addCriterion("user_code >", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
			addCriterion("user_code >=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThan(String value) {
			addCriterion("user_code <", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLessThanOrEqualTo(String value) {
			addCriterion("user_code <=", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeLike(String value) {
			addCriterion("user_code like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotLike(String value) {
			addCriterion("user_code not like", value, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeIn(List<String> values) {
			addCriterion("user_code in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotIn(List<String> values) {
			addCriterion("user_code not in", values, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeBetween(String value1, String value2) {
			addCriterion("user_code between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andUserCodeNotBetween(String value1, String value2) {
			addCriterion("user_code not between", value1, value2, "userCode");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNull() {
			addCriterion("user_type is null");
			return (Criteria) this;
		}

		public Criteria andUserTypeIsNotNull() {
			addCriterion("user_type is not null");
			return (Criteria) this;
		}

		public Criteria andUserTypeEqualTo(Integer value) {
			addCriterion("user_type =", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotEqualTo(Integer value) {
			addCriterion("user_type <>", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThan(Integer value) {
			addCriterion("user_type >", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_type >=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThan(Integer value) {
			addCriterion("user_type <", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeLessThanOrEqualTo(Integer value) {
			addCriterion("user_type <=", value, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeIn(List<Integer> values) {
			addCriterion("user_type in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotIn(List<Integer> values) {
			addCriterion("user_type not in", values, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeBetween(Integer value1, Integer value2) {
			addCriterion("user_type between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andUserTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("user_type not between", value1, value2, "userType");
			return (Criteria) this;
		}

		public Criteria andCustIdIsNull() {
			addCriterion("cust_id is null");
			return (Criteria) this;
		}

		public Criteria andCustIdIsNotNull() {
			addCriterion("cust_id is not null");
			return (Criteria) this;
		}

		public Criteria andCustIdEqualTo(Long value) {
			addCriterion("cust_id =", value, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdNotEqualTo(Long value) {
			addCriterion("cust_id <>", value, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdGreaterThan(Long value) {
			addCriterion("cust_id >", value, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
			addCriterion("cust_id >=", value, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdLessThan(Long value) {
			addCriterion("cust_id <", value, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdLessThanOrEqualTo(Long value) {
			addCriterion("cust_id <=", value, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdIn(List<Long> values) {
			addCriterion("cust_id in", values, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdNotIn(List<Long> values) {
			addCriterion("cust_id not in", values, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdBetween(Long value1, Long value2) {
			addCriterion("cust_id between", value1, value2, "custId");
			return (Criteria) this;
		}

		public Criteria andCustIdNotBetween(Long value1, Long value2) {
			addCriterion("cust_id not between", value1, value2, "custId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNull() {
			addCriterion("role_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("role_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(Long value) {
			addCriterion("role_id =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(Long value) {
			addCriterion("role_id <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(Long value) {
			addCriterion("role_id >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
			addCriterion("role_id >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(Long value) {
			addCriterion("role_id <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(Long value) {
			addCriterion("role_id <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<Long> values) {
			addCriterion("role_id in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<Long> values) {
			addCriterion("role_id not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(Long value1, Long value2) {
			addCriterion("role_id between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(Long value1, Long value2) {
			addCriterion("role_id not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("mobile is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("mobile is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("mobile =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("mobile <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("mobile >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("mobile >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("mobile <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("mobile <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("mobile like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("mobile not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("mobile in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("mobile not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("mobile between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("mobile not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeIsNull() {
			addCriterion("created_code is null");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeIsNotNull() {
			addCriterion("created_code is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeEqualTo(String value) {
			addCriterion("created_code =", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeNotEqualTo(String value) {
			addCriterion("created_code <>", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeGreaterThan(String value) {
			addCriterion("created_code >", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeGreaterThanOrEqualTo(String value) {
			addCriterion("created_code >=", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeLessThan(String value) {
			addCriterion("created_code <", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeLessThanOrEqualTo(String value) {
			addCriterion("created_code <=", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeLike(String value) {
			addCriterion("created_code like", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeNotLike(String value) {
			addCriterion("created_code not like", value, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeIn(List<String> values) {
			addCriterion("created_code in", values, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeNotIn(List<String> values) {
			addCriterion("created_code not in", values, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeBetween(String value1, String value2) {
			addCriterion("created_code between", value1, value2, "createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedCodeNotBetween(String value1, String value2) {
			addCriterion("created_code not between", value1, value2,
					"createdCode");
			return (Criteria) this;
		}

		public Criteria andCreatedDtIsNull() {
			addCriterion("created_dt is null");
			return (Criteria) this;
		}

		public Criteria andCreatedDtIsNotNull() {
			addCriterion("created_dt is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedDtEqualTo(Date value) {
			addCriterion("created_dt =", value, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtNotEqualTo(Date value) {
			addCriterion("created_dt <>", value, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtGreaterThan(Date value) {
			addCriterion("created_dt >", value, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
			addCriterion("created_dt >=", value, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtLessThan(Date value) {
			addCriterion("created_dt <", value, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
			addCriterion("created_dt <=", value, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtIn(List<Date> values) {
			addCriterion("created_dt in", values, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtNotIn(List<Date> values) {
			addCriterion("created_dt not in", values, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtBetween(Date value1, Date value2) {
			addCriterion("created_dt between", value1, value2, "createdDt");
			return (Criteria) this;
		}

		public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
			addCriterion("created_dt not between", value1, value2, "createdDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeIsNull() {
			addCriterion("updated_code is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeIsNotNull() {
			addCriterion("updated_code is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeEqualTo(String value) {
			addCriterion("updated_code =", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeNotEqualTo(String value) {
			addCriterion("updated_code <>", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeGreaterThan(String value) {
			addCriterion("updated_code >", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeGreaterThanOrEqualTo(String value) {
			addCriterion("updated_code >=", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeLessThan(String value) {
			addCriterion("updated_code <", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeLessThanOrEqualTo(String value) {
			addCriterion("updated_code <=", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeLike(String value) {
			addCriterion("updated_code like", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeNotLike(String value) {
			addCriterion("updated_code not like", value, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeIn(List<String> values) {
			addCriterion("updated_code in", values, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeNotIn(List<String> values) {
			addCriterion("updated_code not in", values, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeBetween(String value1, String value2) {
			addCriterion("updated_code between", value1, value2, "updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedCodeNotBetween(String value1, String value2) {
			addCriterion("updated_code not between", value1, value2,
					"updatedCode");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtIsNull() {
			addCriterion("updated_dt is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtIsNotNull() {
			addCriterion("updated_dt is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtEqualTo(Date value) {
			addCriterion("updated_dt =", value, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtNotEqualTo(Date value) {
			addCriterion("updated_dt <>", value, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtGreaterThan(Date value) {
			addCriterion("updated_dt >", value, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtGreaterThanOrEqualTo(Date value) {
			addCriterion("updated_dt >=", value, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtLessThan(Date value) {
			addCriterion("updated_dt <", value, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtLessThanOrEqualTo(Date value) {
			addCriterion("updated_dt <=", value, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtIn(List<Date> values) {
			addCriterion("updated_dt in", values, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtNotIn(List<Date> values) {
			addCriterion("updated_dt not in", values, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtBetween(Date value1, Date value2) {
			addCriterion("updated_dt between", value1, value2, "updatedDt");
			return (Criteria) this;
		}

		public Criteria andUpdatedDtNotBetween(Date value1, Date value2) {
			addCriterion("updated_dt not between", value1, value2, "updatedDt");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table sys_user
	 * @mbggenerated  Sun Nov 26 17:47:50 CST 2017
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_user
     *
     * @mbggenerated do_not_delete_during_merge Sun Nov 26 00:38:20 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}