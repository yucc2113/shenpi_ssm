package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlowWorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlowWorkExample() {
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

        public Criteria andStepIdIsNull() {
            addCriterion("step_id is null");
            return (Criteria) this;
        }

        public Criteria andStepIdIsNotNull() {
            addCriterion("step_id is not null");
            return (Criteria) this;
        }

        public Criteria andStepIdEqualTo(Integer value) {
            addCriterion("step_id =", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotEqualTo(Integer value) {
            addCriterion("step_id <>", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThan(Integer value) {
            addCriterion("step_id >", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("step_id >=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThan(Integer value) {
            addCriterion("step_id <", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdLessThanOrEqualTo(Integer value) {
            addCriterion("step_id <=", value, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdIn(List<Integer> values) {
            addCriterion("step_id in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotIn(List<Integer> values) {
            addCriterion("step_id not in", values, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdBetween(Integer value1, Integer value2) {
            addCriterion("step_id between", value1, value2, "stepId");
            return (Criteria) this;
        }

        public Criteria andStepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("step_id not between", value1, value2, "stepId");
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

        public Criteria andWorkIdIsNull() {
            addCriterion("work_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("work_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(Integer value) {
            addCriterion("work_id =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(Integer value) {
            addCriterion("work_id <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(Integer value) {
            addCriterion("work_id >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_id >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(Integer value) {
            addCriterion("work_id <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(Integer value) {
            addCriterion("work_id <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<Integer> values) {
            addCriterion("work_id in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<Integer> values) {
            addCriterion("work_id not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(Integer value1, Integer value2) {
            addCriterion("work_id between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("work_id not between", value1, value2, "workId");
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

        public Criteria andDealUserEqualTo(Integer value) {
            addCriterion("deal_user =", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotEqualTo(Integer value) {
            addCriterion("deal_user <>", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThan(Integer value) {
            addCriterion("deal_user >", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_user >=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThan(Integer value) {
            addCriterion("deal_user <", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThanOrEqualTo(Integer value) {
            addCriterion("deal_user <=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserIn(List<Integer> values) {
            addCriterion("deal_user in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotIn(List<Integer> values) {
            addCriterion("deal_user not in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserBetween(Integer value1, Integer value2) {
            addCriterion("deal_user between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_user not between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealIdeaIsNull() {
            addCriterion("deal_idea is null");
            return (Criteria) this;
        }

        public Criteria andDealIdeaIsNotNull() {
            addCriterion("deal_idea is not null");
            return (Criteria) this;
        }

        public Criteria andDealIdeaEqualTo(String value) {
            addCriterion("deal_idea =", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaNotEqualTo(String value) {
            addCriterion("deal_idea <>", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaGreaterThan(String value) {
            addCriterion("deal_idea >", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaGreaterThanOrEqualTo(String value) {
            addCriterion("deal_idea >=", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaLessThan(String value) {
            addCriterion("deal_idea <", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaLessThanOrEqualTo(String value) {
            addCriterion("deal_idea <=", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaLike(String value) {
            addCriterion("deal_idea like", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaNotLike(String value) {
            addCriterion("deal_idea not like", value, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaIn(List<String> values) {
            addCriterion("deal_idea in", values, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaNotIn(List<String> values) {
            addCriterion("deal_idea not in", values, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaBetween(String value1, String value2) {
            addCriterion("deal_idea between", value1, value2, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealIdeaNotBetween(String value1, String value2) {
            addCriterion("deal_idea not between", value1, value2, "dealIdea");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNull() {
            addCriterion("deal_date is null");
            return (Criteria) this;
        }

        public Criteria andDealDateIsNotNull() {
            addCriterion("deal_date is not null");
            return (Criteria) this;
        }

        public Criteria andDealDateEqualTo(Date value) {
            addCriterion("deal_date =", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotEqualTo(Date value) {
            addCriterion("deal_date <>", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThan(Date value) {
            addCriterion("deal_date >", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateGreaterThanOrEqualTo(Date value) {
            addCriterion("deal_date >=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThan(Date value) {
            addCriterion("deal_date <", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateLessThanOrEqualTo(Date value) {
            addCriterion("deal_date <=", value, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateIn(List<Date> values) {
            addCriterion("deal_date in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotIn(List<Date> values) {
            addCriterion("deal_date not in", values, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateBetween(Date value1, Date value2) {
            addCriterion("deal_date between", value1, value2, "dealDate");
            return (Criteria) this;
        }

        public Criteria andDealDateNotBetween(Date value1, Date value2) {
            addCriterion("deal_date not between", value1, value2, "dealDate");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDealNameIsNull() {
            addCriterion("deal_name is null");
            return (Criteria) this;
        }

        public Criteria andDealNameIsNotNull() {
            addCriterion("deal_name is not null");
            return (Criteria) this;
        }

        public Criteria andDealNameEqualTo(String value) {
            addCriterion("deal_name =", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameNotEqualTo(String value) {
            addCriterion("deal_name <>", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameGreaterThan(String value) {
            addCriterion("deal_name >", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameGreaterThanOrEqualTo(String value) {
            addCriterion("deal_name >=", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameLessThan(String value) {
            addCriterion("deal_name <", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameLessThanOrEqualTo(String value) {
            addCriterion("deal_name <=", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameLike(String value) {
            addCriterion("deal_name like", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameNotLike(String value) {
            addCriterion("deal_name not like", value, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameIn(List<String> values) {
            addCriterion("deal_name in", values, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameNotIn(List<String> values) {
            addCriterion("deal_name not in", values, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameBetween(String value1, String value2) {
            addCriterion("deal_name between", value1, value2, "dealName");
            return (Criteria) this;
        }

        public Criteria andDealNameNotBetween(String value1, String value2) {
            addCriterion("deal_name not between", value1, value2, "dealName");
            return (Criteria) this;
        }

        public Criteria andShenpileixingIsNull() {
            addCriterion("shenpileixing is null");
            return (Criteria) this;
        }

        public Criteria andShenpileixingIsNotNull() {
            addCriterion("shenpileixing is not null");
            return (Criteria) this;
        }

        public Criteria andShenpileixingEqualTo(Integer value) {
            addCriterion("shenpileixing =", value, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingNotEqualTo(Integer value) {
            addCriterion("shenpileixing <>", value, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingGreaterThan(Integer value) {
            addCriterion("shenpileixing >", value, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingGreaterThanOrEqualTo(Integer value) {
            addCriterion("shenpileixing >=", value, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingLessThan(Integer value) {
            addCriterion("shenpileixing <", value, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingLessThanOrEqualTo(Integer value) {
            addCriterion("shenpileixing <=", value, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingIn(List<Integer> values) {
            addCriterion("shenpileixing in", values, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingNotIn(List<Integer> values) {
            addCriterion("shenpileixing not in", values, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingBetween(Integer value1, Integer value2) {
            addCriterion("shenpileixing between", value1, value2, "shenpileixing");
            return (Criteria) this;
        }

        public Criteria andShenpileixingNotBetween(Integer value1, Integer value2) {
            addCriterion("shenpileixing not between", value1, value2, "shenpileixing");
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

        public Criteria andDealPositionEqualTo(Integer value) {
            addCriterion("deal_position =", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotEqualTo(Integer value) {
            addCriterion("deal_position <>", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionGreaterThan(Integer value) {
            addCriterion("deal_position >", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_position >=", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionLessThan(Integer value) {
            addCriterion("deal_position <", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionLessThanOrEqualTo(Integer value) {
            addCriterion("deal_position <=", value, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionIn(List<Integer> values) {
            addCriterion("deal_position in", values, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotIn(List<Integer> values) {
            addCriterion("deal_position not in", values, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionBetween(Integer value1, Integer value2) {
            addCriterion("deal_position between", value1, value2, "dealPosition");
            return (Criteria) this;
        }

        public Criteria andDealPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_position not between", value1, value2, "dealPosition");
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