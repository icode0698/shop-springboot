package com.newboot.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImgExample() {
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

        public Criteria andImgIDIsNull() {
            addCriterion("imgID is null");
            return (Criteria) this;
        }

        public Criteria andImgIDIsNotNull() {
            addCriterion("imgID is not null");
            return (Criteria) this;
        }

        public Criteria andImgIDEqualTo(Integer value) {
            addCriterion("imgID =", value, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDNotEqualTo(Integer value) {
            addCriterion("imgID <>", value, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDGreaterThan(Integer value) {
            addCriterion("imgID >", value, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("imgID >=", value, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDLessThan(Integer value) {
            addCriterion("imgID <", value, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDLessThanOrEqualTo(Integer value) {
            addCriterion("imgID <=", value, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDIn(List<Integer> values) {
            addCriterion("imgID in", values, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDNotIn(List<Integer> values) {
            addCriterion("imgID not in", values, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDBetween(Integer value1, Integer value2) {
            addCriterion("imgID between", value1, value2, "imgID");
            return (Criteria) this;
        }

        public Criteria andImgIDNotBetween(Integer value1, Integer value2) {
            addCriterion("imgID not between", value1, value2, "imgID");
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

        public Criteria andImgSrcIsNull() {
            addCriterion("imgSrc is null");
            return (Criteria) this;
        }

        public Criteria andImgSrcIsNotNull() {
            addCriterion("imgSrc is not null");
            return (Criteria) this;
        }

        public Criteria andImgSrcEqualTo(String value) {
            addCriterion("imgSrc =", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotEqualTo(String value) {
            addCriterion("imgSrc <>", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcGreaterThan(String value) {
            addCriterion("imgSrc >", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("imgSrc >=", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLessThan(String value) {
            addCriterion("imgSrc <", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLessThanOrEqualTo(String value) {
            addCriterion("imgSrc <=", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcLike(String value) {
            addCriterion("imgSrc like", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotLike(String value) {
            addCriterion("imgSrc not like", value, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcIn(List<String> values) {
            addCriterion("imgSrc in", values, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotIn(List<String> values) {
            addCriterion("imgSrc not in", values, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcBetween(String value1, String value2) {
            addCriterion("imgSrc between", value1, value2, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andImgSrcNotBetween(String value1, String value2) {
            addCriterion("imgSrc not between", value1, value2, "imgSrc");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insertTime is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insertTime is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insertTime =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insertTime <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insertTime >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insertTime >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insertTime <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insertTime <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insertTime in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insertTime not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insertTime between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insertTime not between", value1, value2, "insertTime");
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