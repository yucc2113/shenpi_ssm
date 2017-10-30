package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.List;

public class LiuchengDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LiuchengDetailExample() {
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

        public Criteria andShenpiidIsNull() {
            addCriterion("shenpiId is null");
            return (Criteria) this;
        }

        public Criteria andShenpiidIsNotNull() {
            addCriterion("shenpiId is not null");
            return (Criteria) this;
        }

        public Criteria andShenpiidEqualTo(Integer value) {
            addCriterion("shenpiId =", value, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidNotEqualTo(Integer value) {
            addCriterion("shenpiId <>", value, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidGreaterThan(Integer value) {
            addCriterion("shenpiId >", value, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("shenpiId >=", value, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidLessThan(Integer value) {
            addCriterion("shenpiId <", value, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidLessThanOrEqualTo(Integer value) {
            addCriterion("shenpiId <=", value, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidIn(List<Integer> values) {
            addCriterion("shenpiId in", values, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidNotIn(List<Integer> values) {
            addCriterion("shenpiId not in", values, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidBetween(Integer value1, Integer value2) {
            addCriterion("shenpiId between", value1, value2, "shenpiid");
            return (Criteria) this;
        }

        public Criteria andShenpiidNotBetween(Integer value1, Integer value2) {
            addCriterion("shenpiId not between", value1, value2, "shenpiid");
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

        public Criteria andMingchenIsNull() {
            addCriterion("mingchen is null");
            return (Criteria) this;
        }

        public Criteria andMingchenIsNotNull() {
            addCriterion("mingchen is not null");
            return (Criteria) this;
        }

        public Criteria andMingchenEqualTo(String value) {
            addCriterion("mingchen =", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenNotEqualTo(String value) {
            addCriterion("mingchen <>", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenGreaterThan(String value) {
            addCriterion("mingchen >", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenGreaterThanOrEqualTo(String value) {
            addCriterion("mingchen >=", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenLessThan(String value) {
            addCriterion("mingchen <", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenLessThanOrEqualTo(String value) {
            addCriterion("mingchen <=", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenLike(String value) {
            addCriterion("mingchen like", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenNotLike(String value) {
            addCriterion("mingchen not like", value, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenIn(List<String> values) {
            addCriterion("mingchen in", values, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenNotIn(List<String> values) {
            addCriterion("mingchen not in", values, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenBetween(String value1, String value2) {
            addCriterion("mingchen between", value1, value2, "mingchen");
            return (Criteria) this;
        }

        public Criteria andMingchenNotBetween(String value1, String value2) {
            addCriterion("mingchen not between", value1, value2, "mingchen");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNull() {
            addCriterion("leixing is null");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNotNull() {
            addCriterion("leixing is not null");
            return (Criteria) this;
        }

        public Criteria andLeixingEqualTo(Integer value) {
            addCriterion("leixing =", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotEqualTo(Integer value) {
            addCriterion("leixing <>", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThan(Integer value) {
            addCriterion("leixing >", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThanOrEqualTo(Integer value) {
            addCriterion("leixing >=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThan(Integer value) {
            addCriterion("leixing <", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThanOrEqualTo(Integer value) {
            addCriterion("leixing <=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingIn(List<Integer> values) {
            addCriterion("leixing in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotIn(List<Integer> values) {
            addCriterion("leixing not in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingBetween(Integer value1, Integer value2) {
            addCriterion("leixing between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotBetween(Integer value1, Integer value2) {
            addCriterion("leixing not between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andNeirongValueIsNull() {
            addCriterion("neirong_value is null");
            return (Criteria) this;
        }

        public Criteria andNeirongValueIsNotNull() {
            addCriterion("neirong_value is not null");
            return (Criteria) this;
        }

        public Criteria andNeirongValueEqualTo(String value) {
            addCriterion("neirong_value =", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueNotEqualTo(String value) {
            addCriterion("neirong_value <>", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueGreaterThan(String value) {
            addCriterion("neirong_value >", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueGreaterThanOrEqualTo(String value) {
            addCriterion("neirong_value >=", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueLessThan(String value) {
            addCriterion("neirong_value <", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueLessThanOrEqualTo(String value) {
            addCriterion("neirong_value <=", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueLike(String value) {
            addCriterion("neirong_value like", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueNotLike(String value) {
            addCriterion("neirong_value not like", value, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueIn(List<String> values) {
            addCriterion("neirong_value in", values, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueNotIn(List<String> values) {
            addCriterion("neirong_value not in", values, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueBetween(String value1, String value2) {
            addCriterion("neirong_value between", value1, value2, "neirongValue");
            return (Criteria) this;
        }

        public Criteria andNeirongValueNotBetween(String value1, String value2) {
            addCriterion("neirong_value not between", value1, value2, "neirongValue");
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