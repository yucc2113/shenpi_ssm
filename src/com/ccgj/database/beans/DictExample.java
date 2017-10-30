package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.List;

public class DictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictExample() {
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

        public Criteria andPropIsNull() {
            addCriterion("prop is null");
            return (Criteria) this;
        }

        public Criteria andPropIsNotNull() {
            addCriterion("prop is not null");
            return (Criteria) this;
        }

        public Criteria andPropEqualTo(String value) {
            addCriterion("prop =", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotEqualTo(String value) {
            addCriterion("prop <>", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropGreaterThan(String value) {
            addCriterion("prop >", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropGreaterThanOrEqualTo(String value) {
            addCriterion("prop >=", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLessThan(String value) {
            addCriterion("prop <", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLessThanOrEqualTo(String value) {
            addCriterion("prop <=", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLike(String value) {
            addCriterion("prop like", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotLike(String value) {
            addCriterion("prop not like", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropIn(List<String> values) {
            addCriterion("prop in", values, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotIn(List<String> values) {
            addCriterion("prop not in", values, "prop");
            return (Criteria) this;
        }

        public Criteria andPropBetween(String value1, String value2) {
            addCriterion("prop between", value1, value2, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotBetween(String value1, String value2) {
            addCriterion("prop not between", value1, value2, "prop");
            return (Criteria) this;
        }

        public Criteria andTypesIsNull() {
            addCriterion("types is null");
            return (Criteria) this;
        }

        public Criteria andTypesIsNotNull() {
            addCriterion("types is not null");
            return (Criteria) this;
        }

        public Criteria andTypesEqualTo(String value) {
            addCriterion("types =", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesNotEqualTo(String value) {
            addCriterion("types <>", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesGreaterThan(String value) {
            addCriterion("types >", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesGreaterThanOrEqualTo(String value) {
            addCriterion("types >=", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesLessThan(String value) {
            addCriterion("types <", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesLessThanOrEqualTo(String value) {
            addCriterion("types <=", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesLike(String value) {
            addCriterion("types like", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesNotLike(String value) {
            addCriterion("types not like", value, "types");
            return (Criteria) this;
        }

        public Criteria andTypesIn(List<String> values) {
            addCriterion("types in", values, "types");
            return (Criteria) this;
        }

        public Criteria andTypesNotIn(List<String> values) {
            addCriterion("types not in", values, "types");
            return (Criteria) this;
        }

        public Criteria andTypesBetween(String value1, String value2) {
            addCriterion("types between", value1, value2, "types");
            return (Criteria) this;
        }

        public Criteria andTypesNotBetween(String value1, String value2) {
            addCriterion("types not between", value1, value2, "types");
            return (Criteria) this;
        }

        public Criteria andMemosIsNull() {
            addCriterion("memos is null");
            return (Criteria) this;
        }

        public Criteria andMemosIsNotNull() {
            addCriterion("memos is not null");
            return (Criteria) this;
        }

        public Criteria andMemosEqualTo(String value) {
            addCriterion("memos =", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosNotEqualTo(String value) {
            addCriterion("memos <>", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosGreaterThan(String value) {
            addCriterion("memos >", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosGreaterThanOrEqualTo(String value) {
            addCriterion("memos >=", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosLessThan(String value) {
            addCriterion("memos <", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosLessThanOrEqualTo(String value) {
            addCriterion("memos <=", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosLike(String value) {
            addCriterion("memos like", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosNotLike(String value) {
            addCriterion("memos not like", value, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosIn(List<String> values) {
            addCriterion("memos in", values, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosNotIn(List<String> values) {
            addCriterion("memos not in", values, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosBetween(String value1, String value2) {
            addCriterion("memos between", value1, value2, "memos");
            return (Criteria) this;
        }

        public Criteria andMemosNotBetween(String value1, String value2) {
            addCriterion("memos not between", value1, value2, "memos");
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