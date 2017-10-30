package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeetExample() {
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

        public Criteria andDidianIsNull() {
            addCriterion("didian is null");
            return (Criteria) this;
        }

        public Criteria andDidianIsNotNull() {
            addCriterion("didian is not null");
            return (Criteria) this;
        }

        public Criteria andDidianEqualTo(String value) {
            addCriterion("didian =", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianNotEqualTo(String value) {
            addCriterion("didian <>", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianGreaterThan(String value) {
            addCriterion("didian >", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianGreaterThanOrEqualTo(String value) {
            addCriterion("didian >=", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianLessThan(String value) {
            addCriterion("didian <", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianLessThanOrEqualTo(String value) {
            addCriterion("didian <=", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianLike(String value) {
            addCriterion("didian like", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianNotLike(String value) {
            addCriterion("didian not like", value, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianIn(List<String> values) {
            addCriterion("didian in", values, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianNotIn(List<String> values) {
            addCriterion("didian not in", values, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianBetween(String value1, String value2) {
            addCriterion("didian between", value1, value2, "didian");
            return (Criteria) this;
        }

        public Criteria andDidianNotBetween(String value1, String value2) {
            addCriterion("didian not between", value1, value2, "didian");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createuser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(Integer value) {
            addCriterion("createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(Integer value) {
            addCriterion("createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(Integer value) {
            addCriterion("createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(Integer value) {
            addCriterion("createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(Integer value) {
            addCriterion("createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<Integer> values) {
            addCriterion("createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<Integer> values) {
            addCriterion("createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(Integer value1, Integer value2) {
            addCriterion("createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(Integer value1, Integer value2) {
            addCriterion("createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andMeetDateIsNull() {
            addCriterion("meet_date is null");
            return (Criteria) this;
        }

        public Criteria andMeetDateIsNotNull() {
            addCriterion("meet_date is not null");
            return (Criteria) this;
        }

        public Criteria andMeetDateEqualTo(Date value) {
            addCriterion("meet_date =", value, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateNotEqualTo(Date value) {
            addCriterion("meet_date <>", value, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateGreaterThan(Date value) {
            addCriterion("meet_date >", value, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateGreaterThanOrEqualTo(Date value) {
            addCriterion("meet_date >=", value, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateLessThan(Date value) {
            addCriterion("meet_date <", value, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateLessThanOrEqualTo(Date value) {
            addCriterion("meet_date <=", value, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateIn(List<Date> values) {
            addCriterion("meet_date in", values, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateNotIn(List<Date> values) {
            addCriterion("meet_date not in", values, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateBetween(Date value1, Date value2) {
            addCriterion("meet_date between", value1, value2, "meetDate");
            return (Criteria) this;
        }

        public Criteria andMeetDateNotBetween(Date value1, Date value2) {
            addCriterion("meet_date not between", value1, value2, "meetDate");
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

        public Criteria andCreatenameIsNull() {
            addCriterion("createName is null");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNotNull() {
            addCriterion("createName is not null");
            return (Criteria) this;
        }

        public Criteria andCreatenameEqualTo(String value) {
            addCriterion("createName =", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotEqualTo(String value) {
            addCriterion("createName <>", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThan(String value) {
            addCriterion("createName >", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThanOrEqualTo(String value) {
            addCriterion("createName >=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThan(String value) {
            addCriterion("createName <", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThanOrEqualTo(String value) {
            addCriterion("createName <=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLike(String value) {
            addCriterion("createName like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotLike(String value) {
            addCriterion("createName not like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameIn(List<String> values) {
            addCriterion("createName in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotIn(List<String> values) {
            addCriterion("createName not in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameBetween(String value1, String value2) {
            addCriterion("createName between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotBetween(String value1, String value2) {
            addCriterion("createName not between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andOldfilenameIsNull() {
            addCriterion("oldfilename is null");
            return (Criteria) this;
        }

        public Criteria andOldfilenameIsNotNull() {
            addCriterion("oldfilename is not null");
            return (Criteria) this;
        }

        public Criteria andOldfilenameEqualTo(String value) {
            addCriterion("oldfilename =", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameNotEqualTo(String value) {
            addCriterion("oldfilename <>", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameGreaterThan(String value) {
            addCriterion("oldfilename >", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameGreaterThanOrEqualTo(String value) {
            addCriterion("oldfilename >=", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameLessThan(String value) {
            addCriterion("oldfilename <", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameLessThanOrEqualTo(String value) {
            addCriterion("oldfilename <=", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameLike(String value) {
            addCriterion("oldfilename like", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameNotLike(String value) {
            addCriterion("oldfilename not like", value, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameIn(List<String> values) {
            addCriterion("oldfilename in", values, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameNotIn(List<String> values) {
            addCriterion("oldfilename not in", values, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameBetween(String value1, String value2) {
            addCriterion("oldfilename between", value1, value2, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andOldfilenameNotBetween(String value1, String value2) {
            addCriterion("oldfilename not between", value1, value2, "oldfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameIsNull() {
            addCriterion("newfilename is null");
            return (Criteria) this;
        }

        public Criteria andNewfilenameIsNotNull() {
            addCriterion("newfilename is not null");
            return (Criteria) this;
        }

        public Criteria andNewfilenameEqualTo(String value) {
            addCriterion("newfilename =", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameNotEqualTo(String value) {
            addCriterion("newfilename <>", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameGreaterThan(String value) {
            addCriterion("newfilename >", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameGreaterThanOrEqualTo(String value) {
            addCriterion("newfilename >=", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameLessThan(String value) {
            addCriterion("newfilename <", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameLessThanOrEqualTo(String value) {
            addCriterion("newfilename <=", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameLike(String value) {
            addCriterion("newfilename like", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameNotLike(String value) {
            addCriterion("newfilename not like", value, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameIn(List<String> values) {
            addCriterion("newfilename in", values, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameNotIn(List<String> values) {
            addCriterion("newfilename not in", values, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameBetween(String value1, String value2) {
            addCriterion("newfilename between", value1, value2, "newfilename");
            return (Criteria) this;
        }

        public Criteria andNewfilenameNotBetween(String value1, String value2) {
            addCriterion("newfilename not between", value1, value2, "newfilename");
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