package com.vteba.schema.model;

public class SchemaInfo {
    /**
     * 对应数据库表字段 schema_info.schema_id
     */
    private Long schemaId;

    /**
     * 对应数据库表字段 schema_info.schema_name
     */
    private String schemaName;

    /**
     * 对应数据库表字段 schema_info.schema_desc
     */
    private String schemaDesc;

    /**
     * 对应数据库表字段 schema_info.db_type
     */
    private String dbType;

    /**
     * 对应数据库表字段 schema_info.ip
     */
    private String ip;

    /**
     * 对应数据库表字段 schema_info.port
     */
    private Integer port;

    /**
     * 对应数据库表字段 schema_info.jdbc_url
     */
    private String jdbcUrl;

    /**
     * 对应数据库表字段 schema_info.passwords
     */
    private String passwords;

    /**
     * 对应数据库表字段 schema_info.app_id
     */
    private Long appId;

    /**
     * 对应数据库表字段 schema_info.initial_size
     */
    private Integer initialSize;

    /**
     * 对应数据库表字段 schema_info.min_idle
     */
    private Integer minIdle;

    /**
     * 对应数据库表字段 schema_info.max_active
     */
    private Integer maxActive;

    /**
     * 对应数据库表字段 schema_info.max_wait
     */
    private Long maxWait;

    /**
     * 对应数据库表字段 schema_info.between_eviction_runs
     */
    private Long betweenEvictionRuns;

    /**
     * 对应数据库表字段 schema_info.min_evictable_idle
     */
    private Long minEvictableIdle;

    /**
     * 对应数据库表字段 schema_info.validation_query
     */
    private String validationQuery;

    /**
     * 对应数据库表字段 schema_info.test_while_idle
     */
    private Boolean testWhileIdle;

    /**
     * 对应数据库表字段 schema_info.test_on_borrow
     */
    private Boolean testOnBorrow;

    /**
     * 对应数据库表字段 schema_info.test_on_return
     */
    private Boolean testOnReturn;

    /**
     * 对应数据库表字段 schema_info.pool_propared_stmt
     */
    private Boolean poolProparedStmt;

    /**
     * 对应数据库表字段 schema_info.max_pstmt_per_conn
     */
    private Integer maxPstmtPerConn;

    /**
     * 获得字段 schema_info.schema_id 的值
     *
     * @return the value of schema_info.schema_id
     */
    public Long getSchemaId() {
        return schemaId;
    }

    /**
     * 设置字段 schema_info.schema_id 的值
     *
     * @param schemaId the value for schema_info.schema_id
     */
    public void setSchemaId(Long schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * 获得字段 schema_info.schema_name 的值
     *
     * @return the value of schema_info.schema_name
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * 设置字段 schema_info.schema_name 的值
     *
     * @param schemaName the value for schema_info.schema_name
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * 获得字段 schema_info.schema_desc 的值
     *
     * @return the value of schema_info.schema_desc
     */
    public String getSchemaDesc() {
        return schemaDesc;
    }

    /**
     * 设置字段 schema_info.schema_desc 的值
     *
     * @param schemaDesc the value for schema_info.schema_desc
     */
    public void setSchemaDesc(String schemaDesc) {
        this.schemaDesc = schemaDesc;
    }

    /**
     * 获得字段 schema_info.db_type 的值
     *
     * @return the value of schema_info.db_type
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * 设置字段 schema_info.db_type 的值
     *
     * @param dbType the value for schema_info.db_type
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * 获得字段 schema_info.ip 的值
     *
     * @return the value of schema_info.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置字段 schema_info.ip 的值
     *
     * @param ip the value for schema_info.ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获得字段 schema_info.port 的值
     *
     * @return the value of schema_info.port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 设置字段 schema_info.port 的值
     *
     * @param port the value for schema_info.port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 获得字段 schema_info.jdbc_url 的值
     *
     * @return the value of schema_info.jdbc_url
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * 设置字段 schema_info.jdbc_url 的值
     *
     * @param jdbcUrl the value for schema_info.jdbc_url
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * 获得字段 schema_info.passwords 的值
     *
     * @return the value of schema_info.passwords
     */
    public String getPasswords() {
        return passwords;
    }

    /**
     * 设置字段 schema_info.passwords 的值
     *
     * @param passwords the value for schema_info.passwords
     */
    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    /**
     * 获得字段 schema_info.app_id 的值
     *
     * @return the value of schema_info.app_id
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置字段 schema_info.app_id 的值
     *
     * @param appId the value for schema_info.app_id
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获得字段 schema_info.initial_size 的值
     *
     * @return the value of schema_info.initial_size
     */
    public Integer getInitialSize() {
        return initialSize;
    }

    /**
     * 设置字段 schema_info.initial_size 的值
     *
     * @param initialSize the value for schema_info.initial_size
     */
    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    /**
     * 获得字段 schema_info.min_idle 的值
     *
     * @return the value of schema_info.min_idle
     */
    public Integer getMinIdle() {
        return minIdle;
    }

    /**
     * 设置字段 schema_info.min_idle 的值
     *
     * @param minIdle the value for schema_info.min_idle
     */
    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    /**
     * 获得字段 schema_info.max_active 的值
     *
     * @return the value of schema_info.max_active
     */
    public Integer getMaxActive() {
        return maxActive;
    }

    /**
     * 设置字段 schema_info.max_active 的值
     *
     * @param maxActive the value for schema_info.max_active
     */
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * 获得字段 schema_info.max_wait 的值
     *
     * @return the value of schema_info.max_wait
     */
    public Long getMaxWait() {
        return maxWait;
    }

    /**
     * 设置字段 schema_info.max_wait 的值
     *
     * @param maxWait the value for schema_info.max_wait
     */
    public void setMaxWait(Long maxWait) {
        this.maxWait = maxWait;
    }

    /**
     * 获得字段 schema_info.between_eviction_runs 的值
     *
     * @return the value of schema_info.between_eviction_runs
     */
    public Long getBetweenEvictionRuns() {
        return betweenEvictionRuns;
    }

    /**
     * 设置字段 schema_info.between_eviction_runs 的值
     *
     * @param betweenEvictionRuns the value for schema_info.between_eviction_runs
     */
    public void setBetweenEvictionRuns(Long betweenEvictionRuns) {
        this.betweenEvictionRuns = betweenEvictionRuns;
    }

    /**
     * 获得字段 schema_info.min_evictable_idle 的值
     *
     * @return the value of schema_info.min_evictable_idle
     */
    public Long getMinEvictableIdle() {
        return minEvictableIdle;
    }

    /**
     * 设置字段 schema_info.min_evictable_idle 的值
     *
     * @param minEvictableIdle the value for schema_info.min_evictable_idle
     */
    public void setMinEvictableIdle(Long minEvictableIdle) {
        this.minEvictableIdle = minEvictableIdle;
    }

    /**
     * 获得字段 schema_info.validation_query 的值
     *
     * @return the value of schema_info.validation_query
     */
    public String getValidationQuery() {
        return validationQuery;
    }

    /**
     * 设置字段 schema_info.validation_query 的值
     *
     * @param validationQuery the value for schema_info.validation_query
     */
    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    /**
     * 获得字段 schema_info.test_while_idle 的值
     *
     * @return the value of schema_info.test_while_idle
     */
    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    /**
     * 设置字段 schema_info.test_while_idle 的值
     *
     * @param testWhileIdle the value for schema_info.test_while_idle
     */
    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    /**
     * 获得字段 schema_info.test_on_borrow 的值
     *
     * @return the value of schema_info.test_on_borrow
     */
    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    /**
     * 设置字段 schema_info.test_on_borrow 的值
     *
     * @param testOnBorrow the value for schema_info.test_on_borrow
     */
    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    /**
     * 获得字段 schema_info.test_on_return 的值
     *
     * @return the value of schema_info.test_on_return
     */
    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    /**
     * 设置字段 schema_info.test_on_return 的值
     *
     * @param testOnReturn the value for schema_info.test_on_return
     */
    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    /**
     * 获得字段 schema_info.pool_propared_stmt 的值
     *
     * @return the value of schema_info.pool_propared_stmt
     */
    public Boolean getPoolProparedStmt() {
        return poolProparedStmt;
    }

    /**
     * 设置字段 schema_info.pool_propared_stmt 的值
     *
     * @param poolProparedStmt the value for schema_info.pool_propared_stmt
     */
    public void setPoolProparedStmt(Boolean poolProparedStmt) {
        this.poolProparedStmt = poolProparedStmt;
    }

    /**
     * 获得字段 schema_info.max_pstmt_per_conn 的值
     *
     * @return the value of schema_info.max_pstmt_per_conn
     */
    public Integer getMaxPstmtPerConn() {
        return maxPstmtPerConn;
    }

    /**
     * 设置字段 schema_info.max_pstmt_per_conn 的值
     *
     * @param maxPstmtPerConn the value for schema_info.max_pstmt_per_conn
     */
    public void setMaxPstmtPerConn(Integer maxPstmtPerConn) {
        this.maxPstmtPerConn = maxPstmtPerConn;
    }
}