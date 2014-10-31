package com.vteba.schema.model;

public class SchemaInfo {
    /**
     * schema主键。schema_info.schema_id
     */
    private Long schemaId;

    /**
     * schema名字，唯一的。schema_info.schema_name
     */
    private String schemaName;

    /**
     * schema描述。schema_info.schema_desc
     */
    private String schemaDesc;

    /**
     * 数据库类型。schema_info.db_type
     */
    private String dbType;

    /**
     * ip地址。schema_info.ip
     */
    private String ip;

    /**
     * 该schema所在数据库的端口。schema_info.port
     */
    private Integer port;

    /**
     * jdbc连接url。schema_info.jdbc_url
     */
    private String jdbcUrl;

    /**
     * 数据库用户密码。schema_info.passwords
     */
    private String passwords;

    /**
     * 关联app_info的主键。schema_info.app_id
     */
    private Long appId;

    /**
     * 应用的名字，和app_id同时更新。schema_info.app_name
     */
    private String appName;

    /**
     * 连接池初始化大小。schema_info.initial_size
     */
    private Integer initialSize;

    /**
     * 连接池最小空闲数。schema_info.min_idle
     */
    private Integer minIdle;

    /**
     * 连接池最大连接数。schema_info.max_active
     */
    private Integer maxActive;

    /**
     * 获取连接的最大等待时间，单位毫秒。schema_info.max_wait
     */
    private Long maxWait;

    /**
     * 间隔多久才进行一次检测，检测需要关闭的空闲连接，单位毫秒。schema_info.between_eviction_runs
     */
    private Long betweenEvictionRuns;

    /**
     * 一个连接在池中最小生存的时间，单位是毫秒。schema_info.min_evictable_idle
     */
    private Long minEvictableIdle;

    /**
     * 验证连接的sql。schema_info.validation_query
     */
    private String validationQuery;

    /**
     * 空闲时清理连接。schema_info.test_while_idle
     */
    private Boolean testWhileIdle;

    /**
     * 是否验证获取的连接。schema_info.test_on_borrow
     */
    private Boolean testOnBorrow;

    /**
     * 是否验证归还的连接。schema_info.test_on_return
     */
    private Boolean testOnReturn;

    /**
     * 是否池化预处理语句。schema_info.pool_propared_stmt
     */
    private Boolean poolProparedStmt;

    /**
     * 每个连接的最大预处理语句数。schema_info.max_pstmt_per_conn
     */
    private Integer maxPstmtPerConn;

    /**
     * 对等库的id。schema_info.peer_id
     */
    private Long peerId;

    /**
     * 对等库的名字。schema_info.peer_name
     */
    private String peerName;

    /**
     * 该数据库的权重。schema_info.weight
     */
    private Integer weight;

    /**
     * 读权重。schema_info.read_weight
     */
    private Integer readWeight;

    /**
     * 写权重。schema_info.write_weight
     */
    private Integer writeWeight;

    /**
     * 是否应用启动时加载。schema_info.startup
     */
    private Boolean startup;

    /**
     * 该schema的状态，1使用中，2可用，3不可用。schema_info.state
     */
    private Integer state;

    /**
     * 获得属性，schema主键(schema_info.schema_id)的值
     *
     * @return 属性schema主键的值
     */
    public Long getSchemaId() {
        return schemaId;
    }

    /**
     * 设置属性，schema主键(schema_info.schema_id)的值
     *
     * @param schemaId 属性schema主键的值
     */
    public void setSchemaId(Long schemaId) {
        this.schemaId = schemaId;
    }

    /**
     * 获得属性，schema名字，唯一的(schema_info.schema_name)的值
     *
     * @return 属性schema名字，唯一的的值
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * 设置属性，schema名字，唯一的(schema_info.schema_name)的值
     *
     * @param schemaName 属性schema名字，唯一的的值
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * 获得属性，schema描述(schema_info.schema_desc)的值
     *
     * @return 属性schema描述的值
     */
    public String getSchemaDesc() {
        return schemaDesc;
    }

    /**
     * 设置属性，schema描述(schema_info.schema_desc)的值
     *
     * @param schemaDesc 属性schema描述的值
     */
    public void setSchemaDesc(String schemaDesc) {
        this.schemaDesc = schemaDesc;
    }

    /**
     * 获得属性，数据库类型(schema_info.db_type)的值
     *
     * @return 属性数据库类型的值
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * 设置属性，数据库类型(schema_info.db_type)的值
     *
     * @param dbType 属性数据库类型的值
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * 获得属性，ip地址(schema_info.ip)的值
     *
     * @return 属性ip地址的值
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置属性，ip地址(schema_info.ip)的值
     *
     * @param ip 属性ip地址的值
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获得属性，该schema所在数据库的端口(schema_info.port)的值
     *
     * @return 属性该schema所在数据库的端口的值
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 设置属性，该schema所在数据库的端口(schema_info.port)的值
     *
     * @param port 属性该schema所在数据库的端口的值
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 获得属性，jdbc连接url(schema_info.jdbc_url)的值
     *
     * @return 属性jdbc连接url的值
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * 设置属性，jdbc连接url(schema_info.jdbc_url)的值
     *
     * @param jdbcUrl 属性jdbc连接url的值
     */
    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * 获得属性，数据库用户密码(schema_info.passwords)的值
     *
     * @return 属性数据库用户密码的值
     */
    public String getPasswords() {
        return passwords;
    }

    /**
     * 设置属性，数据库用户密码(schema_info.passwords)的值
     *
     * @param passwords 属性数据库用户密码的值
     */
    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    /**
     * 获得属性，关联app_info的主键(schema_info.app_id)的值
     *
     * @return 属性关联app_info的主键的值
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置属性，关联app_info的主键(schema_info.app_id)的值
     *
     * @param appId 属性关联app_info的主键的值
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获得属性，应用的名字，和app_id同时更新(schema_info.app_name)的值
     *
     * @return 属性应用的名字，和app_id同时更新的值
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置属性，应用的名字，和app_id同时更新(schema_info.app_name)的值
     *
     * @param appName 属性应用的名字，和app_id同时更新的值
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获得属性，连接池初始化大小(schema_info.initial_size)的值
     *
     * @return 属性连接池初始化大小的值
     */
    public Integer getInitialSize() {
        return initialSize;
    }

    /**
     * 设置属性，连接池初始化大小(schema_info.initial_size)的值
     *
     * @param initialSize 属性连接池初始化大小的值
     */
    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    /**
     * 获得属性，连接池最小空闲数(schema_info.min_idle)的值
     *
     * @return 属性连接池最小空闲数的值
     */
    public Integer getMinIdle() {
        return minIdle;
    }

    /**
     * 设置属性，连接池最小空闲数(schema_info.min_idle)的值
     *
     * @param minIdle 属性连接池最小空闲数的值
     */
    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    /**
     * 获得属性，连接池最大连接数(schema_info.max_active)的值
     *
     * @return 属性连接池最大连接数的值
     */
    public Integer getMaxActive() {
        return maxActive;
    }

    /**
     * 设置属性，连接池最大连接数(schema_info.max_active)的值
     *
     * @param maxActive 属性连接池最大连接数的值
     */
    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    /**
     * 获得属性，获取连接的最大等待时间，单位毫秒(schema_info.max_wait)的值
     *
     * @return 属性获取连接的最大等待时间，单位毫秒的值
     */
    public Long getMaxWait() {
        return maxWait;
    }

    /**
     * 设置属性，获取连接的最大等待时间，单位毫秒(schema_info.max_wait)的值
     *
     * @param maxWait 属性获取连接的最大等待时间，单位毫秒的值
     */
    public void setMaxWait(Long maxWait) {
        this.maxWait = maxWait;
    }

    /**
     * 获得属性，间隔多久才进行一次检测，检测需要关闭的空闲连接，单位毫秒(schema_info.between_eviction_runs)的值
     *
     * @return 属性间隔多久才进行一次检测，检测需要关闭的空闲连接，单位毫秒的值
     */
    public Long getBetweenEvictionRuns() {
        return betweenEvictionRuns;
    }

    /**
     * 设置属性，间隔多久才进行一次检测，检测需要关闭的空闲连接，单位毫秒(schema_info.between_eviction_runs)的值
     *
     * @param betweenEvictionRuns 属性间隔多久才进行一次检测，检测需要关闭的空闲连接，单位毫秒的值
     */
    public void setBetweenEvictionRuns(Long betweenEvictionRuns) {
        this.betweenEvictionRuns = betweenEvictionRuns;
    }

    /**
     * 获得属性，一个连接在池中最小生存的时间，单位是毫秒(schema_info.min_evictable_idle)的值
     *
     * @return 属性一个连接在池中最小生存的时间，单位是毫秒的值
     */
    public Long getMinEvictableIdle() {
        return minEvictableIdle;
    }

    /**
     * 设置属性，一个连接在池中最小生存的时间，单位是毫秒(schema_info.min_evictable_idle)的值
     *
     * @param minEvictableIdle 属性一个连接在池中最小生存的时间，单位是毫秒的值
     */
    public void setMinEvictableIdle(Long minEvictableIdle) {
        this.minEvictableIdle = minEvictableIdle;
    }

    /**
     * 获得属性，验证连接的sql(schema_info.validation_query)的值
     *
     * @return 属性验证连接的sql的值
     */
    public String getValidationQuery() {
        return validationQuery;
    }

    /**
     * 设置属性，验证连接的sql(schema_info.validation_query)的值
     *
     * @param validationQuery 属性验证连接的sql的值
     */
    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    /**
     * 获得属性，空闲时清理连接(schema_info.test_while_idle)的值
     *
     * @return 属性空闲时清理连接的值
     */
    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    /**
     * 设置属性，空闲时清理连接(schema_info.test_while_idle)的值
     *
     * @param testWhileIdle 属性空闲时清理连接的值
     */
    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    /**
     * 获得属性，是否验证获取的连接(schema_info.test_on_borrow)的值
     *
     * @return 属性是否验证获取的连接的值
     */
    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    /**
     * 设置属性，是否验证获取的连接(schema_info.test_on_borrow)的值
     *
     * @param testOnBorrow 属性是否验证获取的连接的值
     */
    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    /**
     * 获得属性，是否验证归还的连接(schema_info.test_on_return)的值
     *
     * @return 属性是否验证归还的连接的值
     */
    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    /**
     * 设置属性，是否验证归还的连接(schema_info.test_on_return)的值
     *
     * @param testOnReturn 属性是否验证归还的连接的值
     */
    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    /**
     * 获得属性，是否池化预处理语句(schema_info.pool_propared_stmt)的值
     *
     * @return 属性是否池化预处理语句的值
     */
    public Boolean getPoolProparedStmt() {
        return poolProparedStmt;
    }

    /**
     * 设置属性，是否池化预处理语句(schema_info.pool_propared_stmt)的值
     *
     * @param poolProparedStmt 属性是否池化预处理语句的值
     */
    public void setPoolProparedStmt(Boolean poolProparedStmt) {
        this.poolProparedStmt = poolProparedStmt;
    }

    /**
     * 获得属性，每个连接的最大预处理语句数(schema_info.max_pstmt_per_conn)的值
     *
     * @return 属性每个连接的最大预处理语句数的值
     */
    public Integer getMaxPstmtPerConn() {
        return maxPstmtPerConn;
    }

    /**
     * 设置属性，每个连接的最大预处理语句数(schema_info.max_pstmt_per_conn)的值
     *
     * @param maxPstmtPerConn 属性每个连接的最大预处理语句数的值
     */
    public void setMaxPstmtPerConn(Integer maxPstmtPerConn) {
        this.maxPstmtPerConn = maxPstmtPerConn;
    }

    /**
     * 获得属性，对等库的id(schema_info.peer_id)的值
     *
     * @return 属性对等库的id的值
     */
    public Long getPeerId() {
        return peerId;
    }

    /**
     * 设置属性，对等库的id(schema_info.peer_id)的值
     *
     * @param peerId 属性对等库的id的值
     */
    public void setPeerId(Long peerId) {
        this.peerId = peerId;
    }

    /**
     * 获得属性，对等库的名字(schema_info.peer_name)的值
     *
     * @return 属性对等库的名字的值
     */
    public String getPeerName() {
        return peerName;
    }

    /**
     * 设置属性，对等库的名字(schema_info.peer_name)的值
     *
     * @param peerName 属性对等库的名字的值
     */
    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    /**
     * 获得属性，该数据库的权重(schema_info.weight)的值
     *
     * @return 属性该数据库的权重的值
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置属性，该数据库的权重(schema_info.weight)的值
     *
     * @param weight 属性该数据库的权重的值
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获得属性，读权重(schema_info.read_weight)的值
     *
     * @return 属性读权重的值
     */
    public Integer getReadWeight() {
        return readWeight;
    }

    /**
     * 设置属性，读权重(schema_info.read_weight)的值
     *
     * @param readWeight 属性读权重的值
     */
    public void setReadWeight(Integer readWeight) {
        this.readWeight = readWeight;
    }

    /**
     * 获得属性，写权重(schema_info.write_weight)的值
     *
     * @return 属性写权重的值
     */
    public Integer getWriteWeight() {
        return writeWeight;
    }

    /**
     * 设置属性，写权重(schema_info.write_weight)的值
     *
     * @param writeWeight 属性写权重的值
     */
    public void setWriteWeight(Integer writeWeight) {
        this.writeWeight = writeWeight;
    }

    /**
     * 获得属性，是否应用启动时加载(schema_info.startup)的值
     *
     * @return 属性是否应用启动时加载的值
     */
    public Boolean getStartup() {
        return startup;
    }

    /**
     * 设置属性，是否应用启动时加载(schema_info.startup)的值
     *
     * @param startup 属性是否应用启动时加载的值
     */
    public void setStartup(Boolean startup) {
        this.startup = startup;
    }

    /**
     * 获得属性，该schema的状态，1使用中，2可用，3不可用(schema_info.state)的值
     *
     * @return 属性该schema的状态，1使用中，2可用，3不可用的值
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置属性，该schema的状态，1使用中，2可用，3不可用(schema_info.state)的值
     *
     * @param state 属性该schema的状态，1使用中，2可用，3不可用的值
     */
    public void setState(Integer state) {
        this.state = state;
    }
}