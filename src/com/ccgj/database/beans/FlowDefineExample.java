package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.List;

public class FlowDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowDefineExample() {
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

        public Criteria andFlowNameIsNull() {
            addCriterion("flow_name is null");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNotNull() {
            addCriterion("flow_name is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNameEqualTo(String value) {
            addCriterion("flow_name =", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotEqualTo(String value) {
            addCriterion("flow_name <>", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThan(String value) {
            addCriterion("flow_name >", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThanOrEqualTo(String value) {
            addCriterion("flow_name >=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThan(String value) {
            addCriterion("flow_name <", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThanOrEqualTo(String value) {
            addCriterion("flow_name <=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLike(String value) {
            addCriterion("flow_name like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotLike(String value) {
            addCriterion("flow_name not like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameIn(List<String> values) {
            addCriterion("flow_name in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotIn(List<String> values) {
            addCriterion("flow_name not in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameBetween(String value1, String value2) {
            addCriterion("flow_name between", value1, value2, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotBetween(String value1, String value2) {
            addCriterion("flow_name not between", value1, value2, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowDescIsNull() {
            addCriterion("flow_desc is null");
            return (Criteria) this;
        }

        public Criteria andFlowDescIsNotNull() {
            addCriterion("flow_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFlowDescEqualTo(String value) {
            addCriterion("flow_desc =", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotEqualTo(String value) {
            addCriterion("flow_desc <>", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescGreaterThan(String value) {
            addCriterion("flow_desc >", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescGreaterThanOrEqualTo(String value) {
            addCriterion("flow_desc >=", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescLessThan(String value) {
            addCriterion("flow_desc <", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescLessThanOrEqualTo(String value) {
            addCriterion("flow_desc <=", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescLike(String value) {
            addCriterion("flow_desc like", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotLike(String value) {
            addCriterion("flow_desc not like", value, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescIn(List<String> values) {
            addCriterion("flow_desc in", values, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotIn(List<String> values) {
            addCriterion("flow_desc not in", values, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescBetween(String value1, String value2) {
            addCriterion("flow_desc between", value1, value2, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andFlowDescNotBetween(String value1, String value2) {
            addCriterion("flow_desc not between", value1, value2, "flowDesc");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Integer value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Integer value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Integer value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Integer value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Integer> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Integer> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Integer value1, Integer value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andDeptidsIsNull() {
            addCriterion("deptIds is null");
            return (Criteria) this;
        }

        public Criteria andDeptidsIsNotNull() {
            addCriterion("deptIds is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidsEqualTo(String value) {
            addCriterion("deptIds =", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotEqualTo(String value) {
            addCriterion("deptIds <>", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsGreaterThan(String value) {
            addCriterion("deptIds >", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsGreaterThanOrEqualTo(String value) {
            addCriterion("deptIds >=", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsLessThan(String value) {
            addCriterion("deptIds <", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsLessThanOrEqualTo(String value) {
            addCriterion("deptIds <=", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsLike(String value) {
            addCriterion("deptIds like", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotLike(String value) {
            addCriterion("deptIds not like", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsIn(List<String> values) {
            addCriterion("deptIds in", values, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotIn(List<String> values) {
            addCriterion("deptIds not in", values, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsBetween(String value1, String value2) {
            addCriterion("deptIds between", value1, value2, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotBetween(String value1, String value2) {
            addCriterion("deptIds not between", value1, value2, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("deptname is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("deptname is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("deptname =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("deptname <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("deptname >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("deptname >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("deptname <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("deptname <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("deptname like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("deptname not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("deptname in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("deptname not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("deptname between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("deptname not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdIsNull() {
            addCriterion("biaodan_id is null");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdIsNotNull() {
            addCriterion("biaodan_id is not null");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdEqualTo(Integer value) {
            addCriterion("biaodan_id =", value, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdNotEqualTo(Integer value) {
            addCriterion("biaodan_id <>", value, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdGreaterThan(Integer value) {
            addCriterion("biaodan_id >", value, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("biaodan_id >=", value, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdLessThan(Integer value) {
            addCriterion("biaodan_id <", value, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdLessThanOrEqualTo(Integer value) {
            addCriterion("biaodan_id <=", value, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdIn(List<Integer> values) {
            addCriterion("biaodan_id in", values, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdNotIn(List<Integer> values) {
            addCriterion("biaodan_id not in", values, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdBetween(Integer value1, Integer value2) {
            addCriterion("biaodan_id between", value1, value2, "biaodanId");
            return (Criteria) this;
        }

        public Criteria andBiaodanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("biaodan_id not between", value1, value2, "biaodanId");
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