package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.List;

public class DefineNeirongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DefineNeirongExample() {
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

        public Criteria andBaiodanidIsNull() {
            addCriterion("baiodanId is null");
            return (Criteria) this;
        }

        public Criteria andBaiodanidIsNotNull() {
            addCriterion("baiodanId is not null");
            return (Criteria) this;
        }

        public Criteria andBaiodanidEqualTo(Integer value) {
            addCriterion("baiodanId =", value, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidNotEqualTo(Integer value) {
            addCriterion("baiodanId <>", value, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidGreaterThan(Integer value) {
            addCriterion("baiodanId >", value, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("baiodanId >=", value, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidLessThan(Integer value) {
            addCriterion("baiodanId <", value, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidLessThanOrEqualTo(Integer value) {
            addCriterion("baiodanId <=", value, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidIn(List<Integer> values) {
            addCriterion("baiodanId in", values, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidNotIn(List<Integer> values) {
            addCriterion("baiodanId not in", values, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidBetween(Integer value1, Integer value2) {
            addCriterion("baiodanId between", value1, value2, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andBaiodanidNotBetween(Integer value1, Integer value2) {
            addCriterion("baiodanId not between", value1, value2, "baiodanid");
            return (Criteria) this;
        }

        public Criteria andMingchengIsNull() {
            addCriterion("mingcheng is null");
            return (Criteria) this;
        }

        public Criteria andMingchengIsNotNull() {
            addCriterion("mingcheng is not null");
            return (Criteria) this;
        }

        public Criteria andMingchengEqualTo(String value) {
            addCriterion("mingcheng =", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotEqualTo(String value) {
            addCriterion("mingcheng <>", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengGreaterThan(String value) {
            addCriterion("mingcheng >", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengGreaterThanOrEqualTo(String value) {
            addCriterion("mingcheng >=", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLessThan(String value) {
            addCriterion("mingcheng <", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLessThanOrEqualTo(String value) {
            addCriterion("mingcheng <=", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengLike(String value) {
            addCriterion("mingcheng like", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotLike(String value) {
            addCriterion("mingcheng not like", value, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengIn(List<String> values) {
            addCriterion("mingcheng in", values, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotIn(List<String> values) {
            addCriterion("mingcheng not in", values, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengBetween(String value1, String value2) {
            addCriterion("mingcheng between", value1, value2, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andMingchengNotBetween(String value1, String value2) {
            addCriterion("mingcheng not between", value1, value2, "mingcheng");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingIsNull() {
            addCriterion("leidanleixing is null");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingIsNotNull() {
            addCriterion("leidanleixing is not null");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingEqualTo(Integer value) {
            addCriterion("leidanleixing =", value, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingNotEqualTo(Integer value) {
            addCriterion("leidanleixing <>", value, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingGreaterThan(Integer value) {
            addCriterion("leidanleixing >", value, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingGreaterThanOrEqualTo(Integer value) {
            addCriterion("leidanleixing >=", value, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingLessThan(Integer value) {
            addCriterion("leidanleixing <", value, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingLessThanOrEqualTo(Integer value) {
            addCriterion("leidanleixing <=", value, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingIn(List<Integer> values) {
            addCriterion("leidanleixing in", values, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingNotIn(List<Integer> values) {
            addCriterion("leidanleixing not in", values, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingBetween(Integer value1, Integer value2) {
            addCriterion("leidanleixing between", value1, value2, "leidanleixing");
            return (Criteria) this;
        }

        public Criteria andLeidanleixingNotBetween(Integer value1, Integer value2) {
            addCriterion("leidanleixing not between", value1, value2, "leidanleixing");
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