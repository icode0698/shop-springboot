package com.newboot.shop.admin.model;

import java.util.ArrayList;
import java.util.List;

public class GoodspefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodspefExample() {
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

        public Criteria andSpIDIsNull() {
            addCriterion("spID is null");
            return (Criteria) this;
        }

        public Criteria andSpIDIsNotNull() {
            addCriterion("spID is not null");
            return (Criteria) this;
        }

        public Criteria andSpIDEqualTo(Integer value) {
            addCriterion("spID =", value, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDNotEqualTo(Integer value) {
            addCriterion("spID <>", value, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDGreaterThan(Integer value) {
            addCriterion("spID >", value, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("spID >=", value, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDLessThan(Integer value) {
            addCriterion("spID <", value, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDLessThanOrEqualTo(Integer value) {
            addCriterion("spID <=", value, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDIn(List<Integer> values) {
            addCriterion("spID in", values, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDNotIn(List<Integer> values) {
            addCriterion("spID not in", values, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDBetween(Integer value1, Integer value2) {
            addCriterion("spID between", value1, value2, "spID");
            return (Criteria) this;
        }

        public Criteria andSpIDNotBetween(Integer value1, Integer value2) {
            addCriterion("spID not between", value1, value2, "spID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDIsNull() {
            addCriterion("goodsID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIDIsNotNull() {
            addCriterion("goodsID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIDEqualTo(Integer value) {
            addCriterion("goodsID =", value, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDNotEqualTo(Integer value) {
            addCriterion("goodsID <>", value, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDGreaterThan(Integer value) {
            addCriterion("goodsID >", value, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsID >=", value, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDLessThan(Integer value) {
            addCriterion("goodsID <", value, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDLessThanOrEqualTo(Integer value) {
            addCriterion("goodsID <=", value, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDIn(List<Integer> values) {
            addCriterion("goodsID in", values, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDNotIn(List<Integer> values) {
            addCriterion("goodsID not in", values, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDBetween(Integer value1, Integer value2) {
            addCriterion("goodsID between", value1, value2, "goodsID");
            return (Criteria) this;
        }

        public Criteria andGoodsIDNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsID not between", value1, value2, "goodsID");
            return (Criteria) this;
        }

        public Criteria andValueIDIsNull() {
            addCriterion("valueID is null");
            return (Criteria) this;
        }

        public Criteria andValueIDIsNotNull() {
            addCriterion("valueID is not null");
            return (Criteria) this;
        }

        public Criteria andValueIDEqualTo(Integer value) {
            addCriterion("valueID =", value, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDNotEqualTo(Integer value) {
            addCriterion("valueID <>", value, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDGreaterThan(Integer value) {
            addCriterion("valueID >", value, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("valueID >=", value, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDLessThan(Integer value) {
            addCriterion("valueID <", value, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDLessThanOrEqualTo(Integer value) {
            addCriterion("valueID <=", value, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDIn(List<Integer> values) {
            addCriterion("valueID in", values, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDNotIn(List<Integer> values) {
            addCriterion("valueID not in", values, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDBetween(Integer value1, Integer value2) {
            addCriterion("valueID between", value1, value2, "valueID");
            return (Criteria) this;
        }

        public Criteria andValueIDNotBetween(Integer value1, Integer value2) {
            addCriterion("valueID not between", value1, value2, "valueID");
            return (Criteria) this;
        }

        public Criteria andParameterIDIsNull() {
            addCriterion("parameterID is null");
            return (Criteria) this;
        }

        public Criteria andParameterIDIsNotNull() {
            addCriterion("parameterID is not null");
            return (Criteria) this;
        }

        public Criteria andParameterIDEqualTo(Integer value) {
            addCriterion("parameterID =", value, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDNotEqualTo(Integer value) {
            addCriterion("parameterID <>", value, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDGreaterThan(Integer value) {
            addCriterion("parameterID >", value, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("parameterID >=", value, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDLessThan(Integer value) {
            addCriterion("parameterID <", value, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDLessThanOrEqualTo(Integer value) {
            addCriterion("parameterID <=", value, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDIn(List<Integer> values) {
            addCriterion("parameterID in", values, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDNotIn(List<Integer> values) {
            addCriterion("parameterID not in", values, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDBetween(Integer value1, Integer value2) {
            addCriterion("parameterID between", value1, value2, "parameterID");
            return (Criteria) this;
        }

        public Criteria andParameterIDNotBetween(Integer value1, Integer value2) {
            addCriterion("parameterID not between", value1, value2, "parameterID");
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