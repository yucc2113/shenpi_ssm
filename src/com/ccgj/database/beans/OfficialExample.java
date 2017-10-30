package com.ccgj.database.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OfficialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfficialExample() {
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

        public Criteria andFilenameIsNull() {
            addCriterion("filename is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("filename is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("filename =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("filename <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("filename >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("filename >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("filename <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("filename <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("filename like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("filename not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("filename in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("filename not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("filename between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("filename not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilesizeIsNull() {
            addCriterion("filesize is null");
            return (Criteria) this;
        }

        public Criteria andFilesizeIsNotNull() {
            addCriterion("filesize is not null");
            return (Criteria) this;
        }

        public Criteria andFilesizeEqualTo(Integer value) {
            addCriterion("filesize =", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotEqualTo(Integer value) {
            addCriterion("filesize <>", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeGreaterThan(Integer value) {
            addCriterion("filesize >", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("filesize >=", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeLessThan(Integer value) {
            addCriterion("filesize <", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeLessThanOrEqualTo(Integer value) {
            addCriterion("filesize <=", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeIn(List<Integer> values) {
            addCriterion("filesize in", values, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotIn(List<Integer> values) {
            addCriterion("filesize not in", values, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeBetween(Integer value1, Integer value2) {
            addCriterion("filesize between", value1, value2, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotBetween(Integer value1, Integer value2) {
            addCriterion("filesize not between", value1, value2, "filesize");
            return (Criteria) this;
        }

        public Criteria andWenhaoIsNull() {
            addCriterion("wenhao is null");
            return (Criteria) this;
        }

        public Criteria andWenhaoIsNotNull() {
            addCriterion("wenhao is not null");
            return (Criteria) this;
        }

        public Criteria andWenhaoEqualTo(String value) {
            addCriterion("wenhao =", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoNotEqualTo(String value) {
            addCriterion("wenhao <>", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoGreaterThan(String value) {
            addCriterion("wenhao >", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoGreaterThanOrEqualTo(String value) {
            addCriterion("wenhao >=", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoLessThan(String value) {
            addCriterion("wenhao <", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoLessThanOrEqualTo(String value) {
            addCriterion("wenhao <=", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoLike(String value) {
            addCriterion("wenhao like", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoNotLike(String value) {
            addCriterion("wenhao not like", value, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoIn(List<String> values) {
            addCriterion("wenhao in", values, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoNotIn(List<String> values) {
            addCriterion("wenhao not in", values, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoBetween(String value1, String value2) {
            addCriterion("wenhao between", value1, value2, "wenhao");
            return (Criteria) this;
        }

        public Criteria andWenhaoNotBetween(String value1, String value2) {
            addCriterion("wenhao not between", value1, value2, "wenhao");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNull() {
            addCriterion("filetype is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNotNull() {
            addCriterion("filetype is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeEqualTo(String value) {
            addCriterion("filetype =", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotEqualTo(String value) {
            addCriterion("filetype <>", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThan(String value) {
            addCriterion("filetype >", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThanOrEqualTo(String value) {
            addCriterion("filetype >=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThan(String value) {
            addCriterion("filetype <", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThanOrEqualTo(String value) {
            addCriterion("filetype <=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLike(String value) {
            addCriterion("filetype like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotLike(String value) {
            addCriterion("filetype not like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIn(List<String> values) {
            addCriterion("filetype in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotIn(List<String> values) {
            addCriterion("filetype not in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeBetween(String value1, String value2) {
            addCriterion("filetype between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotBetween(String value1, String value2) {
            addCriterion("filetype not between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFilenamediskIsNull() {
            addCriterion("filenamedisk is null");
            return (Criteria) this;
        }

        public Criteria andFilenamediskIsNotNull() {
            addCriterion("filenamedisk is not null");
            return (Criteria) this;
        }

        public Criteria andFilenamediskEqualTo(String value) {
            addCriterion("filenamedisk =", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskNotEqualTo(String value) {
            addCriterion("filenamedisk <>", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskGreaterThan(String value) {
            addCriterion("filenamedisk >", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskGreaterThanOrEqualTo(String value) {
            addCriterion("filenamedisk >=", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskLessThan(String value) {
            addCriterion("filenamedisk <", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskLessThanOrEqualTo(String value) {
            addCriterion("filenamedisk <=", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskLike(String value) {
            addCriterion("filenamedisk like", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskNotLike(String value) {
            addCriterion("filenamedisk not like", value, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskIn(List<String> values) {
            addCriterion("filenamedisk in", values, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskNotIn(List<String> values) {
            addCriterion("filenamedisk not in", values, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskBetween(String value1, String value2) {
            addCriterion("filenamedisk between", value1, value2, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andFilenamediskNotBetween(String value1, String value2) {
            addCriterion("filenamedisk not between", value1, value2, "filenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskIsNull() {
            addCriterion("attachfilenamedisk is null");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskIsNotNull() {
            addCriterion("attachfilenamedisk is not null");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskEqualTo(String value) {
            addCriterion("attachfilenamedisk =", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskNotEqualTo(String value) {
            addCriterion("attachfilenamedisk <>", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskGreaterThan(String value) {
            addCriterion("attachfilenamedisk >", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskGreaterThanOrEqualTo(String value) {
            addCriterion("attachfilenamedisk >=", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskLessThan(String value) {
            addCriterion("attachfilenamedisk <", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskLessThanOrEqualTo(String value) {
            addCriterion("attachfilenamedisk <=", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskLike(String value) {
            addCriterion("attachfilenamedisk like", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskNotLike(String value) {
            addCriterion("attachfilenamedisk not like", value, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskIn(List<String> values) {
            addCriterion("attachfilenamedisk in", values, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskNotIn(List<String> values) {
            addCriterion("attachfilenamedisk not in", values, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskBetween(String value1, String value2) {
            addCriterion("attachfilenamedisk between", value1, value2, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfilenamediskNotBetween(String value1, String value2) {
            addCriterion("attachfilenamedisk not between", value1, value2, "attachfilenamedisk");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeIsNull() {
            addCriterion("attachfiledescribe is null");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeIsNotNull() {
            addCriterion("attachfiledescribe is not null");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeEqualTo(String value) {
            addCriterion("attachfiledescribe =", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeNotEqualTo(String value) {
            addCriterion("attachfiledescribe <>", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeGreaterThan(String value) {
            addCriterion("attachfiledescribe >", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeGreaterThanOrEqualTo(String value) {
            addCriterion("attachfiledescribe >=", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeLessThan(String value) {
            addCriterion("attachfiledescribe <", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeLessThanOrEqualTo(String value) {
            addCriterion("attachfiledescribe <=", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeLike(String value) {
            addCriterion("attachfiledescribe like", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeNotLike(String value) {
            addCriterion("attachfiledescribe not like", value, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeIn(List<String> values) {
            addCriterion("attachfiledescribe in", values, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeNotIn(List<String> values) {
            addCriterion("attachfiledescribe not in", values, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeBetween(String value1, String value2) {
            addCriterion("attachfiledescribe between", value1, value2, "attachfiledescribe");
            return (Criteria) this;
        }

        public Criteria andAttachfiledescribeNotBetween(String value1, String value2) {
            addCriterion("attachfiledescribe not between", value1, value2, "attachfiledescribe");
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

        public Criteria andCreatedateIsNull() {
            addCriterion("createdate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createdate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createdate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createdate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createdate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createdate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createdate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createdate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createdate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createdate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createdate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createdate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNull() {
            addCriterion("createname is null");
            return (Criteria) this;
        }

        public Criteria andCreatenameIsNotNull() {
            addCriterion("createname is not null");
            return (Criteria) this;
        }

        public Criteria andCreatenameEqualTo(String value) {
            addCriterion("createname =", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotEqualTo(String value) {
            addCriterion("createname <>", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThan(String value) {
            addCriterion("createname >", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameGreaterThanOrEqualTo(String value) {
            addCriterion("createname >=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThan(String value) {
            addCriterion("createname <", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLessThanOrEqualTo(String value) {
            addCriterion("createname <=", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameLike(String value) {
            addCriterion("createname like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotLike(String value) {
            addCriterion("createname not like", value, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameIn(List<String> values) {
            addCriterion("createname in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotIn(List<String> values) {
            addCriterion("createname not in", values, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameBetween(String value1, String value2) {
            addCriterion("createname between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andCreatenameNotBetween(String value1, String value2) {
            addCriterion("createname not between", value1, value2, "createname");
            return (Criteria) this;
        }

        public Criteria andApproveuserIsNull() {
            addCriterion("approveuser is null");
            return (Criteria) this;
        }

        public Criteria andApproveuserIsNotNull() {
            addCriterion("approveuser is not null");
            return (Criteria) this;
        }

        public Criteria andApproveuserEqualTo(Integer value) {
            addCriterion("approveuser =", value, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserNotEqualTo(Integer value) {
            addCriterion("approveuser <>", value, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserGreaterThan(Integer value) {
            addCriterion("approveuser >", value, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("approveuser >=", value, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserLessThan(Integer value) {
            addCriterion("approveuser <", value, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserLessThanOrEqualTo(Integer value) {
            addCriterion("approveuser <=", value, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserIn(List<Integer> values) {
            addCriterion("approveuser in", values, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserNotIn(List<Integer> values) {
            addCriterion("approveuser not in", values, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserBetween(Integer value1, Integer value2) {
            addCriterion("approveuser between", value1, value2, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApproveuserNotBetween(Integer value1, Integer value2) {
            addCriterion("approveuser not between", value1, value2, "approveuser");
            return (Criteria) this;
        }

        public Criteria andApprovedateIsNull() {
            addCriterion("approvedate is null");
            return (Criteria) this;
        }

        public Criteria andApprovedateIsNotNull() {
            addCriterion("approvedate is not null");
            return (Criteria) this;
        }

        public Criteria andApprovedateEqualTo(Date value) {
            addCriterion("approvedate =", value, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateNotEqualTo(Date value) {
            addCriterion("approvedate <>", value, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateGreaterThan(Date value) {
            addCriterion("approvedate >", value, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateGreaterThanOrEqualTo(Date value) {
            addCriterion("approvedate >=", value, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateLessThan(Date value) {
            addCriterion("approvedate <", value, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateLessThanOrEqualTo(Date value) {
            addCriterion("approvedate <=", value, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateIn(List<Date> values) {
            addCriterion("approvedate in", values, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateNotIn(List<Date> values) {
            addCriterion("approvedate not in", values, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateBetween(Date value1, Date value2) {
            addCriterion("approvedate between", value1, value2, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApprovedateNotBetween(Date value1, Date value2) {
            addCriterion("approvedate not between", value1, value2, "approvedate");
            return (Criteria) this;
        }

        public Criteria andApproveideaIsNull() {
            addCriterion("approveidea is null");
            return (Criteria) this;
        }

        public Criteria andApproveideaIsNotNull() {
            addCriterion("approveidea is not null");
            return (Criteria) this;
        }

        public Criteria andApproveideaEqualTo(String value) {
            addCriterion("approveidea =", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaNotEqualTo(String value) {
            addCriterion("approveidea <>", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaGreaterThan(String value) {
            addCriterion("approveidea >", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaGreaterThanOrEqualTo(String value) {
            addCriterion("approveidea >=", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaLessThan(String value) {
            addCriterion("approveidea <", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaLessThanOrEqualTo(String value) {
            addCriterion("approveidea <=", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaLike(String value) {
            addCriterion("approveidea like", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaNotLike(String value) {
            addCriterion("approveidea not like", value, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaIn(List<String> values) {
            addCriterion("approveidea in", values, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaNotIn(List<String> values) {
            addCriterion("approveidea not in", values, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaBetween(String value1, String value2) {
            addCriterion("approveidea between", value1, value2, "approveidea");
            return (Criteria) this;
        }

        public Criteria andApproveideaNotBetween(String value1, String value2) {
            addCriterion("approveidea not between", value1, value2, "approveidea");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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