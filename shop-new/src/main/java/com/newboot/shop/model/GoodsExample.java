package com.newboot.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andCategoryIDIsNull() {
            addCriterion("categoryID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIDIsNotNull() {
            addCriterion("categoryID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIDEqualTo(Integer value) {
            addCriterion("categoryID =", value, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDNotEqualTo(Integer value) {
            addCriterion("categoryID <>", value, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDGreaterThan(Integer value) {
            addCriterion("categoryID >", value, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("categoryID >=", value, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDLessThan(Integer value) {
            addCriterion("categoryID <", value, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDLessThanOrEqualTo(Integer value) {
            addCriterion("categoryID <=", value, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDIn(List<Integer> values) {
            addCriterion("categoryID in", values, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDNotIn(List<Integer> values) {
            addCriterion("categoryID not in", values, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDBetween(Integer value1, Integer value2) {
            addCriterion("categoryID between", value1, value2, "categoryID");
            return (Criteria) this;
        }

        public Criteria andCategoryIDNotBetween(Integer value1, Integer value2) {
            addCriterion("categoryID not between", value1, value2, "categoryID");
            return (Criteria) this;
        }

        public Criteria andBrandIDIsNull() {
            addCriterion("brandID is null");
            return (Criteria) this;
        }

        public Criteria andBrandIDIsNotNull() {
            addCriterion("brandID is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIDEqualTo(Integer value) {
            addCriterion("brandID =", value, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDNotEqualTo(Integer value) {
            addCriterion("brandID <>", value, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDGreaterThan(Integer value) {
            addCriterion("brandID >", value, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("brandID >=", value, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDLessThan(Integer value) {
            addCriterion("brandID <", value, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDLessThanOrEqualTo(Integer value) {
            addCriterion("brandID <=", value, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDIn(List<Integer> values) {
            addCriterion("brandID in", values, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDNotIn(List<Integer> values) {
            addCriterion("brandID not in", values, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDBetween(Integer value1, Integer value2) {
            addCriterion("brandID between", value1, value2, "brandID");
            return (Criteria) this;
        }

        public Criteria andBrandIDNotBetween(Integer value1, Integer value2) {
            addCriterion("brandID not between", value1, value2, "brandID");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goodsName is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goodsName is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goodsName =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goodsName <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goodsName >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsName >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goodsName <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goodsName <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goodsName like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goodsName not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goodsName in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goodsName not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goodsName between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goodsName not between", value1, value2, "goodsName");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
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