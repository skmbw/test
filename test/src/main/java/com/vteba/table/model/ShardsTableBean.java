package com.vteba.table.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 分区表，schema下的分区表配置（shards_table）的复杂条件查询类。
 * 由代码工具自动生成。
 * @date 2014-10-31 15:51:24
 */
public class ShardsTableBean {
    /**
     * 逻辑or语句
     */
    protected List<Criteria> oredCriteria;

    /**
     * 创建schema下的分区表配置的复杂条件查询实例
     */
    public ShardsTableBean() {
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
     * schema下的分区表配置，对应数据库表 shards_table
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

        public Criteria andSchemaNameIsNull() {
            addCriterion("schema_name is null");
            return (Criteria) this;
        }

        public Criteria andSchemaNameIsNotNull() {
            addCriterion("schema_name is not null");
            return (Criteria) this;
        }

        public Criteria andSchemaNameEqualTo(String value) {
            addCriterion("schema_name =", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotEqualTo(String value) {
            addCriterion("schema_name <>", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameGreaterThan(String value) {
            addCriterion("schema_name >", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameGreaterThanOrEqualTo(String value) {
            addCriterion("schema_name >=", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameLessThan(String value) {
            addCriterion("schema_name <", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameLessThanOrEqualTo(String value) {
            addCriterion("schema_name <=", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameLike(String value) {
            addCriterion("schema_name like", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotLike(String value) {
            addCriterion("schema_name not like", value, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameIn(List<String> values) {
            addCriterion("schema_name in", values, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotIn(List<String> values) {
            addCriterion("schema_name not in", values, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameBetween(String value1, String value2) {
            addCriterion("schema_name between", value1, value2, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaNameNotBetween(String value1, String value2) {
            addCriterion("schema_name not between", value1, value2, "schemaName");
            return (Criteria) this;
        }

        public Criteria andSchemaIdIsNull() {
            addCriterion("schema_id is null");
            return (Criteria) this;
        }

        public Criteria andSchemaIdIsNotNull() {
            addCriterion("schema_id is not null");
            return (Criteria) this;
        }

        public Criteria andSchemaIdEqualTo(Long value) {
            addCriterion("schema_id =", value, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdNotEqualTo(Long value) {
            addCriterion("schema_id <>", value, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdGreaterThan(Long value) {
            addCriterion("schema_id >", value, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("schema_id >=", value, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdLessThan(Long value) {
            addCriterion("schema_id <", value, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdLessThanOrEqualTo(Long value) {
            addCriterion("schema_id <=", value, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdIn(List<Long> values) {
            addCriterion("schema_id in", values, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdNotIn(List<Long> values) {
            addCriterion("schema_id not in", values, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdBetween(Long value1, Long value2) {
            addCriterion("schema_id between", value1, value2, "schemaId");
            return (Criteria) this;
        }

        public Criteria andSchemaIdNotBetween(Long value1, Long value2) {
            addCriterion("schema_id not between", value1, value2, "schemaId");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("table_name =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("table_name >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("table_name <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("table_name like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("table_name not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("table_name in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andCurrentTableIsNull() {
            addCriterion("current_table is null");
            return (Criteria) this;
        }

        public Criteria andCurrentTableIsNotNull() {
            addCriterion("current_table is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentTableEqualTo(String value) {
            addCriterion("current_table =", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableNotEqualTo(String value) {
            addCriterion("current_table <>", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableGreaterThan(String value) {
            addCriterion("current_table >", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableGreaterThanOrEqualTo(String value) {
            addCriterion("current_table >=", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableLessThan(String value) {
            addCriterion("current_table <", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableLessThanOrEqualTo(String value) {
            addCriterion("current_table <=", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableLike(String value) {
            addCriterion("current_table like", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableNotLike(String value) {
            addCriterion("current_table not like", value, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableIn(List<String> values) {
            addCriterion("current_table in", values, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableNotIn(List<String> values) {
            addCriterion("current_table not in", values, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableBetween(String value1, String value2) {
            addCriterion("current_table between", value1, value2, "currentTable");
            return (Criteria) this;
        }

        public Criteria andCurrentTableNotBetween(String value1, String value2) {
            addCriterion("current_table not between", value1, value2, "currentTable");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNull() {
            addCriterion("strategy is null");
            return (Criteria) this;
        }

        public Criteria andStrategyIsNotNull() {
            addCriterion("strategy is not null");
            return (Criteria) this;
        }

        public Criteria andStrategyEqualTo(String value) {
            addCriterion("strategy =", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotEqualTo(String value) {
            addCriterion("strategy <>", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThan(String value) {
            addCriterion("strategy >", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyGreaterThanOrEqualTo(String value) {
            addCriterion("strategy >=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThan(String value) {
            addCriterion("strategy <", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLessThanOrEqualTo(String value) {
            addCriterion("strategy <=", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyLike(String value) {
            addCriterion("strategy like", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotLike(String value) {
            addCriterion("strategy not like", value, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyIn(List<String> values) {
            addCriterion("strategy in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotIn(List<String> values) {
            addCriterion("strategy not in", values, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyBetween(String value1, String value2) {
            addCriterion("strategy between", value1, value2, "strategy");
            return (Criteria) this;
        }

        public Criteria andStrategyNotBetween(String value1, String value2) {
            addCriterion("strategy not between", value1, value2, "strategy");
            return (Criteria) this;
        }

        public Criteria andFromIndexIsNull() {
            addCriterion("from_index is null");
            return (Criteria) this;
        }

        public Criteria andFromIndexIsNotNull() {
            addCriterion("from_index is not null");
            return (Criteria) this;
        }

        public Criteria andFromIndexEqualTo(Long value) {
            addCriterion("from_index =", value, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexNotEqualTo(Long value) {
            addCriterion("from_index <>", value, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexGreaterThan(Long value) {
            addCriterion("from_index >", value, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("from_index >=", value, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexLessThan(Long value) {
            addCriterion("from_index <", value, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexLessThanOrEqualTo(Long value) {
            addCriterion("from_index <=", value, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexIn(List<Long> values) {
            addCriterion("from_index in", values, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexNotIn(List<Long> values) {
            addCriterion("from_index not in", values, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexBetween(Long value1, Long value2) {
            addCriterion("from_index between", value1, value2, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andFromIndexNotBetween(Long value1, Long value2) {
            addCriterion("from_index not between", value1, value2, "fromIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexIsNull() {
            addCriterion("end_index is null");
            return (Criteria) this;
        }

        public Criteria andEndIndexIsNotNull() {
            addCriterion("end_index is not null");
            return (Criteria) this;
        }

        public Criteria andEndIndexEqualTo(Long value) {
            addCriterion("end_index =", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotEqualTo(Long value) {
            addCriterion("end_index <>", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexGreaterThan(Long value) {
            addCriterion("end_index >", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("end_index >=", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLessThan(Long value) {
            addCriterion("end_index <", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLessThanOrEqualTo(Long value) {
            addCriterion("end_index <=", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexIn(List<Long> values) {
            addCriterion("end_index in", values, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotIn(List<Long> values) {
            addCriterion("end_index not in", values, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexBetween(Long value1, Long value2) {
            addCriterion("end_index between", value1, value2, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotBetween(Long value1, Long value2) {
            addCriterion("end_index not between", value1, value2, "endIndex");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andCreateSqlIsNull() {
            addCriterion("create_sql is null");
            return (Criteria) this;
        }

        public Criteria andCreateSqlIsNotNull() {
            addCriterion("create_sql is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSqlEqualTo(String value) {
            addCriterion("create_sql =", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlNotEqualTo(String value) {
            addCriterion("create_sql <>", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlGreaterThan(String value) {
            addCriterion("create_sql >", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlGreaterThanOrEqualTo(String value) {
            addCriterion("create_sql >=", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlLessThan(String value) {
            addCriterion("create_sql <", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlLessThanOrEqualTo(String value) {
            addCriterion("create_sql <=", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlLike(String value) {
            addCriterion("create_sql like", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlNotLike(String value) {
            addCriterion("create_sql not like", value, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlIn(List<String> values) {
            addCriterion("create_sql in", values, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlNotIn(List<String> values) {
            addCriterion("create_sql not in", values, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlBetween(String value1, String value2) {
            addCriterion("create_sql between", value1, value2, "createSql");
            return (Criteria) this;
        }

        public Criteria andCreateSqlNotBetween(String value1, String value2) {
            addCriterion("create_sql not between", value1, value2, "createSql");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 shards_table
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * schema下的分区表配置，对应数据库表 shards_table
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