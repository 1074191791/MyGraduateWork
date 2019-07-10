package cn.crms.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MechineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MechineExample() {
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

        public Criteria andEquipmentNameIsNull() {
            addCriterion("equipment_name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("equipment_name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("equipment_name =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("equipment_name <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("equipment_name >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipment_name >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("equipment_name <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("equipment_name <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("equipment_name like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("equipment_name not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("equipment_name in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("equipment_name not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("equipment_name between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("equipment_name not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andLogdateIsNull() {
            addCriterion("logdate is null");
            return (Criteria) this;
        }

        public Criteria andLogdateIsNotNull() {
            addCriterion("logdate is not null");
            return (Criteria) this;
        }

        public Criteria andLogdateEqualTo(Date value) {
            addCriterion("logdate =", value, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateNotEqualTo(Date value) {
            addCriterion("logdate <>", value, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateGreaterThan(Date value) {
            addCriterion("logdate >", value, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateGreaterThanOrEqualTo(Date value) {
            addCriterion("logdate >=", value, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateLessThan(Date value) {
            addCriterion("logdate <", value, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateLessThanOrEqualTo(Date value) {
            addCriterion("logdate <=", value, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateIn(List<Date> values) {
            addCriterion("logdate in", values, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateNotIn(List<Date> values) {
            addCriterion("logdate not in", values, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateBetween(Date value1, Date value2) {
            addCriterion("logdate between", value1, value2, "logdate");
            return (Criteria) this;
        }

        public Criteria andLogdateNotBetween(Date value1, Date value2) {
            addCriterion("logdate not between", value1, value2, "logdate");
            return (Criteria) this;
        }

        public Criteria andComputerRoomIsNull() {
            addCriterion("computer_room is null");
            return (Criteria) this;
        }

        public Criteria andComputerRoomIsNotNull() {
            addCriterion("computer_room is not null");
            return (Criteria) this;
        }

        public Criteria andComputerRoomEqualTo(String value) {
            addCriterion("computer_room =", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomNotEqualTo(String value) {
            addCriterion("computer_room <>", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomGreaterThan(String value) {
            addCriterion("computer_room >", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomGreaterThanOrEqualTo(String value) {
            addCriterion("computer_room >=", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomLessThan(String value) {
            addCriterion("computer_room <", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomLessThanOrEqualTo(String value) {
            addCriterion("computer_room <=", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomLike(String value) {
            addCriterion("computer_room like", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomNotLike(String value) {
            addCriterion("computer_room not like", value, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomIn(List<String> values) {
            addCriterion("computer_room in", values, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomNotIn(List<String> values) {
            addCriterion("computer_room not in", values, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomBetween(String value1, String value2) {
            addCriterion("computer_room between", value1, value2, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andComputerRoomNotBetween(String value1, String value2) {
            addCriterion("computer_room not between", value1, value2, "computerRoom");
            return (Criteria) this;
        }

        public Criteria andIsNormalIsNull() {
            addCriterion("is_normal is null");
            return (Criteria) this;
        }

        public Criteria andIsNormalIsNotNull() {
            addCriterion("is_normal is not null");
            return (Criteria) this;
        }

        public Criteria andIsNormalEqualTo(Boolean value) {
            addCriterion("is_normal =", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotEqualTo(Boolean value) {
            addCriterion("is_normal <>", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalGreaterThan(Boolean value) {
            addCriterion("is_normal >", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_normal >=", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalLessThan(Boolean value) {
            addCriterion("is_normal <", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalLessThanOrEqualTo(Boolean value) {
            addCriterion("is_normal <=", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalIn(List<Boolean> values) {
            addCriterion("is_normal in", values, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotIn(List<Boolean> values) {
            addCriterion("is_normal not in", values, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalBetween(Boolean value1, Boolean value2) {
            addCriterion("is_normal between", value1, value2, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_normal not between", value1, value2, "isNormal");
            return (Criteria) this;
        }

        public Criteria andRepairManIsNull() {
            addCriterion("repair_man is null");
            return (Criteria) this;
        }

        public Criteria andRepairManIsNotNull() {
            addCriterion("repair_man is not null");
            return (Criteria) this;
        }

        public Criteria andRepairManEqualTo(String value) {
            addCriterion("repair_man =", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotEqualTo(String value) {
            addCriterion("repair_man <>", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManGreaterThan(String value) {
            addCriterion("repair_man >", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManGreaterThanOrEqualTo(String value) {
            addCriterion("repair_man >=", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManLessThan(String value) {
            addCriterion("repair_man <", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManLessThanOrEqualTo(String value) {
            addCriterion("repair_man <=", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManLike(String value) {
            addCriterion("repair_man like", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotLike(String value) {
            addCriterion("repair_man not like", value, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManIn(List<String> values) {
            addCriterion("repair_man in", values, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotIn(List<String> values) {
            addCriterion("repair_man not in", values, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManBetween(String value1, String value2) {
            addCriterion("repair_man between", value1, value2, "repairMan");
            return (Criteria) this;
        }

        public Criteria andRepairManNotBetween(String value1, String value2) {
            addCriterion("repair_man not between", value1, value2, "repairMan");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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