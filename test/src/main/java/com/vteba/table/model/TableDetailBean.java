package com.vteba.table.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 分区表，分区表明细信息，一个分区表下共有几个表（table_detail）的复杂条件查询类。
 * 由代码工具自动生成。
 * @date 2014-10-31 15:51:24
 */
public class TableDetailBean {
    /**
     * 逻辑or语句
     */
    protected List<Criteria> oredCriteria;

    /**
     * 创建分区表明细信息，一个分区表下共有几个表的复杂条件查询实例
     */
    public TableDetailBean() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * 获得逻辑or语句
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * 添加逻辑or语句
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * 新建逻辑或or语句
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * 创建查询条件，如果逻辑或为空，同时将查询条件放入。
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * 创建新查询条件。
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * 清楚逻辑或or语句，并且distinct为false，不去重。
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * 分区表明细信息，一个分区表下共有几个表，对应数据库表 table_detail
     */
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTableIndexIsNull() {
            addCriterion("table_index is null");
            return (Criteria) this;
        }

        public Criteria andTableIndexIsNotNull() {
            addCriterion("table_index is not null");
            return (Criteria) this;
        }

        public Criteria andTableIndexEqualTo(Long value) {
            addCriterion("table_index =", value, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexNotEqualTo(Long value) {
            addCriterion("table_index <>", value, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexGreaterThan(Long value) {
            addCriterion("table_index >", value, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("table_index >=", value, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexLessThan(Long value) {
            addCriterion("table_index <", value, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexLessThanOrEqualTo(Long value) {
            addCriterion("table_index <=", value, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexIn(List<Long> values) {
            addCriterion("table_index in", values, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexNotIn(List<Long> values) {
            addCriterion("table_index not in", values, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexBetween(Long value1, Long value2) {
            addCriterion("table_index between", value1, value2, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andTableIndexNotBetween(Long value1, Long value2) {
            addCriterion("table_index not between", value1, value2, "tableIndex");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdIsNull() {
            addCriterion("shards_table_id is null");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdIsNotNull() {
            addCriterion("shards_table_id is not null");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdEqualTo(Integer value) {
            addCriterion("shards_table_id =", value, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdNotEqualTo(Integer value) {
            addCriterion("shards_table_id <>", value, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdGreaterThan(Integer value) {
            addCriterion("shards_table_id >", value, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shards_table_id >=", value, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdLessThan(Integer value) {
            addCriterion("shards_table_id <", value, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdLessThanOrEqualTo(Integer value) {
            addCriterion("shards_table_id <=", value, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdIn(List<Integer> values) {
            addCriterion("shards_table_id in", values, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdNotIn(List<Integer> values) {
            addCriterion("shards_table_id not in", values, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdBetween(Integer value1, Integer value2) {
            addCriterion("shards_table_id between", value1, value2, "shardsTableId");
            return (Criteria) this;
        }

        public Criteria andShardsTableIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shards_table_id not between", value1, value2, "shardsTableId");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 table_detail
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 分区表明细信息，一个分区表下共有几个表，对应数据库表 table_detail
     */
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