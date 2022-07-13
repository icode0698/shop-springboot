package com.newboot.shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceExample() {
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

        public Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (Criteria) this;
        }

        public Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (Criteria) this;
        }

        public Criteria andSkuEqualTo(Integer value) {
            addCriterion("sku =", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotEqualTo(Integer value) {
            addCriterion("sku <>", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThan(Integer value) {
            addCriterion("sku >", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku >=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThan(Integer value) {
            addCriterion("sku <", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuLessThanOrEqualTo(Integer value) {
            addCriterion("sku <=", value, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuIn(List<Integer> values) {
            addCriterion("sku in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotIn(List<Integer> values) {
            addCriterion("sku not in", values, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuBetween(Integer value1, Integer value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andSkuNotBetween(Integer value1, Integer value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsID =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsID <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsID >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsID >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsID <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsID <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsID in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsID not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsID between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsID not between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andSpid1IsNull() {
            addCriterion("spID1 is null");
            return (Criteria) this;
        }

        public Criteria andSpid1IsNotNull() {
            addCriterion("spID1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpid1EqualTo(Integer value) {
            addCriterion("spID1 =", value, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1NotEqualTo(Integer value) {
            addCriterion("spID1 <>", value, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1GreaterThan(Integer value) {
            addCriterion("spID1 >", value, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1GreaterThanOrEqualTo(Integer value) {
            addCriterion("spID1 >=", value, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1LessThan(Integer value) {
            addCriterion("spID1 <", value, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1LessThanOrEqualTo(Integer value) {
            addCriterion("spID1 <=", value, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1In(List<Integer> values) {
            addCriterion("spID1 in", values, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1NotIn(List<Integer> values) {
            addCriterion("spID1 not in", values, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1Between(Integer value1, Integer value2) {
            addCriterion("spID1 between", value1, value2, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid1NotBetween(Integer value1, Integer value2) {
            addCriterion("spID1 not between", value1, value2, "spid1");
            return (Criteria) this;
        }

        public Criteria andSpid2IsNull() {
            addCriterion("spID2 is null");
            return (Criteria) this;
        }

        public Criteria andSpid2IsNotNull() {
            addCriterion("spID2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpid2EqualTo(Integer value) {
            addCriterion("spID2 =", value, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2NotEqualTo(Integer value) {
            addCriterion("spID2 <>", value, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2GreaterThan(Integer value) {
            addCriterion("spID2 >", value, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2GreaterThanOrEqualTo(Integer value) {
            addCriterion("spID2 >=", value, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2LessThan(Integer value) {
            addCriterion("spID2 <", value, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2LessThanOrEqualTo(Integer value) {
            addCriterion("spID2 <=", value, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2In(List<Integer> values) {
            addCriterion("spID2 in", values, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2NotIn(List<Integer> values) {
            addCriterion("spID2 not in", values, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2Between(Integer value1, Integer value2) {
            addCriterion("spID2 between", value1, value2, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid2NotBetween(Integer value1, Integer value2) {
            addCriterion("spID2 not between", value1, value2, "spid2");
            return (Criteria) this;
        }

        public Criteria andSpid3IsNull() {
            addCriterion("spID3 is null");
            return (Criteria) this;
        }

        public Criteria andSpid3IsNotNull() {
            addCriterion("spID3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpid3EqualTo(Integer value) {
            addCriterion("spID3 =", value, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3NotEqualTo(Integer value) {
            addCriterion("spID3 <>", value, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3GreaterThan(Integer value) {
            addCriterion("spID3 >", value, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3GreaterThanOrEqualTo(Integer value) {
            addCriterion("spID3 >=", value, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3LessThan(Integer value) {
            addCriterion("spID3 <", value, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3LessThanOrEqualTo(Integer value) {
            addCriterion("spID3 <=", value, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3In(List<Integer> values) {
            addCriterion("spID3 in", values, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3NotIn(List<Integer> values) {
            addCriterion("spID3 not in", values, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3Between(Integer value1, Integer value2) {
            addCriterion("spID3 between", value1, value2, "spid3");
            return (Criteria) this;
        }

        public Criteria andSpid3NotBetween(Integer value1, Integer value2) {
            addCriterion("spID3 not between", value1, value2, "spid3");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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