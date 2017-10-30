package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsernoIsNull() {
            addCriterion("userNo is null");
            return (Criteria) this;
        }

        public Criteria andUsernoIsNotNull() {
            addCriterion("userNo is not null");
            return (Criteria) this;
        }

        public Criteria andUsernoEqualTo(String value) {
            addCriterion("userNo =", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotEqualTo(String value) {
            addCriterion("userNo <>", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoGreaterThan(String value) {
            addCriterion("userNo >", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoGreaterThanOrEqualTo(String value) {
            addCriterion("userNo >=", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLessThan(String value) {
            addCriterion("userNo <", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLessThanOrEqualTo(String value) {
            addCriterion("userNo <=", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoLike(String value) {
            addCriterion("userNo like", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotLike(String value) {
            addCriterion("userNo not like", value, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoIn(List<String> values) {
            addCriterion("userNo in", values, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotIn(List<String> values) {
            addCriterion("userNo not in", values, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoBetween(String value1, String value2) {
            addCriterion("userNo between", value1, value2, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernoNotBetween(String value1, String value2) {
            addCriterion("userNo not between", value1, value2, "userno");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
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

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNull() {
            addCriterion("deptid is null");
            return (Criteria) this;
        }

        public Criteria andDeptidIsNotNull() {
            addCriterion("deptid is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidEqualTo(Integer value) {
            addCriterion("deptid =", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotEqualTo(Integer value) {
            addCriterion("deptid <>", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThan(Integer value) {
            addCriterion("deptid >", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("deptid >=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThan(Integer value) {
            addCriterion("deptid <", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidLessThanOrEqualTo(Integer value) {
            addCriterion("deptid <=", value, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidIn(List<Integer> values) {
            addCriterion("deptid in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotIn(List<Integer> values) {
            addCriterion("deptid not in", values, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidBetween(Integer value1, Integer value2) {
            addCriterion("deptid between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptidNotBetween(Integer value1, Integer value2) {
            addCriterion("deptid not between", value1, value2, "deptid");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("deptName is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("deptName is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("deptName =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("deptName <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("deptName >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("deptName >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("deptName <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("deptName <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("deptName like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("deptName not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("deptName in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("deptName not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("deptName between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("deptName not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidIsNull() {
            addCriterion("xingzhengjibieId is null");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidIsNotNull() {
            addCriterion("xingzhengjibieId is not null");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidEqualTo(Integer value) {
            addCriterion("xingzhengjibieId =", value, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidNotEqualTo(Integer value) {
            addCriterion("xingzhengjibieId <>", value, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidGreaterThan(Integer value) {
            addCriterion("xingzhengjibieId >", value, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xingzhengjibieId >=", value, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidLessThan(Integer value) {
            addCriterion("xingzhengjibieId <", value, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidLessThanOrEqualTo(Integer value) {
            addCriterion("xingzhengjibieId <=", value, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidIn(List<Integer> values) {
            addCriterion("xingzhengjibieId in", values, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidNotIn(List<Integer> values) {
            addCriterion("xingzhengjibieId not in", values, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidBetween(Integer value1, Integer value2) {
            addCriterion("xingzhengjibieId between", value1, value2, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibieidNotBetween(Integer value1, Integer value2) {
            addCriterion("xingzhengjibieId not between", value1, value2, "xingzhengjibieid");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameIsNull() {
            addCriterion("xingzhengjibieName is null");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameIsNotNull() {
            addCriterion("xingzhengjibieName is not null");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameEqualTo(String value) {
            addCriterion("xingzhengjibieName =", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameNotEqualTo(String value) {
            addCriterion("xingzhengjibieName <>", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameGreaterThan(String value) {
            addCriterion("xingzhengjibieName >", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameGreaterThanOrEqualTo(String value) {
            addCriterion("xingzhengjibieName >=", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameLessThan(String value) {
            addCriterion("xingzhengjibieName <", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameLessThanOrEqualTo(String value) {
            addCriterion("xingzhengjibieName <=", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameLike(String value) {
            addCriterion("xingzhengjibieName like", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameNotLike(String value) {
            addCriterion("xingzhengjibieName not like", value, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameIn(List<String> values) {
            addCriterion("xingzhengjibieName in", values, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameNotIn(List<String> values) {
            addCriterion("xingzhengjibieName not in", values, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameBetween(String value1, String value2) {
            addCriterion("xingzhengjibieName between", value1, value2, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andXingzhengjibienameNotBetween(String value1, String value2) {
            addCriterion("xingzhengjibieName not between", value1, value2, "xingzhengjibiename");
            return (Criteria) this;
        }

        public Criteria andZhiwuidIsNull() {
            addCriterion("zhiwuId is null");
            return (Criteria) this;
        }

        public Criteria andZhiwuidIsNotNull() {
            addCriterion("zhiwuId is not null");
            return (Criteria) this;
        }

        public Criteria andZhiwuidEqualTo(Integer value) {
            addCriterion("zhiwuId =", value, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidNotEqualTo(Integer value) {
            addCriterion("zhiwuId <>", value, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidGreaterThan(Integer value) {
            addCriterion("zhiwuId >", value, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhiwuId >=", value, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidLessThan(Integer value) {
            addCriterion("zhiwuId <", value, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidLessThanOrEqualTo(Integer value) {
            addCriterion("zhiwuId <=", value, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidIn(List<Integer> values) {
            addCriterion("zhiwuId in", values, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidNotIn(List<Integer> values) {
            addCriterion("zhiwuId not in", values, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidBetween(Integer value1, Integer value2) {
            addCriterion("zhiwuId between", value1, value2, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwuidNotBetween(Integer value1, Integer value2) {
            addCriterion("zhiwuId not between", value1, value2, "zhiwuid");
            return (Criteria) this;
        }

        public Criteria andZhiwunameIsNull() {
            addCriterion("zhiwuName is null");
            return (Criteria) this;
        }

        public Criteria andZhiwunameIsNotNull() {
            addCriterion("zhiwuName is not null");
            return (Criteria) this;
        }

        public Criteria andZhiwunameEqualTo(String value) {
            addCriterion("zhiwuName =", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameNotEqualTo(String value) {
            addCriterion("zhiwuName <>", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameGreaterThan(String value) {
            addCriterion("zhiwuName >", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameGreaterThanOrEqualTo(String value) {
            addCriterion("zhiwuName >=", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameLessThan(String value) {
            addCriterion("zhiwuName <", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameLessThanOrEqualTo(String value) {
            addCriterion("zhiwuName <=", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameLike(String value) {
            addCriterion("zhiwuName like", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameNotLike(String value) {
            addCriterion("zhiwuName not like", value, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameIn(List<String> values) {
            addCriterion("zhiwuName in", values, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameNotIn(List<String> values) {
            addCriterion("zhiwuName not in", values, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameBetween(String value1, String value2) {
            addCriterion("zhiwuName between", value1, value2, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhiwunameNotBetween(String value1, String value2) {
            addCriterion("zhiwuName not between", value1, value2, "zhiwuname");
            return (Criteria) this;
        }

        public Criteria andZhichenidIsNull() {
            addCriterion("zhichenId is null");
            return (Criteria) this;
        }

        public Criteria andZhichenidIsNotNull() {
            addCriterion("zhichenId is not null");
            return (Criteria) this;
        }

        public Criteria andZhichenidEqualTo(Integer value) {
            addCriterion("zhichenId =", value, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidNotEqualTo(Integer value) {
            addCriterion("zhichenId <>", value, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidGreaterThan(Integer value) {
            addCriterion("zhichenId >", value, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhichenId >=", value, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidLessThan(Integer value) {
            addCriterion("zhichenId <", value, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidLessThanOrEqualTo(Integer value) {
            addCriterion("zhichenId <=", value, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidIn(List<Integer> values) {
            addCriterion("zhichenId in", values, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidNotIn(List<Integer> values) {
            addCriterion("zhichenId not in", values, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidBetween(Integer value1, Integer value2) {
            addCriterion("zhichenId between", value1, value2, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichenidNotBetween(Integer value1, Integer value2) {
            addCriterion("zhichenId not between", value1, value2, "zhichenid");
            return (Criteria) this;
        }

        public Criteria andZhichennameIsNull() {
            addCriterion("zhichenName is null");
            return (Criteria) this;
        }

        public Criteria andZhichennameIsNotNull() {
            addCriterion("zhichenName is not null");
            return (Criteria) this;
        }

        public Criteria andZhichennameEqualTo(String value) {
            addCriterion("zhichenName =", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameNotEqualTo(String value) {
            addCriterion("zhichenName <>", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameGreaterThan(String value) {
            addCriterion("zhichenName >", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameGreaterThanOrEqualTo(String value) {
            addCriterion("zhichenName >=", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameLessThan(String value) {
            addCriterion("zhichenName <", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameLessThanOrEqualTo(String value) {
            addCriterion("zhichenName <=", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameLike(String value) {
            addCriterion("zhichenName like", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameNotLike(String value) {
            addCriterion("zhichenName not like", value, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameIn(List<String> values) {
            addCriterion("zhichenName in", values, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameNotIn(List<String> values) {
            addCriterion("zhichenName not in", values, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameBetween(String value1, String value2) {
            addCriterion("zhichenName between", value1, value2, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andZhichennameNotBetween(String value1, String value2) {
            addCriterion("zhichenName not between", value1, value2, "zhichenname");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleId =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleId <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleId >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleId >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleId <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleId <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleId in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleId not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleId between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNull() {
            addCriterion("roleName is null");
            return (Criteria) this;
        }

        public Criteria andRolenameIsNotNull() {
            addCriterion("roleName is not null");
            return (Criteria) this;
        }

        public Criteria andRolenameEqualTo(String value) {
            addCriterion("roleName =", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotEqualTo(String value) {
            addCriterion("roleName <>", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThan(String value) {
            addCriterion("roleName >", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameGreaterThanOrEqualTo(String value) {
            addCriterion("roleName >=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThan(String value) {
            addCriterion("roleName <", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLessThanOrEqualTo(String value) {
            addCriterion("roleName <=", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameLike(String value) {
            addCriterion("roleName like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotLike(String value) {
            addCriterion("roleName not like", value, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameIn(List<String> values) {
            addCriterion("roleName in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotIn(List<String> values) {
            addCriterion("roleName not in", values, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameBetween(String value1, String value2) {
            addCriterion("roleName between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andRolenameNotBetween(String value1, String value2) {
            addCriterion("roleName not between", value1, value2, "rolename");
            return (Criteria) this;
        }

        public Criteria andTelcodeIsNull() {
            addCriterion("telCode is null");
            return (Criteria) this;
        }

        public Criteria andTelcodeIsNotNull() {
            addCriterion("telCode is not null");
            return (Criteria) this;
        }

        public Criteria andTelcodeEqualTo(String value) {
            addCriterion("telCode =", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotEqualTo(String value) {
            addCriterion("telCode <>", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeGreaterThan(String value) {
            addCriterion("telCode >", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("telCode >=", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLessThan(String value) {
            addCriterion("telCode <", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLessThanOrEqualTo(String value) {
            addCriterion("telCode <=", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeLike(String value) {
            addCriterion("telCode like", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotLike(String value) {
            addCriterion("telCode not like", value, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeIn(List<String> values) {
            addCriterion("telCode in", values, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotIn(List<String> values) {
            addCriterion("telCode not in", values, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeBetween(String value1, String value2) {
            addCriterion("telCode between", value1, value2, "telcode");
            return (Criteria) this;
        }

        public Criteria andTelcodeNotBetween(String value1, String value2) {
            addCriterion("telCode not between", value1, value2, "telcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeIsNull() {
            addCriterion("qqCode is null");
            return (Criteria) this;
        }

        public Criteria andQqcodeIsNotNull() {
            addCriterion("qqCode is not null");
            return (Criteria) this;
        }

        public Criteria andQqcodeEqualTo(String value) {
            addCriterion("qqCode =", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeNotEqualTo(String value) {
            addCriterion("qqCode <>", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeGreaterThan(String value) {
            addCriterion("qqCode >", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeGreaterThanOrEqualTo(String value) {
            addCriterion("qqCode >=", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeLessThan(String value) {
            addCriterion("qqCode <", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeLessThanOrEqualTo(String value) {
            addCriterion("qqCode <=", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeLike(String value) {
            addCriterion("qqCode like", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeNotLike(String value) {
            addCriterion("qqCode not like", value, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeIn(List<String> values) {
            addCriterion("qqCode in", values, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeNotIn(List<String> values) {
            addCriterion("qqCode not in", values, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeBetween(String value1, String value2) {
            addCriterion("qqCode between", value1, value2, "qqcode");
            return (Criteria) this;
        }

        public Criteria andQqcodeNotBetween(String value1, String value2) {
            addCriterion("qqCode not between", value1, value2, "qqcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeIsNull() {
            addCriterion("emailCode is null");
            return (Criteria) this;
        }

        public Criteria andEmailcodeIsNotNull() {
            addCriterion("emailCode is not null");
            return (Criteria) this;
        }

        public Criteria andEmailcodeEqualTo(String value) {
            addCriterion("emailCode =", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeNotEqualTo(String value) {
            addCriterion("emailCode <>", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeGreaterThan(String value) {
            addCriterion("emailCode >", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeGreaterThanOrEqualTo(String value) {
            addCriterion("emailCode >=", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeLessThan(String value) {
            addCriterion("emailCode <", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeLessThanOrEqualTo(String value) {
            addCriterion("emailCode <=", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeLike(String value) {
            addCriterion("emailCode like", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeNotLike(String value) {
            addCriterion("emailCode not like", value, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeIn(List<String> values) {
            addCriterion("emailCode in", values, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeNotIn(List<String> values) {
            addCriterion("emailCode not in", values, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeBetween(String value1, String value2) {
            addCriterion("emailCode between", value1, value2, "emailcode");
            return (Criteria) this;
        }

        public Criteria andEmailcodeNotBetween(String value1, String value2) {
            addCriterion("emailCode not between", value1, value2, "emailcode");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexnameIsNull() {
            addCriterion("sexName is null");
            return (Criteria) this;
        }

        public Criteria andSexnameIsNotNull() {
            addCriterion("sexName is not null");
            return (Criteria) this;
        }

        public Criteria andSexnameEqualTo(String value) {
            addCriterion("sexName =", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameNotEqualTo(String value) {
            addCriterion("sexName <>", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameGreaterThan(String value) {
            addCriterion("sexName >", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameGreaterThanOrEqualTo(String value) {
            addCriterion("sexName >=", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameLessThan(String value) {
            addCriterion("sexName <", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameLessThanOrEqualTo(String value) {
            addCriterion("sexName <=", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameLike(String value) {
            addCriterion("sexName like", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameNotLike(String value) {
            addCriterion("sexName not like", value, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameIn(List<String> values) {
            addCriterion("sexName in", values, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameNotIn(List<String> values) {
            addCriterion("sexName not in", values, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameBetween(String value1, String value2) {
            addCriterion("sexName between", value1, value2, "sexname");
            return (Criteria) this;
        }

        public Criteria andSexnameNotBetween(String value1, String value2) {
            addCriterion("sexName not between", value1, value2, "sexname");
            return (Criteria) this;
        }

        public Criteria andEduleadIsNull() {
            addCriterion("eduLead is null");
            return (Criteria) this;
        }

        public Criteria andEduleadIsNotNull() {
            addCriterion("eduLead is not null");
            return (Criteria) this;
        }

        public Criteria andEduleadEqualTo(Integer value) {
            addCriterion("eduLead =", value, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadNotEqualTo(Integer value) {
            addCriterion("eduLead <>", value, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadGreaterThan(Integer value) {
            addCriterion("eduLead >", value, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadGreaterThanOrEqualTo(Integer value) {
            addCriterion("eduLead >=", value, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadLessThan(Integer value) {
            addCriterion("eduLead <", value, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadLessThanOrEqualTo(Integer value) {
            addCriterion("eduLead <=", value, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadIn(List<Integer> values) {
            addCriterion("eduLead in", values, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadNotIn(List<Integer> values) {
            addCriterion("eduLead not in", values, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadBetween(Integer value1, Integer value2) {
            addCriterion("eduLead between", value1, value2, "edulead");
            return (Criteria) this;
        }

        public Criteria andEduleadNotBetween(Integer value1, Integer value2) {
            addCriterion("eduLead not between", value1, value2, "edulead");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeIsNull() {
            addCriterion("bangongTelCode is null");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeIsNotNull() {
            addCriterion("bangongTelCode is not null");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeEqualTo(String value) {
            addCriterion("bangongTelCode =", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeNotEqualTo(String value) {
            addCriterion("bangongTelCode <>", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeGreaterThan(String value) {
            addCriterion("bangongTelCode >", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("bangongTelCode >=", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeLessThan(String value) {
            addCriterion("bangongTelCode <", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeLessThanOrEqualTo(String value) {
            addCriterion("bangongTelCode <=", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeLike(String value) {
            addCriterion("bangongTelCode like", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeNotLike(String value) {
            addCriterion("bangongTelCode not like", value, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeIn(List<String> values) {
            addCriterion("bangongTelCode in", values, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeNotIn(List<String> values) {
            addCriterion("bangongTelCode not in", values, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeBetween(String value1, String value2) {
            addCriterion("bangongTelCode between", value1, value2, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andBangongtelcodeNotBetween(String value1, String value2) {
            addCriterion("bangongTelCode not between", value1, value2, "bangongtelcode");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNull() {
            addCriterion("positionId is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("positionId is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(Integer value) {
            addCriterion("positionId =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(Integer value) {
            addCriterion("positionId <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(Integer value) {
            addCriterion("positionId >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionId >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(Integer value) {
            addCriterion("positionId <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(Integer value) {
            addCriterion("positionId <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<Integer> values) {
            addCriterion("positionId in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<Integer> values) {
            addCriterion("positionId not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(Integer value1, Integer value2) {
            addCriterion("positionId between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(Integer value1, Integer value2) {
            addCriterion("positionId not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionnameIsNull() {
            addCriterion("positionName is null");
            return (Criteria) this;
        }

        public Criteria andPositionnameIsNotNull() {
            addCriterion("positionName is not null");
            return (Criteria) this;
        }

        public Criteria andPositionnameEqualTo(String value) {
            addCriterion("positionName =", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotEqualTo(String value) {
            addCriterion("positionName <>", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameGreaterThan(String value) {
            addCriterion("positionName >", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameGreaterThanOrEqualTo(String value) {
            addCriterion("positionName >=", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLessThan(String value) {
            addCriterion("positionName <", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLessThanOrEqualTo(String value) {
            addCriterion("positionName <=", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameLike(String value) {
            addCriterion("positionName like", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotLike(String value) {
            addCriterion("positionName not like", value, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameIn(List<String> values) {
            addCriterion("positionName in", values, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotIn(List<String> values) {
            addCriterion("positionName not in", values, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameBetween(String value1, String value2) {
            addCriterion("positionName between", value1, value2, "positionname");
            return (Criteria) this;
        }

        public Criteria andPositionnameNotBetween(String value1, String value2) {
            addCriterion("positionName not between", value1, value2, "positionname");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
}