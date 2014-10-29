package com.vteba.schema.model;

import java.util.ArrayList;
import java.util.List;

public class SchemaInfoBean {
    /**
     * 逻辑or语句
     * 对应数据库表字段 schema_info
     */
    protected List<Criteria> oredCriteria;

    /**
     */
    public SchemaInfoBean() {
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
     * 该类对应数据库表 schema_info
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

        public Criteria andSchemaDescIsNull() {
            addCriterion("schema_desc is null");
            return (Criteria) this;
        }

        public Criteria andSchemaDescIsNotNull() {
            addCriterion("schema_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSchemaDescEqualTo(String value) {
            addCriterion("schema_desc =", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescNotEqualTo(String value) {
            addCriterion("schema_desc <>", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescGreaterThan(String value) {
            addCriterion("schema_desc >", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescGreaterThanOrEqualTo(String value) {
            addCriterion("schema_desc >=", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescLessThan(String value) {
            addCriterion("schema_desc <", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescLessThanOrEqualTo(String value) {
            addCriterion("schema_desc <=", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescLike(String value) {
            addCriterion("schema_desc like", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescNotLike(String value) {
            addCriterion("schema_desc not like", value, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescIn(List<String> values) {
            addCriterion("schema_desc in", values, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescNotIn(List<String> values) {
            addCriterion("schema_desc not in", values, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescBetween(String value1, String value2) {
            addCriterion("schema_desc between", value1, value2, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andSchemaDescNotBetween(String value1, String value2) {
            addCriterion("schema_desc not between", value1, value2, "schemaDesc");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNull() {
            addCriterion("db_type is null");
            return (Criteria) this;
        }

        public Criteria andDbTypeIsNotNull() {
            addCriterion("db_type is not null");
            return (Criteria) this;
        }

        public Criteria andDbTypeEqualTo(String value) {
            addCriterion("db_type =", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotEqualTo(String value) {
            addCriterion("db_type <>", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThan(String value) {
            addCriterion("db_type >", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeGreaterThanOrEqualTo(String value) {
            addCriterion("db_type >=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThan(String value) {
            addCriterion("db_type <", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLessThanOrEqualTo(String value) {
            addCriterion("db_type <=", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeLike(String value) {
            addCriterion("db_type like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotLike(String value) {
            addCriterion("db_type not like", value, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeIn(List<String> values) {
            addCriterion("db_type in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotIn(List<String> values) {
            addCriterion("db_type not in", values, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeBetween(String value1, String value2) {
            addCriterion("db_type between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andDbTypeNotBetween(String value1, String value2) {
            addCriterion("db_type not between", value1, value2, "dbType");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlIsNull() {
            addCriterion("jdbc_url is null");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlIsNotNull() {
            addCriterion("jdbc_url is not null");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlEqualTo(String value) {
            addCriterion("jdbc_url =", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotEqualTo(String value) {
            addCriterion("jdbc_url <>", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlGreaterThan(String value) {
            addCriterion("jdbc_url >", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlGreaterThanOrEqualTo(String value) {
            addCriterion("jdbc_url >=", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlLessThan(String value) {
            addCriterion("jdbc_url <", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlLessThanOrEqualTo(String value) {
            addCriterion("jdbc_url <=", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlLike(String value) {
            addCriterion("jdbc_url like", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotLike(String value) {
            addCriterion("jdbc_url not like", value, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlIn(List<String> values) {
            addCriterion("jdbc_url in", values, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotIn(List<String> values) {
            addCriterion("jdbc_url not in", values, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlBetween(String value1, String value2) {
            addCriterion("jdbc_url between", value1, value2, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andJdbcUrlNotBetween(String value1, String value2) {
            addCriterion("jdbc_url not between", value1, value2, "jdbcUrl");
            return (Criteria) this;
        }

        public Criteria andPasswordsIsNull() {
            addCriterion("passwords is null");
            return (Criteria) this;
        }

        public Criteria andPasswordsIsNotNull() {
            addCriterion("passwords is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordsEqualTo(String value) {
            addCriterion("passwords =", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsNotEqualTo(String value) {
            addCriterion("passwords <>", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsGreaterThan(String value) {
            addCriterion("passwords >", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsGreaterThanOrEqualTo(String value) {
            addCriterion("passwords >=", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsLessThan(String value) {
            addCriterion("passwords <", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsLessThanOrEqualTo(String value) {
            addCriterion("passwords <=", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsLike(String value) {
            addCriterion("passwords like", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsNotLike(String value) {
            addCriterion("passwords not like", value, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsIn(List<String> values) {
            addCriterion("passwords in", values, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsNotIn(List<String> values) {
            addCriterion("passwords not in", values, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsBetween(String value1, String value2) {
            addCriterion("passwords between", value1, value2, "passwords");
            return (Criteria) this;
        }

        public Criteria andPasswordsNotBetween(String value1, String value2) {
            addCriterion("passwords not between", value1, value2, "passwords");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Long value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Long value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Long value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Long value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Long value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Long value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Long> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Long> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Long value1, Long value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Long value1, Long value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andInitialSizeIsNull() {
            addCriterion("initial_size is null");
            return (Criteria) this;
        }

        public Criteria andInitialSizeIsNotNull() {
            addCriterion("initial_size is not null");
            return (Criteria) this;
        }

        public Criteria andInitialSizeEqualTo(Integer value) {
            addCriterion("initial_size =", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeNotEqualTo(Integer value) {
            addCriterion("initial_size <>", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeGreaterThan(Integer value) {
            addCriterion("initial_size >", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("initial_size >=", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeLessThan(Integer value) {
            addCriterion("initial_size <", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeLessThanOrEqualTo(Integer value) {
            addCriterion("initial_size <=", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeIn(List<Integer> values) {
            addCriterion("initial_size in", values, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeNotIn(List<Integer> values) {
            addCriterion("initial_size not in", values, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeBetween(Integer value1, Integer value2) {
            addCriterion("initial_size between", value1, value2, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("initial_size not between", value1, value2, "initialSize");
            return (Criteria) this;
        }

        public Criteria andMinIdleIsNull() {
            addCriterion("min_idle is null");
            return (Criteria) this;
        }

        public Criteria andMinIdleIsNotNull() {
            addCriterion("min_idle is not null");
            return (Criteria) this;
        }

        public Criteria andMinIdleEqualTo(Integer value) {
            addCriterion("min_idle =", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotEqualTo(Integer value) {
            addCriterion("min_idle <>", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleGreaterThan(Integer value) {
            addCriterion("min_idle >", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_idle >=", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleLessThan(Integer value) {
            addCriterion("min_idle <", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleLessThanOrEqualTo(Integer value) {
            addCriterion("min_idle <=", value, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleIn(List<Integer> values) {
            addCriterion("min_idle in", values, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotIn(List<Integer> values) {
            addCriterion("min_idle not in", values, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleBetween(Integer value1, Integer value2) {
            addCriterion("min_idle between", value1, value2, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMinIdleNotBetween(Integer value1, Integer value2) {
            addCriterion("min_idle not between", value1, value2, "minIdle");
            return (Criteria) this;
        }

        public Criteria andMaxActiveIsNull() {
            addCriterion("max_active is null");
            return (Criteria) this;
        }

        public Criteria andMaxActiveIsNotNull() {
            addCriterion("max_active is not null");
            return (Criteria) this;
        }

        public Criteria andMaxActiveEqualTo(Integer value) {
            addCriterion("max_active =", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveNotEqualTo(Integer value) {
            addCriterion("max_active <>", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveGreaterThan(Integer value) {
            addCriterion("max_active >", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_active >=", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveLessThan(Integer value) {
            addCriterion("max_active <", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveLessThanOrEqualTo(Integer value) {
            addCriterion("max_active <=", value, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveIn(List<Integer> values) {
            addCriterion("max_active in", values, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveNotIn(List<Integer> values) {
            addCriterion("max_active not in", values, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveBetween(Integer value1, Integer value2) {
            addCriterion("max_active between", value1, value2, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxActiveNotBetween(Integer value1, Integer value2) {
            addCriterion("max_active not between", value1, value2, "maxActive");
            return (Criteria) this;
        }

        public Criteria andMaxWaitIsNull() {
            addCriterion("max_wait is null");
            return (Criteria) this;
        }

        public Criteria andMaxWaitIsNotNull() {
            addCriterion("max_wait is not null");
            return (Criteria) this;
        }

        public Criteria andMaxWaitEqualTo(Long value) {
            addCriterion("max_wait =", value, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitNotEqualTo(Long value) {
            addCriterion("max_wait <>", value, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitGreaterThan(Long value) {
            addCriterion("max_wait >", value, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitGreaterThanOrEqualTo(Long value) {
            addCriterion("max_wait >=", value, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitLessThan(Long value) {
            addCriterion("max_wait <", value, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitLessThanOrEqualTo(Long value) {
            addCriterion("max_wait <=", value, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitIn(List<Long> values) {
            addCriterion("max_wait in", values, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitNotIn(List<Long> values) {
            addCriterion("max_wait not in", values, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitBetween(Long value1, Long value2) {
            addCriterion("max_wait between", value1, value2, "maxWait");
            return (Criteria) this;
        }

        public Criteria andMaxWaitNotBetween(Long value1, Long value2) {
            addCriterion("max_wait not between", value1, value2, "maxWait");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsIsNull() {
            addCriterion("between_eviction_runs is null");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsIsNotNull() {
            addCriterion("between_eviction_runs is not null");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsEqualTo(Long value) {
            addCriterion("between_eviction_runs =", value, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsNotEqualTo(Long value) {
            addCriterion("between_eviction_runs <>", value, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsGreaterThan(Long value) {
            addCriterion("between_eviction_runs >", value, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsGreaterThanOrEqualTo(Long value) {
            addCriterion("between_eviction_runs >=", value, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsLessThan(Long value) {
            addCriterion("between_eviction_runs <", value, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsLessThanOrEqualTo(Long value) {
            addCriterion("between_eviction_runs <=", value, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsIn(List<Long> values) {
            addCriterion("between_eviction_runs in", values, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsNotIn(List<Long> values) {
            addCriterion("between_eviction_runs not in", values, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsBetween(Long value1, Long value2) {
            addCriterion("between_eviction_runs between", value1, value2, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andBetweenEvictionRunsNotBetween(Long value1, Long value2) {
            addCriterion("between_eviction_runs not between", value1, value2, "betweenEvictionRuns");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleIsNull() {
            addCriterion("min_evictable_idle is null");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleIsNotNull() {
            addCriterion("min_evictable_idle is not null");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleEqualTo(Long value) {
            addCriterion("min_evictable_idle =", value, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleNotEqualTo(Long value) {
            addCriterion("min_evictable_idle <>", value, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleGreaterThan(Long value) {
            addCriterion("min_evictable_idle >", value, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleGreaterThanOrEqualTo(Long value) {
            addCriterion("min_evictable_idle >=", value, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleLessThan(Long value) {
            addCriterion("min_evictable_idle <", value, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleLessThanOrEqualTo(Long value) {
            addCriterion("min_evictable_idle <=", value, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleIn(List<Long> values) {
            addCriterion("min_evictable_idle in", values, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleNotIn(List<Long> values) {
            addCriterion("min_evictable_idle not in", values, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleBetween(Long value1, Long value2) {
            addCriterion("min_evictable_idle between", value1, value2, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andMinEvictableIdleNotBetween(Long value1, Long value2) {
            addCriterion("min_evictable_idle not between", value1, value2, "minEvictableIdle");
            return (Criteria) this;
        }

        public Criteria andValidationQueryIsNull() {
            addCriterion("validation_query is null");
            return (Criteria) this;
        }

        public Criteria andValidationQueryIsNotNull() {
            addCriterion("validation_query is not null");
            return (Criteria) this;
        }

        public Criteria andValidationQueryEqualTo(String value) {
            addCriterion("validation_query =", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryNotEqualTo(String value) {
            addCriterion("validation_query <>", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryGreaterThan(String value) {
            addCriterion("validation_query >", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryGreaterThanOrEqualTo(String value) {
            addCriterion("validation_query >=", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryLessThan(String value) {
            addCriterion("validation_query <", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryLessThanOrEqualTo(String value) {
            addCriterion("validation_query <=", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryLike(String value) {
            addCriterion("validation_query like", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryNotLike(String value) {
            addCriterion("validation_query not like", value, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryIn(List<String> values) {
            addCriterion("validation_query in", values, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryNotIn(List<String> values) {
            addCriterion("validation_query not in", values, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryBetween(String value1, String value2) {
            addCriterion("validation_query between", value1, value2, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andValidationQueryNotBetween(String value1, String value2) {
            addCriterion("validation_query not between", value1, value2, "validationQuery");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleIsNull() {
            addCriterion("test_while_idle is null");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleIsNotNull() {
            addCriterion("test_while_idle is not null");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleEqualTo(Boolean value) {
            addCriterion("test_while_idle =", value, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleNotEqualTo(Boolean value) {
            addCriterion("test_while_idle <>", value, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleGreaterThan(Boolean value) {
            addCriterion("test_while_idle >", value, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("test_while_idle >=", value, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleLessThan(Boolean value) {
            addCriterion("test_while_idle <", value, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleLessThanOrEqualTo(Boolean value) {
            addCriterion("test_while_idle <=", value, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleIn(List<Boolean> values) {
            addCriterion("test_while_idle in", values, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleNotIn(List<Boolean> values) {
            addCriterion("test_while_idle not in", values, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleBetween(Boolean value1, Boolean value2) {
            addCriterion("test_while_idle between", value1, value2, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestWhileIdleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("test_while_idle not between", value1, value2, "testWhileIdle");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowIsNull() {
            addCriterion("test_on_borrow is null");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowIsNotNull() {
            addCriterion("test_on_borrow is not null");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowEqualTo(Boolean value) {
            addCriterion("test_on_borrow =", value, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowNotEqualTo(Boolean value) {
            addCriterion("test_on_borrow <>", value, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowGreaterThan(Boolean value) {
            addCriterion("test_on_borrow >", value, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("test_on_borrow >=", value, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowLessThan(Boolean value) {
            addCriterion("test_on_borrow <", value, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowLessThanOrEqualTo(Boolean value) {
            addCriterion("test_on_borrow <=", value, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowIn(List<Boolean> values) {
            addCriterion("test_on_borrow in", values, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowNotIn(List<Boolean> values) {
            addCriterion("test_on_borrow not in", values, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowBetween(Boolean value1, Boolean value2) {
            addCriterion("test_on_borrow between", value1, value2, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnBorrowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("test_on_borrow not between", value1, value2, "testOnBorrow");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnIsNull() {
            addCriterion("test_on_return is null");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnIsNotNull() {
            addCriterion("test_on_return is not null");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnEqualTo(Boolean value) {
            addCriterion("test_on_return =", value, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnNotEqualTo(Boolean value) {
            addCriterion("test_on_return <>", value, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnGreaterThan(Boolean value) {
            addCriterion("test_on_return >", value, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnGreaterThanOrEqualTo(Boolean value) {
            addCriterion("test_on_return >=", value, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnLessThan(Boolean value) {
            addCriterion("test_on_return <", value, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnLessThanOrEqualTo(Boolean value) {
            addCriterion("test_on_return <=", value, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnIn(List<Boolean> values) {
            addCriterion("test_on_return in", values, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnNotIn(List<Boolean> values) {
            addCriterion("test_on_return not in", values, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnBetween(Boolean value1, Boolean value2) {
            addCriterion("test_on_return between", value1, value2, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andTestOnReturnNotBetween(Boolean value1, Boolean value2) {
            addCriterion("test_on_return not between", value1, value2, "testOnReturn");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtIsNull() {
            addCriterion("pool_propared_stmt is null");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtIsNotNull() {
            addCriterion("pool_propared_stmt is not null");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtEqualTo(Boolean value) {
            addCriterion("pool_propared_stmt =", value, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtNotEqualTo(Boolean value) {
            addCriterion("pool_propared_stmt <>", value, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtGreaterThan(Boolean value) {
            addCriterion("pool_propared_stmt >", value, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pool_propared_stmt >=", value, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtLessThan(Boolean value) {
            addCriterion("pool_propared_stmt <", value, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtLessThanOrEqualTo(Boolean value) {
            addCriterion("pool_propared_stmt <=", value, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtIn(List<Boolean> values) {
            addCriterion("pool_propared_stmt in", values, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtNotIn(List<Boolean> values) {
            addCriterion("pool_propared_stmt not in", values, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtBetween(Boolean value1, Boolean value2) {
            addCriterion("pool_propared_stmt between", value1, value2, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andPoolProparedStmtNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pool_propared_stmt not between", value1, value2, "poolProparedStmt");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnIsNull() {
            addCriterion("max_pstmt_per_conn is null");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnIsNotNull() {
            addCriterion("max_pstmt_per_conn is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnEqualTo(Integer value) {
            addCriterion("max_pstmt_per_conn =", value, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnNotEqualTo(Integer value) {
            addCriterion("max_pstmt_per_conn <>", value, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnGreaterThan(Integer value) {
            addCriterion("max_pstmt_per_conn >", value, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_pstmt_per_conn >=", value, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnLessThan(Integer value) {
            addCriterion("max_pstmt_per_conn <", value, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnLessThanOrEqualTo(Integer value) {
            addCriterion("max_pstmt_per_conn <=", value, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnIn(List<Integer> values) {
            addCriterion("max_pstmt_per_conn in", values, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnNotIn(List<Integer> values) {
            addCriterion("max_pstmt_per_conn not in", values, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnBetween(Integer value1, Integer value2) {
            addCriterion("max_pstmt_per_conn between", value1, value2, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andMaxPstmtPerConnNotBetween(Integer value1, Integer value2) {
            addCriterion("max_pstmt_per_conn not between", value1, value2, "maxPstmtPerConn");
            return (Criteria) this;
        }

        public Criteria andPeerIdIsNull() {
            addCriterion("peer_id is null");
            return (Criteria) this;
        }

        public Criteria andPeerIdIsNotNull() {
            addCriterion("peer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeerIdEqualTo(Long value) {
            addCriterion("peer_id =", value, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdNotEqualTo(Long value) {
            addCriterion("peer_id <>", value, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdGreaterThan(Long value) {
            addCriterion("peer_id >", value, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("peer_id >=", value, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdLessThan(Long value) {
            addCriterion("peer_id <", value, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdLessThanOrEqualTo(Long value) {
            addCriterion("peer_id <=", value, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdIn(List<Long> values) {
            addCriterion("peer_id in", values, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdNotIn(List<Long> values) {
            addCriterion("peer_id not in", values, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdBetween(Long value1, Long value2) {
            addCriterion("peer_id between", value1, value2, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerIdNotBetween(Long value1, Long value2) {
            addCriterion("peer_id not between", value1, value2, "peerId");
            return (Criteria) this;
        }

        public Criteria andPeerNameIsNull() {
            addCriterion("peer_name is null");
            return (Criteria) this;
        }

        public Criteria andPeerNameIsNotNull() {
            addCriterion("peer_name is not null");
            return (Criteria) this;
        }

        public Criteria andPeerNameEqualTo(String value) {
            addCriterion("peer_name =", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameNotEqualTo(String value) {
            addCriterion("peer_name <>", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameGreaterThan(String value) {
            addCriterion("peer_name >", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameGreaterThanOrEqualTo(String value) {
            addCriterion("peer_name >=", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameLessThan(String value) {
            addCriterion("peer_name <", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameLessThanOrEqualTo(String value) {
            addCriterion("peer_name <=", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameLike(String value) {
            addCriterion("peer_name like", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameNotLike(String value) {
            addCriterion("peer_name not like", value, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameIn(List<String> values) {
            addCriterion("peer_name in", values, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameNotIn(List<String> values) {
            addCriterion("peer_name not in", values, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameBetween(String value1, String value2) {
            addCriterion("peer_name between", value1, value2, "peerName");
            return (Criteria) this;
        }

        public Criteria andPeerNameNotBetween(String value1, String value2) {
            addCriterion("peer_name not between", value1, value2, "peerName");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andReadWeightIsNull() {
            addCriterion("read_weight is null");
            return (Criteria) this;
        }

        public Criteria andReadWeightIsNotNull() {
            addCriterion("read_weight is not null");
            return (Criteria) this;
        }

        public Criteria andReadWeightEqualTo(Integer value) {
            addCriterion("read_weight =", value, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightNotEqualTo(Integer value) {
            addCriterion("read_weight <>", value, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightGreaterThan(Integer value) {
            addCriterion("read_weight >", value, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_weight >=", value, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightLessThan(Integer value) {
            addCriterion("read_weight <", value, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightLessThanOrEqualTo(Integer value) {
            addCriterion("read_weight <=", value, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightIn(List<Integer> values) {
            addCriterion("read_weight in", values, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightNotIn(List<Integer> values) {
            addCriterion("read_weight not in", values, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightBetween(Integer value1, Integer value2) {
            addCriterion("read_weight between", value1, value2, "readWeight");
            return (Criteria) this;
        }

        public Criteria andReadWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("read_weight not between", value1, value2, "readWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightIsNull() {
            addCriterion("write_weight is null");
            return (Criteria) this;
        }

        public Criteria andWriteWeightIsNotNull() {
            addCriterion("write_weight is not null");
            return (Criteria) this;
        }

        public Criteria andWriteWeightEqualTo(Integer value) {
            addCriterion("write_weight =", value, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightNotEqualTo(Integer value) {
            addCriterion("write_weight <>", value, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightGreaterThan(Integer value) {
            addCriterion("write_weight >", value, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("write_weight >=", value, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightLessThan(Integer value) {
            addCriterion("write_weight <", value, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightLessThanOrEqualTo(Integer value) {
            addCriterion("write_weight <=", value, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightIn(List<Integer> values) {
            addCriterion("write_weight in", values, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightNotIn(List<Integer> values) {
            addCriterion("write_weight not in", values, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightBetween(Integer value1, Integer value2) {
            addCriterion("write_weight between", value1, value2, "writeWeight");
            return (Criteria) this;
        }

        public Criteria andWriteWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("write_weight not between", value1, value2, "writeWeight");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 schema_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 该类对应数据库表 schema_info
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