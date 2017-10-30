package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.List;

public class ModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentId is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentId is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("parentId =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("parentId <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("parentId >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("parentId >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("parentId <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("parentId <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("parentId in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("parentId not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("parentId between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("parentId not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeidIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeidEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThan(Integer value) {
            addCriterion("typeId <", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andTypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeid");
            return (Criteria) this;
        }

        public Criteria andConurlIsNull() {
            addCriterion("conUrl is null");
            return (Criteria) this;
        }

        public Criteria andConurlIsNotNull() {
            addCriterion("conUrl is not null");
            return (Criteria) this;
        }

        public Criteria andConurlEqualTo(String value) {
            addCriterion("conUrl =", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlNotEqualTo(String value) {
            addCriterion("conUrl <>", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlGreaterThan(String value) {
            addCriterion("conUrl >", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlGreaterThanOrEqualTo(String value) {
            addCriterion("conUrl >=", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlLessThan(String value) {
            addCriterion("conUrl <", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlLessThanOrEqualTo(String value) {
            addCriterion("conUrl <=", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlLike(String value) {
            addCriterion("conUrl like", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlNotLike(String value) {
            addCriterion("conUrl not like", value, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlIn(List<String> values) {
            addCriterion("conUrl in", values, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlNotIn(List<String> values) {
            addCriterion("conUrl not in", values, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlBetween(String value1, String value2) {
            addCriterion("conUrl between", value1, value2, "conurl");
            return (Criteria) this;
        }

        public Criteria andConurlNotBetween(String value1, String value2) {
            addCriterion("conUrl not between", value1, value2, "conurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlIsNull() {
            addCriterion("imgeurl is null");
            return (Criteria) this;
        }

        public Criteria andImgeurlIsNotNull() {
            addCriterion("imgeurl is not null");
            return (Criteria) this;
        }

        public Criteria andImgeurlEqualTo(String value) {
            addCriterion("imgeurl =", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlNotEqualTo(String value) {
            addCriterion("imgeurl <>", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlGreaterThan(String value) {
            addCriterion("imgeurl >", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgeurl >=", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlLessThan(String value) {
            addCriterion("imgeurl <", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlLessThanOrEqualTo(String value) {
            addCriterion("imgeurl <=", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlLike(String value) {
            addCriterion("imgeurl like", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlNotLike(String value) {
            addCriterion("imgeurl not like", value, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlIn(List<String> values) {
            addCriterion("imgeurl in", values, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlNotIn(List<String> values) {
            addCriterion("imgeurl not in", values, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlBetween(String value1, String value2) {
            addCriterion("imgeurl between", value1, value2, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andImgeurlNotBetween(String value1, String value2) {
            addCriterion("imgeurl not between", value1, value2, "imgeurl");
            return (Criteria) this;
        }

        public Criteria andPaixuIsNull() {
            addCriterion("paixu is null");
            return (Criteria) this;
        }

        public Criteria andPaixuIsNotNull() {
            addCriterion("paixu is not null");
            return (Criteria) this;
        }

        public Criteria andPaixuEqualTo(Integer value) {
            addCriterion("paixu =", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotEqualTo(Integer value) {
            addCriterion("paixu <>", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuGreaterThan(Integer value) {
            addCriterion("paixu >", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuGreaterThanOrEqualTo(Integer value) {
            addCriterion("paixu >=", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuLessThan(Integer value) {
            addCriterion("paixu <", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuLessThanOrEqualTo(Integer value) {
            addCriterion("paixu <=", value, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuIn(List<Integer> values) {
            addCriterion("paixu in", values, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotIn(List<Integer> values) {
            addCriterion("paixu not in", values, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuBetween(Integer value1, Integer value2) {
            addCriterion("paixu between", value1, value2, "paixu");
            return (Criteria) this;
        }

        public Criteria andPaixuNotBetween(Integer value1, Integer value2) {
            addCriterion("paixu not between", value1, value2, "paixu");
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