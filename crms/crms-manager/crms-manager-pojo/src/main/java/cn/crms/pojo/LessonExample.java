package cn.crms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LessonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LessonExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andLessonNameIsNull() {
            addCriterion("lesson_name is null");
            return (Criteria) this;
        }

        public Criteria andLessonNameIsNotNull() {
            addCriterion("lesson_name is not null");
            return (Criteria) this;
        }

        public Criteria andLessonNameEqualTo(String value) {
            addCriterion("lesson_name =", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotEqualTo(String value) {
            addCriterion("lesson_name <>", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameGreaterThan(String value) {
            addCriterion("lesson_name >", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameGreaterThanOrEqualTo(String value) {
            addCriterion("lesson_name >=", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameLessThan(String value) {
            addCriterion("lesson_name <", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameLessThanOrEqualTo(String value) {
            addCriterion("lesson_name <=", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameLike(String value) {
            addCriterion("lesson_name like", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotLike(String value) {
            addCriterion("lesson_name not like", value, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameIn(List<String> values) {
            addCriterion("lesson_name in", values, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotIn(List<String> values) {
            addCriterion("lesson_name not in", values, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameBetween(String value1, String value2) {
            addCriterion("lesson_name between", value1, value2, "lessonName");
            return (Criteria) this;
        }

        public Criteria andLessonNameNotBetween(String value1, String value2) {
            addCriterion("lesson_name not between", value1, value2, "lessonName");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("add_date is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("add_date is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(Date value) {
            addCriterion("add_date =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(Date value) {
            addCriterion("add_date <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(Date value) {
            addCriterion("add_date >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(Date value) {
            addCriterion("add_date >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(Date value) {
            addCriterion("add_date <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(Date value) {
            addCriterion("add_date <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<Date> values) {
            addCriterion("add_date in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<Date> values) {
            addCriterion("add_date not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(Date value1, Date value2) {
            addCriterion("add_date between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(Date value1, Date value2) {
            addCriterion("add_date not between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andLessonTimeIsNull() {
            addCriterion("lesson_time is null");
            return (Criteria) this;
        }

        public Criteria andLessonTimeIsNotNull() {
            addCriterion("lesson_time is not null");
            return (Criteria) this;
        }

        public Criteria andLessonTimeEqualTo(Double value) {
            addCriterion("lesson_time =", value, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeNotEqualTo(Double value) {
            addCriterion("lesson_time <>", value, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeGreaterThan(Double value) {
            addCriterion("lesson_time >", value, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeGreaterThanOrEqualTo(Double value) {
            addCriterion("lesson_time >=", value, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeLessThan(Double value) {
            addCriterion("lesson_time <", value, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeLessThanOrEqualTo(Double value) {
            addCriterion("lesson_time <=", value, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeIn(List<Double> values) {
            addCriterion("lesson_time in", values, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeNotIn(List<Double> values) {
            addCriterion("lesson_time not in", values, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeBetween(Double value1, Double value2) {
            addCriterion("lesson_time between", value1, value2, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonTimeNotBetween(Double value1, Double value2) {
            addCriterion("lesson_time not between", value1, value2, "lessonTime");
            return (Criteria) this;
        }

        public Criteria andLessonScoreIsNull() {
            addCriterion("lesson_score is null");
            return (Criteria) this;
        }

        public Criteria andLessonScoreIsNotNull() {
            addCriterion("lesson_score is not null");
            return (Criteria) this;
        }

        public Criteria andLessonScoreEqualTo(Double value) {
            addCriterion("lesson_score =", value, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreNotEqualTo(Double value) {
            addCriterion("lesson_score <>", value, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreGreaterThan(Double value) {
            addCriterion("lesson_score >", value, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("lesson_score >=", value, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreLessThan(Double value) {
            addCriterion("lesson_score <", value, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreLessThanOrEqualTo(Double value) {
            addCriterion("lesson_score <=", value, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreIn(List<Double> values) {
            addCriterion("lesson_score in", values, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreNotIn(List<Double> values) {
            addCriterion("lesson_score not in", values, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreBetween(Double value1, Double value2) {
            addCriterion("lesson_score between", value1, value2, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonScoreNotBetween(Double value1, Double value2) {
            addCriterion("lesson_score not between", value1, value2, "lessonScore");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkIsNull() {
            addCriterion("lesson_remark is null");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkIsNotNull() {
            addCriterion("lesson_remark is not null");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkEqualTo(String value) {
            addCriterion("lesson_remark =", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkNotEqualTo(String value) {
            addCriterion("lesson_remark <>", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkGreaterThan(String value) {
            addCriterion("lesson_remark >", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("lesson_remark >=", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkLessThan(String value) {
            addCriterion("lesson_remark <", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkLessThanOrEqualTo(String value) {
            addCriterion("lesson_remark <=", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkLike(String value) {
            addCriterion("lesson_remark like", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkNotLike(String value) {
            addCriterion("lesson_remark not like", value, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkIn(List<String> values) {
            addCriterion("lesson_remark in", values, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkNotIn(List<String> values) {
            addCriterion("lesson_remark not in", values, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkBetween(String value1, String value2) {
            addCriterion("lesson_remark between", value1, value2, "lessonRemark");
            return (Criteria) this;
        }

        public Criteria andLessonRemarkNotBetween(String value1, String value2) {
            addCriterion("lesson_remark not between", value1, value2, "lessonRemark");
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