package edu.nuaa.wwn.ad.entity;

import java.util.Date;

public class UnitPO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.plan_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Long planId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.unit_name
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String unitName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.unit_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Byte unitStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.position_type
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Byte positionType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.budget
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Long budget;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.id
     *
     * @return the value of ad_unit.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.id
     *
     * @param id the value for ad_unit.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.plan_id
     *
     * @return the value of ad_unit.plan_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Long getPlanId() {
        return planId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.plan_id
     *
     * @param planId the value for ad_unit.plan_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.unit_name
     *
     * @return the value of ad_unit.unit_name
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.unit_name
     *
     * @param unitName the value for ad_unit.unit_name
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.unit_status
     *
     * @return the value of ad_unit.unit_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Byte getUnitStatus() {
        return unitStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.unit_status
     *
     * @param unitStatus the value for ad_unit.unit_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUnitStatus(Byte unitStatus) {
        this.unitStatus = unitStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.position_type
     *
     * @return the value of ad_unit.position_type
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Byte getPositionType() {
        return positionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.position_type
     *
     * @param positionType the value for ad_unit.position_type
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setPositionType(Byte positionType) {
        this.positionType = positionType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.budget
     *
     * @return the value of ad_unit.budget
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Long getBudget() {
        return budget;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.budget
     *
     * @param budget the value for ad_unit.budget
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setBudget(Long budget) {
        this.budget = budget;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.create_time
     *
     * @return the value of ad_unit.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.create_time
     *
     * @param createTime the value for ad_unit.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit.update_time
     *
     * @return the value of ad_unit.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit.update_time
     *
     * @param updateTime the value for ad_unit.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}