package com.entity;

import java.util.ArrayList;
import java.util.List;

public class InsuranceexchangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsuranceexchangeExample() {
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

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayIsNull() {
            addCriterion("enjoyBirthday is null");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayIsNotNull() {
            addCriterion("enjoyBirthday is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayEqualTo(String value) {
            addCriterion("enjoyBirthday =", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayNotEqualTo(String value) {
            addCriterion("enjoyBirthday <>", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayGreaterThan(String value) {
            addCriterion("enjoyBirthday >", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyBirthday >=", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayLessThan(String value) {
            addCriterion("enjoyBirthday <", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayLessThanOrEqualTo(String value) {
            addCriterion("enjoyBirthday <=", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayLike(String value) {
            addCriterion("enjoyBirthday like", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayNotLike(String value) {
            addCriterion("enjoyBirthday not like", value, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayIn(List<String> values) {
            addCriterion("enjoyBirthday in", values, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayNotIn(List<String> values) {
            addCriterion("enjoyBirthday not in", values, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayBetween(String value1, String value2) {
            addCriterion("enjoyBirthday between", value1, value2, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoybirthdayNotBetween(String value1, String value2) {
            addCriterion("enjoyBirthday not between", value1, value2, "enjoybirthday");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberIsNull() {
            addCriterion("enjoyCardNumber is null");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberIsNotNull() {
            addCriterion("enjoyCardNumber is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberEqualTo(String value) {
            addCriterion("enjoyCardNumber =", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberNotEqualTo(String value) {
            addCriterion("enjoyCardNumber <>", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberGreaterThan(String value) {
            addCriterion("enjoyCardNumber >", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyCardNumber >=", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberLessThan(String value) {
            addCriterion("enjoyCardNumber <", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberLessThanOrEqualTo(String value) {
            addCriterion("enjoyCardNumber <=", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberLike(String value) {
            addCriterion("enjoyCardNumber like", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberNotLike(String value) {
            addCriterion("enjoyCardNumber not like", value, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberIn(List<String> values) {
            addCriterion("enjoyCardNumber in", values, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberNotIn(List<String> values) {
            addCriterion("enjoyCardNumber not in", values, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberBetween(String value1, String value2) {
            addCriterion("enjoyCardNumber between", value1, value2, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardnumberNotBetween(String value1, String value2) {
            addCriterion("enjoyCardNumber not between", value1, value2, "enjoycardnumber");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeIsNull() {
            addCriterion("enjoyCardType is null");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeIsNotNull() {
            addCriterion("enjoyCardType is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeEqualTo(String value) {
            addCriterion("enjoyCardType =", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeNotEqualTo(String value) {
            addCriterion("enjoyCardType <>", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeGreaterThan(String value) {
            addCriterion("enjoyCardType >", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyCardType >=", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeLessThan(String value) {
            addCriterion("enjoyCardType <", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeLessThanOrEqualTo(String value) {
            addCriterion("enjoyCardType <=", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeLike(String value) {
            addCriterion("enjoyCardType like", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeNotLike(String value) {
            addCriterion("enjoyCardType not like", value, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeIn(List<String> values) {
            addCriterion("enjoyCardType in", values, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeNotIn(List<String> values) {
            addCriterion("enjoyCardType not in", values, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeBetween(String value1, String value2) {
            addCriterion("enjoyCardType between", value1, value2, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoycardtypeNotBetween(String value1, String value2) {
            addCriterion("enjoyCardType not between", value1, value2, "enjoycardtype");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailIsNull() {
            addCriterion("enjoyEmail is null");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailIsNotNull() {
            addCriterion("enjoyEmail is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailEqualTo(String value) {
            addCriterion("enjoyEmail =", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailNotEqualTo(String value) {
            addCriterion("enjoyEmail <>", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailGreaterThan(String value) {
            addCriterion("enjoyEmail >", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyEmail >=", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailLessThan(String value) {
            addCriterion("enjoyEmail <", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailLessThanOrEqualTo(String value) {
            addCriterion("enjoyEmail <=", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailLike(String value) {
            addCriterion("enjoyEmail like", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailNotLike(String value) {
            addCriterion("enjoyEmail not like", value, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailIn(List<String> values) {
            addCriterion("enjoyEmail in", values, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailNotIn(List<String> values) {
            addCriterion("enjoyEmail not in", values, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailBetween(String value1, String value2) {
            addCriterion("enjoyEmail between", value1, value2, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoyemailNotBetween(String value1, String value2) {
            addCriterion("enjoyEmail not between", value1, value2, "enjoyemail");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkIsNull() {
            addCriterion("enjoyLink is null");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkIsNotNull() {
            addCriterion("enjoyLink is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkEqualTo(String value) {
            addCriterion("enjoyLink =", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkNotEqualTo(String value) {
            addCriterion("enjoyLink <>", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkGreaterThan(String value) {
            addCriterion("enjoyLink >", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyLink >=", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkLessThan(String value) {
            addCriterion("enjoyLink <", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkLessThanOrEqualTo(String value) {
            addCriterion("enjoyLink <=", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkLike(String value) {
            addCriterion("enjoyLink like", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkNotLike(String value) {
            addCriterion("enjoyLink not like", value, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkIn(List<String> values) {
            addCriterion("enjoyLink in", values, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkNotIn(List<String> values) {
            addCriterion("enjoyLink not in", values, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkBetween(String value1, String value2) {
            addCriterion("enjoyLink between", value1, value2, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoylinkNotBetween(String value1, String value2) {
            addCriterion("enjoyLink not between", value1, value2, "enjoylink");
            return (Criteria) this;
        }

        public Criteria andEnjoynameIsNull() {
            addCriterion("enjoyName is null");
            return (Criteria) this;
        }

        public Criteria andEnjoynameIsNotNull() {
            addCriterion("enjoyName is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoynameEqualTo(String value) {
            addCriterion("enjoyName =", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameNotEqualTo(String value) {
            addCriterion("enjoyName <>", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameGreaterThan(String value) {
            addCriterion("enjoyName >", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyName >=", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameLessThan(String value) {
            addCriterion("enjoyName <", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameLessThanOrEqualTo(String value) {
            addCriterion("enjoyName <=", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameLike(String value) {
            addCriterion("enjoyName like", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameNotLike(String value) {
            addCriterion("enjoyName not like", value, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameIn(List<String> values) {
            addCriterion("enjoyName in", values, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameNotIn(List<String> values) {
            addCriterion("enjoyName not in", values, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameBetween(String value1, String value2) {
            addCriterion("enjoyName between", value1, value2, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynameNotBetween(String value1, String value2) {
            addCriterion("enjoyName not between", value1, value2, "enjoyname");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberIsNull() {
            addCriterion("enjoyNumber is null");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberIsNotNull() {
            addCriterion("enjoyNumber is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberEqualTo(String value) {
            addCriterion("enjoyNumber =", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberNotEqualTo(String value) {
            addCriterion("enjoyNumber <>", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberGreaterThan(String value) {
            addCriterion("enjoyNumber >", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberGreaterThanOrEqualTo(String value) {
            addCriterion("enjoyNumber >=", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberLessThan(String value) {
            addCriterion("enjoyNumber <", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberLessThanOrEqualTo(String value) {
            addCriterion("enjoyNumber <=", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberLike(String value) {
            addCriterion("enjoyNumber like", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberNotLike(String value) {
            addCriterion("enjoyNumber not like", value, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberIn(List<String> values) {
            addCriterion("enjoyNumber in", values, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberNotIn(List<String> values) {
            addCriterion("enjoyNumber not in", values, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberBetween(String value1, String value2) {
            addCriterion("enjoyNumber between", value1, value2, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoynumberNotBetween(String value1, String value2) {
            addCriterion("enjoyNumber not between", value1, value2, "enjoynumber");
            return (Criteria) this;
        }

        public Criteria andEnjoysexIsNull() {
            addCriterion("enjoySex is null");
            return (Criteria) this;
        }

        public Criteria andEnjoysexIsNotNull() {
            addCriterion("enjoySex is not null");
            return (Criteria) this;
        }

        public Criteria andEnjoysexEqualTo(Integer value) {
            addCriterion("enjoySex =", value, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexNotEqualTo(Integer value) {
            addCriterion("enjoySex <>", value, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexGreaterThan(Integer value) {
            addCriterion("enjoySex >", value, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexGreaterThanOrEqualTo(Integer value) {
            addCriterion("enjoySex >=", value, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexLessThan(Integer value) {
            addCriterion("enjoySex <", value, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexLessThanOrEqualTo(Integer value) {
            addCriterion("enjoySex <=", value, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexIn(List<Integer> values) {
            addCriterion("enjoySex in", values, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexNotIn(List<Integer> values) {
            addCriterion("enjoySex not in", values, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexBetween(Integer value1, Integer value2) {
            addCriterion("enjoySex between", value1, value2, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andEnjoysexNotBetween(Integer value1, Integer value2) {
            addCriterion("enjoySex not between", value1, value2, "enjoysex");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayIsNull() {
            addCriterion("orderBirthday is null");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayIsNotNull() {
            addCriterion("orderBirthday is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayEqualTo(String value) {
            addCriterion("orderBirthday =", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayNotEqualTo(String value) {
            addCriterion("orderBirthday <>", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayGreaterThan(String value) {
            addCriterion("orderBirthday >", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("orderBirthday >=", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayLessThan(String value) {
            addCriterion("orderBirthday <", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayLessThanOrEqualTo(String value) {
            addCriterion("orderBirthday <=", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayLike(String value) {
            addCriterion("orderBirthday like", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayNotLike(String value) {
            addCriterion("orderBirthday not like", value, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayIn(List<String> values) {
            addCriterion("orderBirthday in", values, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayNotIn(List<String> values) {
            addCriterion("orderBirthday not in", values, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayBetween(String value1, String value2) {
            addCriterion("orderBirthday between", value1, value2, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrderbirthdayNotBetween(String value1, String value2) {
            addCriterion("orderBirthday not between", value1, value2, "orderbirthday");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberIsNull() {
            addCriterion("orderCardNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberIsNotNull() {
            addCriterion("orderCardNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberEqualTo(String value) {
            addCriterion("orderCardNumber =", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberNotEqualTo(String value) {
            addCriterion("orderCardNumber <>", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberGreaterThan(String value) {
            addCriterion("orderCardNumber >", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberGreaterThanOrEqualTo(String value) {
            addCriterion("orderCardNumber >=", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberLessThan(String value) {
            addCriterion("orderCardNumber <", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberLessThanOrEqualTo(String value) {
            addCriterion("orderCardNumber <=", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberLike(String value) {
            addCriterion("orderCardNumber like", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberNotLike(String value) {
            addCriterion("orderCardNumber not like", value, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberIn(List<String> values) {
            addCriterion("orderCardNumber in", values, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberNotIn(List<String> values) {
            addCriterion("orderCardNumber not in", values, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberBetween(String value1, String value2) {
            addCriterion("orderCardNumber between", value1, value2, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardnumberNotBetween(String value1, String value2) {
            addCriterion("orderCardNumber not between", value1, value2, "ordercardnumber");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeIsNull() {
            addCriterion("orderCardType is null");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeIsNotNull() {
            addCriterion("orderCardType is not null");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeEqualTo(String value) {
            addCriterion("orderCardType =", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeNotEqualTo(String value) {
            addCriterion("orderCardType <>", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeGreaterThan(String value) {
            addCriterion("orderCardType >", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeGreaterThanOrEqualTo(String value) {
            addCriterion("orderCardType >=", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeLessThan(String value) {
            addCriterion("orderCardType <", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeLessThanOrEqualTo(String value) {
            addCriterion("orderCardType <=", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeLike(String value) {
            addCriterion("orderCardType like", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeNotLike(String value) {
            addCriterion("orderCardType not like", value, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeIn(List<String> values) {
            addCriterion("orderCardType in", values, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeNotIn(List<String> values) {
            addCriterion("orderCardType not in", values, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeBetween(String value1, String value2) {
            addCriterion("orderCardType between", value1, value2, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrdercardtypeNotBetween(String value1, String value2) {
            addCriterion("orderCardType not between", value1, value2, "ordercardtype");
            return (Criteria) this;
        }

        public Criteria andOrderemailIsNull() {
            addCriterion("orderEmail is null");
            return (Criteria) this;
        }

        public Criteria andOrderemailIsNotNull() {
            addCriterion("orderEmail is not null");
            return (Criteria) this;
        }

        public Criteria andOrderemailEqualTo(String value) {
            addCriterion("orderEmail =", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailNotEqualTo(String value) {
            addCriterion("orderEmail <>", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailGreaterThan(String value) {
            addCriterion("orderEmail >", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailGreaterThanOrEqualTo(String value) {
            addCriterion("orderEmail >=", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailLessThan(String value) {
            addCriterion("orderEmail <", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailLessThanOrEqualTo(String value) {
            addCriterion("orderEmail <=", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailLike(String value) {
            addCriterion("orderEmail like", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailNotLike(String value) {
            addCriterion("orderEmail not like", value, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailIn(List<String> values) {
            addCriterion("orderEmail in", values, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailNotIn(List<String> values) {
            addCriterion("orderEmail not in", values, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailBetween(String value1, String value2) {
            addCriterion("orderEmail between", value1, value2, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrderemailNotBetween(String value1, String value2) {
            addCriterion("orderEmail not between", value1, value2, "orderemail");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNull() {
            addCriterion("orderName is null");
            return (Criteria) this;
        }

        public Criteria andOrdernameIsNotNull() {
            addCriterion("orderName is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernameEqualTo(String value) {
            addCriterion("orderName =", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotEqualTo(String value) {
            addCriterion("orderName <>", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThan(String value) {
            addCriterion("orderName >", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameGreaterThanOrEqualTo(String value) {
            addCriterion("orderName >=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThan(String value) {
            addCriterion("orderName <", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLessThanOrEqualTo(String value) {
            addCriterion("orderName <=", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameLike(String value) {
            addCriterion("orderName like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotLike(String value) {
            addCriterion("orderName not like", value, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameIn(List<String> values) {
            addCriterion("orderName in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotIn(List<String> values) {
            addCriterion("orderName not in", values, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameBetween(String value1, String value2) {
            addCriterion("orderName between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernameNotBetween(String value1, String value2) {
            addCriterion("orderName not between", value1, value2, "ordername");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNull() {
            addCriterion("orderNumber is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIsNotNull() {
            addCriterion("orderNumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumberEqualTo(String value) {
            addCriterion("orderNumber =", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotEqualTo(String value) {
            addCriterion("orderNumber <>", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThan(String value) {
            addCriterion("orderNumber >", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberGreaterThanOrEqualTo(String value) {
            addCriterion("orderNumber >=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThan(String value) {
            addCriterion("orderNumber <", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLessThanOrEqualTo(String value) {
            addCriterion("orderNumber <=", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberLike(String value) {
            addCriterion("orderNumber like", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotLike(String value) {
            addCriterion("orderNumber not like", value, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberIn(List<String> values) {
            addCriterion("orderNumber in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotIn(List<String> values) {
            addCriterion("orderNumber not in", values, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberBetween(String value1, String value2) {
            addCriterion("orderNumber between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdernumberNotBetween(String value1, String value2) {
            addCriterion("orderNumber not between", value1, value2, "ordernumber");
            return (Criteria) this;
        }

        public Criteria andOrdersexIsNull() {
            addCriterion("orderSex is null");
            return (Criteria) this;
        }

        public Criteria andOrdersexIsNotNull() {
            addCriterion("orderSex is not null");
            return (Criteria) this;
        }

        public Criteria andOrdersexEqualTo(Integer value) {
            addCriterion("orderSex =", value, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexNotEqualTo(Integer value) {
            addCriterion("orderSex <>", value, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexGreaterThan(Integer value) {
            addCriterion("orderSex >", value, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderSex >=", value, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexLessThan(Integer value) {
            addCriterion("orderSex <", value, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexLessThanOrEqualTo(Integer value) {
            addCriterion("orderSex <=", value, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexIn(List<Integer> values) {
            addCriterion("orderSex in", values, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexNotIn(List<Integer> values) {
            addCriterion("orderSex not in", values, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexBetween(Integer value1, Integer value2) {
            addCriterion("orderSex between", value1, value2, "ordersex");
            return (Criteria) this;
        }

        public Criteria andOrdersexNotBetween(Integer value1, Integer value2) {
            addCriterion("orderSex not between", value1, value2, "ordersex");
            return (Criteria) this;
        }

        public Criteria andUsenumberIsNull() {
            addCriterion("useNumber is null");
            return (Criteria) this;
        }

        public Criteria andUsenumberIsNotNull() {
            addCriterion("useNumber is not null");
            return (Criteria) this;
        }

        public Criteria andUsenumberEqualTo(String value) {
            addCriterion("useNumber =", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberNotEqualTo(String value) {
            addCriterion("useNumber <>", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberGreaterThan(String value) {
            addCriterion("useNumber >", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberGreaterThanOrEqualTo(String value) {
            addCriterion("useNumber >=", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberLessThan(String value) {
            addCriterion("useNumber <", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberLessThanOrEqualTo(String value) {
            addCriterion("useNumber <=", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberLike(String value) {
            addCriterion("useNumber like", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberNotLike(String value) {
            addCriterion("useNumber not like", value, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberIn(List<String> values) {
            addCriterion("useNumber in", values, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberNotIn(List<String> values) {
            addCriterion("useNumber not in", values, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberBetween(String value1, String value2) {
            addCriterion("useNumber between", value1, value2, "usenumber");
            return (Criteria) this;
        }

        public Criteria andUsenumberNotBetween(String value1, String value2) {
            addCriterion("useNumber not between", value1, value2, "usenumber");
            return (Criteria) this;
        }

        public Criteria andXianenddateIsNull() {
            addCriterion("xianEndDate is null");
            return (Criteria) this;
        }

        public Criteria andXianenddateIsNotNull() {
            addCriterion("xianEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andXianenddateEqualTo(String value) {
            addCriterion("xianEndDate =", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateNotEqualTo(String value) {
            addCriterion("xianEndDate <>", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateGreaterThan(String value) {
            addCriterion("xianEndDate >", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateGreaterThanOrEqualTo(String value) {
            addCriterion("xianEndDate >=", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateLessThan(String value) {
            addCriterion("xianEndDate <", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateLessThanOrEqualTo(String value) {
            addCriterion("xianEndDate <=", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateLike(String value) {
            addCriterion("xianEndDate like", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateNotLike(String value) {
            addCriterion("xianEndDate not like", value, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateIn(List<String> values) {
            addCriterion("xianEndDate in", values, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateNotIn(List<String> values) {
            addCriterion("xianEndDate not in", values, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateBetween(String value1, String value2) {
            addCriterion("xianEndDate between", value1, value2, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXianenddateNotBetween(String value1, String value2) {
            addCriterion("xianEndDate not between", value1, value2, "xianenddate");
            return (Criteria) this;
        }

        public Criteria andXiannameIsNull() {
            addCriterion("xianName is null");
            return (Criteria) this;
        }

        public Criteria andXiannameIsNotNull() {
            addCriterion("xianName is not null");
            return (Criteria) this;
        }

        public Criteria andXiannameEqualTo(String value) {
            addCriterion("xianName =", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameNotEqualTo(String value) {
            addCriterion("xianName <>", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameGreaterThan(String value) {
            addCriterion("xianName >", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameGreaterThanOrEqualTo(String value) {
            addCriterion("xianName >=", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameLessThan(String value) {
            addCriterion("xianName <", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameLessThanOrEqualTo(String value) {
            addCriterion("xianName <=", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameLike(String value) {
            addCriterion("xianName like", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameNotLike(String value) {
            addCriterion("xianName not like", value, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameIn(List<String> values) {
            addCriterion("xianName in", values, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameNotIn(List<String> values) {
            addCriterion("xianName not in", values, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameBetween(String value1, String value2) {
            addCriterion("xianName between", value1, value2, "xianname");
            return (Criteria) this;
        }

        public Criteria andXiannameNotBetween(String value1, String value2) {
            addCriterion("xianName not between", value1, value2, "xianname");
            return (Criteria) this;
        }

        public Criteria andXianstartdateIsNull() {
            addCriterion("xianStartDate is null");
            return (Criteria) this;
        }

        public Criteria andXianstartdateIsNotNull() {
            addCriterion("xianStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andXianstartdateEqualTo(String value) {
            addCriterion("xianStartDate =", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateNotEqualTo(String value) {
            addCriterion("xianStartDate <>", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateGreaterThan(String value) {
            addCriterion("xianStartDate >", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateGreaterThanOrEqualTo(String value) {
            addCriterion("xianStartDate >=", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateLessThan(String value) {
            addCriterion("xianStartDate <", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateLessThanOrEqualTo(String value) {
            addCriterion("xianStartDate <=", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateLike(String value) {
            addCriterion("xianStartDate like", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateNotLike(String value) {
            addCriterion("xianStartDate not like", value, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateIn(List<String> values) {
            addCriterion("xianStartDate in", values, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateNotIn(List<String> values) {
            addCriterion("xianStartDate not in", values, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateBetween(String value1, String value2) {
            addCriterion("xianStartDate between", value1, value2, "xianstartdate");
            return (Criteria) this;
        }

        public Criteria andXianstartdateNotBetween(String value1, String value2) {
            addCriterion("xianStartDate not between", value1, value2, "xianstartdate");
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