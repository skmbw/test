package com.vteba.schema.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 分区表，应用信息配置（app_info）的复杂条件查询类。
 * 由代码工具自动生成。
 * @date 2014-10-31 13:58:51
 */
public class AppInfoBean {
    /**
     * 逻辑or语句
     */
    protected List<Criteria> oredCriteria;

    /**
     * 创建应用信息配置的复杂条件查询实例
     */
    public AppInfoBean() {
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
     * 应用信息配置，对应数据库表 app_info
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

        public Criteria andAppDescIsNull() {
            addCriterion("app_desc is null");
            return (Criteria) this;
        }

        public Criteria andAppDescIsNotNull() {
            addCriterion("app_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAppDescEqualTo(String value) {
            addCriterion("app_desc =", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotEqualTo(String value) {
            addCriterion("app_desc <>", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescGreaterThan(String value) {
            addCriterion("app_desc >", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescGreaterThanOrEqualTo(String value) {
            addCriterion("app_desc >=", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescLessThan(String value) {
            addCriterion("app_desc <", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescLessThanOrEqualTo(String value) {
            addCriterion("app_desc <=", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescLike(String value) {
            addCriterion("app_desc like", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotLike(String value) {
            addCriterion("app_desc not like", value, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescIn(List<String> values) {
            addCriterion("app_desc in", values, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotIn(List<String> values) {
            addCriterion("app_desc not in", values, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescBetween(String value1, String value2) {
            addCriterion("app_desc between", value1, value2, "appDesc");
            return (Criteria) this;
        }

        public Criteria andAppDescNotBetween(String value1, String value2) {
            addCriterion("app_desc not between", value1, value2, "appDesc");
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

        public Criteria andShardsIsNull() {
            addCriterion("shards is null");
            return (Criteria) this;
        }

        public Criteria andShardsIsNotNull() {
            addCriterion("shards is not null");
            return (Criteria) this;
        }

        public Criteria andShardsEqualTo(Boolean value) {
            addCriterion("shards =", value, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsNotEqualTo(Boolean value) {
            addCriterion("shards <>", value, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsGreaterThan(Boolean value) {
            addCriterion("shards >", value, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("shards >=", value, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsLessThan(Boolean value) {
            addCriterion("shards <", value, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsLessThanOrEqualTo(Boolean value) {
            addCriterion("shards <=", value, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsIn(List<Boolean> values) {
            addCriterion("shards in", values, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsNotIn(List<Boolean> values) {
            addCriterion("shards not in", values, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsBetween(Boolean value1, Boolean value2) {
            addCriterion("shards between", value1, value2, "shards");
            return (Criteria) this;
        }

        public Criteria andShardsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("shards not between", value1, value2, "shards");
            return (Criteria) this;
        }
    }

    /**
     * 该类对应数据库表 app_info
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 应用信息配置，对应数据库表 app_info
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