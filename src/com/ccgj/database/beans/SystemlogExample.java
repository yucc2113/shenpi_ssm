package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemlogExample() {
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

        public Criteria andCreatusernameIsNull() {
            addCriterion("creatUserName is null");
            return (Criteria) this;
        }

        public Criteria andCreatusernameIsNotNull() {
            addCriterion("creatUserName is not null");
            return (Criteria) this;
        }

        public Criteria andCreatusernameEqualTo(String value) {
            addCriterion("creatUserName =", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameNotEqualTo(String value) {
            addCriterion("creatUserName <>", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameGreaterThan(String value) {
            addCriterion("creatUserName >", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameGreaterThanOrEqualTo(String value) {
            addCriterion("creatUserName >=", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameLessThan(String value) {
            addCriterion("creatUserName <", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameLessThanOrEqualTo(String value) {
            addCriterion("creatUserName <=", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameLike(String value) {
            addCriterion("creatUserName like", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameNotLike(String value) {
            addCriterion("creatUserName not like", value, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameIn(List<String> values) {
            addCriterion("creatUserName in", values, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameNotIn(List<String> values) {
            addCriterion("creatUserName not in", values, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameBetween(String value1, String value2) {
            addCriterion("creatUserName between", value1, value2, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatusernameNotBetween(String value1, String value2) {
            addCriterion("creatUserName not between", value1, value2, "creatusername");
            return (Criteria) this;
        }

        public Criteria andCreatuseridIsNull() {
            addCriterion("creatUserId is null");
            return (Criteria) this;
        }

        public Criteria andCreatuseridIsNotNull() {
            addCriterion("creatUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCreatuseridEqualTo(Integer value) {
            addCriterion("creatUserId =", value, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridNotEqualTo(Integer value) {
            addCriterion("creatUserId <>", value, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridGreaterThan(Integer value) {
            addCriterion("creatUserId >", value, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("creatUserId >=", value, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridLessThan(Integer value) {
            addCriterion("creatUserId <", value, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridLessThanOrEqualTo(Integer value) {
            addCriterion("creatUserId <=", value, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridIn(List<Integer> values) {
            addCriterion("creatUserId in", values, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridNotIn(List<Integer> values) {
            addCriterion("creatUserId not in", values, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridBetween(Integer value1, Integer value2) {
            addCriterion("creatUserId between", value1, value2, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andCreatuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("creatUserId not between", value1, value2, "creatuserid");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNull() {
            addCriterion("logcontent is null");
            return (Criteria) this;
        }

        public Criteria andLogcontentIsNotNull() {
            addCriterion("logcontent is not null");
            return (Criteria) this;
        }

        public Criteria andLogcontentEqualTo(String value) {
            addCriterion("logcontent =", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotEqualTo(String value) {
            addCriterion("logcontent <>", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThan(String value) {
            addCriterion("logcontent >", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentGreaterThanOrEqualTo(String value) {
            addCriterion("logcontent >=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThan(String value) {
            addCriterion("logcontent <", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLessThanOrEqualTo(String value) {
            addCriterion("logcontent <=", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentLike(String value) {
            addCriterion("logcontent like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotLike(String value) {
            addCriterion("logcontent not like", value, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentIn(List<String> values) {
            addCriterion("logcontent in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotIn(List<String> values) {
            addCriterion("logcontent not in", values, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentBetween(String value1, String value2) {
            addCriterion("logcontent between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andLogcontentNotBetween(String value1, String value2) {
            addCriterion("logcontent not between", value1, value2, "logcontent");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNull() {
            addCriterion("creatDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatdateIsNotNull() {
            addCriterion("creatDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatdateEqualTo(Date value) {
            addCriterion("creatDate =", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotEqualTo(Date value) {
            addCriterion("creatDate <>", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThan(Date value) {
            addCriterion("creatDate >", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("creatDate >=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThan(Date value) {
            addCriterion("creatDate <", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateLessThanOrEqualTo(Date value) {
            addCriterion("creatDate <=", value, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateIn(List<Date> values) {
            addCriterion("creatDate in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotIn(List<Date> values) {
            addCriterion("creatDate not in", values, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateBetween(Date value1, Date value2) {
            addCriterion("creatDate between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andCreatdateNotBetween(Date value1, Date value2) {
            addCriterion("creatDate not between", value1, value2, "creatdate");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(Integer value) {
            addCriterion("remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(Integer value) {
            addCriterion("remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(Integer value) {
            addCriterion("remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(Integer value) {
            addCriterion("remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(Integer value) {
            addCriterion("remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(Integer value) {
            addCriterion("remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<Integer> values) {
            addCriterion("remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<Integer> values) {
            addCriterion("remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(Integer value1, Integer value2) {
            addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(Integer value1, Integer value2) {
            addCriterion("remark2 not between", value1, value2, "remark2");
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