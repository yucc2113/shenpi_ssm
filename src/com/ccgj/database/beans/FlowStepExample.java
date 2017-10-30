package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlowStepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowStepExample() {
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

        public Criteria andFlowIdIsNull() {
            addCriterion("flow_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(Integer value) {
            addCriterion("flow_id =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(Integer value) {
            addCriterion("flow_id <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(Integer value) {
            addCriterion("flow_id >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_id >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(Integer value) {
            addCriterion("flow_id <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(Integer value) {
            addCriterion("flow_id <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<Integer> values) {
            addCriterion("flow_id in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<Integer> values) {
            addCriterion("flow_id not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(Integer value1, Integer value2) {
            addCriterion("flow_id between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_id not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andStepNoIsNull() {
            addCriterion("step_no is null");
            return (Criteria) this;
        }

        public Criteria andStepNoIsNotNull() {
            addCriterion("step_no is not null");
            return (Criteria) this;
        }

        public Criteria andStepNoEqualTo(Byte value) {
            addCriterion("step_no =", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotEqualTo(Byte value) {
            addCriterion("step_no <>", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoGreaterThan(Byte value) {
            addCriterion("step_no >", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoGreaterThanOrEqualTo(Byte value) {
            addCriterion("step_no >=", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLessThan(Byte value) {
            addCriterion("step_no <", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLessThanOrEqualTo(Byte value) {
            addCriterion("step_no <=", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoIn(List<Byte> values) {
            addCriterion("step_no in", values, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotIn(List<Byte> values) {
            addCriterion("step_no not in", values, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoBetween(Byte value1, Byte value2) {
            addCriterion("step_no between", value1, value2, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotBetween(Byte value1, Byte value2) {
            addCriterion("step_no not between", value1, value2, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("step_name is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("step_name is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("step_name =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("step_name <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("step_name >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("step_name >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("step_name <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("step_name <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("step_name like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("step_name not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("step_name in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("step_name not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("step_name between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("step_name not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNull() {
            addCriterion("deal_user is null");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNotNull() {
            addCriterion("deal_user is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserEqualTo(String value) {
            addCriterion("deal_user =", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotEqualTo(String value) {
            addCriterion("deal_user <>", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThan(String value) {
            addCriterion("deal_user >", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThanOrEqualTo(String value) {
            addCriterion("deal_user >=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThan(String value) {
            addCriterion("deal_user <", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThanOrEqualTo(String value) {
            addCriterion("deal_user <=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLike(String value) {
            addCriterion("deal_user like", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotLike(String value) {
            addCriterion("deal_user not like", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserIn(List<String> values) {
            addCriterion("deal_user in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotIn(List<String> values) {
            addCriterion("deal_user not in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserBetween(String value1, String value2) {
            addCriterion("deal_user between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotBetween(String value1, String value2) {
            addCriterion("deal_user not between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealRoleIsNull() {
            addCriterion("deal_role is null");
            return (Criteria) this;
        }

        public Criteria andDealRoleIsNotNull() {
            addCriterion("deal_role is not null");
            return (Criteria) this;
        }

        public Criteria andDealRoleEqualTo(Integer value) {
            addCriterion("deal_role =", value, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleNotEqualTo(Integer value) {
            addCriterion("deal_role <>", value, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleGreaterThan(Integer value) {
            addCriterion("deal_role >", value, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_role >=", value, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleLessThan(Integer value) {
            addCriterion("deal_role <", value, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleLessThanOrEqualTo(Integer value) {
            addCriterion("deal_role <=", value, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleIn(List<Integer> values) {
            addCriterion("deal_role in", values, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleNotIn(List<Integer> values) {
            addCriterion("deal_role not in", values, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleBetween(Integer value1, Integer value2) {
            addCriterion("deal_role between", value1, value2, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_role not between", value1, value2, "dealRole");
            return (Criteria) this;
        }

        public Criteria andDealPositionIsNull() {
            addCriterion("deal_position is null");
            return (Criteria) this;
        }

        public Criteria andDealPositionIsNotNull() {
            addCriterion("deal_position is not null");
            return (Criteria) this;
        }

        public Criteria andDealPositionEqualTo(String value) {
            addCriterion("deal_position =", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotEqualTo(String value) {
            addCriterion("deal_position <>", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionGreaterThan(String value) {
            addCriterion("deal_position >", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionGreaterThanOrEqualTo(String value) {
            addCriterion("deal_position >=", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionLessThan(String value) {
            addCriterion("deal_position <", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionLessThanOrEqualTo(String value) {
            addCriterion("deal_position <=", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionLike(String value) {
            addCriterion("deal_position like", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotLike(String value) {
            addCriterion("deal_position not like", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionIn(List<String> values) {
            addCriterion("deal_position in", values, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotIn(List<String> values) {
            addCriterion("deal_position not in", values, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionBetween(String value1, String value2) {
            addCriterion("deal_position between", value1, value2, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotBetween(String value1, String value2) {
            addCriterion("deal_position not between", value1, value2, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andLastIdIsNull() {
            addCriterion("last_id is null");
            return (Criteria) this;
        }

        public Criteria andLastIdIsNotNull() {
            addCriterion("last_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastIdEqualTo(Integer value) {
            addCriterion("last_id =", value, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdNotEqualTo(Integer value) {
            addCriterion("last_id <>", value, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdGreaterThan(Integer value) {
            addCriterion("last_id >", value, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_id >=", value, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdLessThan(Integer value) {
            addCriterion("last_id <", value, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdLessThanOrEqualTo(Integer value) {
            addCriterion("last_id <=", value, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdIn(List<Integer> values) {
            addCriterion("last_id in", values, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdNotIn(List<Integer> values) {
            addCriterion("last_id not in", values, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdBetween(Integer value1, Integer value2) {
            addCriterion("last_id between", value1, value2, "lastId");
            return (Criteria) this;
        }

        public Criteria andLastIdNotBetween(Integer value1, Integer value2) {
            addCriterion("last_id not between", value1, value2, "lastId");
            return (Criteria) this;
        }

        public Criteria andNextIdIsNull() {
            addCriterion("next_id is null");
            return (Criteria) this;
        }

        public Criteria andNextIdIsNotNull() {
            addCriterion("next_id is not null");
            return (Criteria) this;
        }

        public Criteria andNextIdEqualTo(Integer value) {
            addCriterion("next_id =", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdNotEqualTo(Integer value) {
            addCriterion("next_id <>", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdGreaterThan(Integer value) {
            addCriterion("next_id >", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("next_id >=", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdLessThan(Integer value) {
            addCriterion("next_id <", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdLessThanOrEqualTo(Integer value) {
            addCriterion("next_id <=", value, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdIn(List<Integer> values) {
            addCriterion("next_id in", values, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdNotIn(List<Integer> values) {
            addCriterion("next_id not in", values, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdBetween(Integer value1, Integer value2) {
            addCriterion("next_id between", value1, value2, "nextId");
            return (Criteria) this;
        }

        public Criteria andNextIdNotBetween(Integer value1, Integer value2) {
            addCriterion("next_id not between", value1, value2, "nextId");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNull() {
            addCriterion("step_type is null");
            return (Criteria) this;
        }

        public Criteria andStepTypeIsNotNull() {
            addCriterion("step_type is not null");
            return (Criteria) this;
        }

        public Criteria andStepTypeEqualTo(Integer value) {
            addCriterion("step_type =", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotEqualTo(Integer value) {
            addCriterion("step_type <>", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThan(Integer value) {
            addCriterion("step_type >", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_type >=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThan(Integer value) {
            addCriterion("step_type <", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeLessThanOrEqualTo(Integer value) {
            addCriterion("step_type <=", value, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeIn(List<Integer> values) {
            addCriterion("step_type in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotIn(List<Integer> values) {
            addCriterion("step_type not in", values, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeBetween(Integer value1, Integer value2) {
            addCriterion("step_type between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andStepTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("step_type not between", value1, value2, "stepType");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLibusernameIsNull() {
            addCriterion("libusername is null");
            return (Criteria) this;
        }

        public Criteria andLibusernameIsNotNull() {
            addCriterion("libusername is not null");
            return (Criteria) this;
        }

        public Criteria andLibusernameEqualTo(String value) {
            addCriterion("libusername =", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameNotEqualTo(String value) {
            addCriterion("libusername <>", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameGreaterThan(String value) {
            addCriterion("libusername >", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameGreaterThanOrEqualTo(String value) {
            addCriterion("libusername >=", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameLessThan(String value) {
            addCriterion("libusername <", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameLessThanOrEqualTo(String value) {
            addCriterion("libusername <=", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameLike(String value) {
            addCriterion("libusername like", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameNotLike(String value) {
            addCriterion("libusername not like", value, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameIn(List<String> values) {
            addCriterion("libusername in", values, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameNotIn(List<String> values) {
            addCriterion("libusername not in", values, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameBetween(String value1, String value2) {
            addCriterion("libusername between", value1, value2, "libusername");
            return (Criteria) this;
        }

        public Criteria andLibusernameNotBetween(String value1, String value2) {
            addCriterion("libusername not between", value1, value2, "libusername");
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

        public Criteria andLeixingIsNull() {
            addCriterion("leixing is null");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNotNull() {
            addCriterion("leixing is not null");
            return (Criteria) this;
        }

        public Criteria andLeixingEqualTo(String value) {
            addCriterion("leixing =", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotEqualTo(String value) {
            addCriterion("leixing <>", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThan(String value) {
            addCriterion("leixing >", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThanOrEqualTo(String value) {
            addCriterion("leixing >=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThan(String value) {
            addCriterion("leixing <", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThanOrEqualTo(String value) {
            addCriterion("leixing <=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLike(String value) {
            addCriterion("leixing like", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotLike(String value) {
            addCriterion("leixing not like", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingIn(List<String> values) {
            addCriterion("leixing in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotIn(List<String> values) {
            addCriterion("leixing not in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingBetween(String value1, String value2) {
            addCriterion("leixing between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotBetween(String value1, String value2) {
            addCriterion("leixing not between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNull() {
            addCriterion("conditions is null");
            return (Criteria) this;
        }

        public Criteria andConditionsIsNotNull() {
            addCriterion("conditions is not null");
            return (Criteria) this;
        }

        public Criteria andConditionsEqualTo(String value) {
            addCriterion("conditions =", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotEqualTo(String value) {
            addCriterion("conditions <>", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThan(String value) {
            addCriterion("conditions >", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsGreaterThanOrEqualTo(String value) {
            addCriterion("conditions >=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThan(String value) {
            addCriterion("conditions <", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLessThanOrEqualTo(String value) {
            addCriterion("conditions <=", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsLike(String value) {
            addCriterion("conditions like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotLike(String value) {
            addCriterion("conditions not like", value, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsIn(List<String> values) {
            addCriterion("conditions in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotIn(List<String> values) {
            addCriterion("conditions not in", values, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsBetween(String value1, String value2) {
            addCriterion("conditions between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionsNotBetween(String value1, String value2) {
            addCriterion("conditions not between", value1, value2, "conditions");
            return (Criteria) this;
        }

        public Criteria andConditionmsgIsNull() {
            addCriterion("conditionMsg is null");
            return (Criteria) this;
        }

        public Criteria andConditionmsgIsNotNull() {
            addCriterion("conditionMsg is not null");
            return (Criteria) this;
        }

        public Criteria andConditionmsgEqualTo(String value) {
            addCriterion("conditionMsg =", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgNotEqualTo(String value) {
            addCriterion("conditionMsg <>", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgGreaterThan(String value) {
            addCriterion("conditionMsg >", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgGreaterThanOrEqualTo(String value) {
            addCriterion("conditionMsg >=", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgLessThan(String value) {
            addCriterion("conditionMsg <", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgLessThanOrEqualTo(String value) {
            addCriterion("conditionMsg <=", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgLike(String value) {
            addCriterion("conditionMsg like", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgNotLike(String value) {
            addCriterion("conditionMsg not like", value, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgIn(List<String> values) {
            addCriterion("conditionMsg in", values, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgNotIn(List<String> values) {
            addCriterion("conditionMsg not in", values, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgBetween(String value1, String value2) {
            addCriterion("conditionMsg between", value1, value2, "conditionmsg");
            return (Criteria) this;
        }

        public Criteria andConditionmsgNotBetween(String value1, String value2) {
            addCriterion("conditionMsg not between", value1, value2, "conditionmsg");
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