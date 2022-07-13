package com.newboot.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ParametervalueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParametervalueExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andValueidIsNull() {
            addCriterion("valueID is null");
            return (Criteria) this;
        }

        public Criteria andValueidIsNotNull() {
            addCriterion("valueID is not null");
            return (Criteria) this;
        }

        public Criteria andValueidEqualTo(Integer value) {
            addCriterion("valueID =", value, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidNotEqualTo(Integer value) {
            addCriterion("valueID <>", value, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidGreaterThan(Integer value) {
            addCriterion("valueID >", value, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidGreaterThanOrEqualTo(Integer value) {
            addCriterion("valueID >=", value, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidLessThan(Integer value) {
            addCriterion("valueID <", value, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidLessThanOrEqualTo(Integer value) {
            addCriterion("valueID <=", value, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidIn(List<Integer> values) {
            addCriterion("valueID in", values, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidNotIn(List<Integer> values) {
            addCriterion("valueID not in", values, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidBetween(Integer value1, Integer value2) {
            addCriterion("valueID between", value1, value2, "valueid");
            return (Criteria) this;
        }

        public Criteria andValueidNotBetween(Integer value1, Integer value2) {
            addCriterion("valueID not between", value1, value2, "valueid");
            return (Criteria) this;
        }

        public Criteria andParameteridIsNull() {
            addCriterion("parameterID is null");
            return (Criteria) this;
        }

        public Criteria andParameteridIsNotNull() {
            addCriterion("parameterID is not null");
            return (Criteria) this;
        }

        public Criteria andParameteridEqualTo(Integer value) {
            addCriterion("parameterID =", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridNotEqualTo(Integer value) {
            addCriterion("parameterID <>", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridGreaterThan(Integer value) {
            addCriterion("parameterID >", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("parameterID >=", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridLessThan(Integer value) {
            addCriterion("parameterID <", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridLessThanOrEqualTo(Integer value) {
            addCriterion("parameterID <=", value, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridIn(List<Integer> values) {
            addCriterion("parameterID in", values, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridNotIn(List<Integer> values) {
            addCriterion("parameterID not in", values, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridBetween(Integer value1, Integer value2) {
            addCriterion("parameterID between", value1, value2, "parameterid");
            return (Criteria) this;
        }

        public Criteria andParameteridNotBetween(Integer value1, Integer value2) {
            addCriterion("parameterID not between", value1, value2, "parameterid");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
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