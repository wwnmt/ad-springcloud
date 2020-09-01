package edu.nuaa.wwn.ad.entity;

import lombok.ToString;

import java.util.Date;

@ToString
public class PlanPO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.user_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.plan_name
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String planName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.plan_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Byte planStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.start_date
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date startDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.end_date
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date endDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_plan.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.id
     *
     * @return the value of ad_plan.id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.id
     *
     * @param id the value for ad_plan.id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.user_id
     *
     * @return the value of ad_plan.user_id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.user_id
     *
     * @param userId the value for ad_plan.user_id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.plan_name
     *
     * @return the value of ad_plan.plan_name
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.plan_name
     *
     * @param planName the value for ad_plan.plan_name
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setPlanName(String planName) {
        this.planName = planName == null ? null : planName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.plan_status
     *
     * @return the value of ad_plan.plan_status
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Byte getPlanStatus() {
        return planStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.plan_status
     *
     * @param planStatus the value for ad_plan.plan_status
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setPlanStatus(Byte planStatus) {
        this.planStatus = planStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.start_date
     *
     * @return the value of ad_plan.start_date
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.start_date
     *
     * @param startDate the value for ad_plan.start_date
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.end_date
     *
     * @return the value of ad_plan.end_date
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.end_date
     *
     * @param endDate the value for ad_plan.end_date
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.create_time
     *
     * @return the value of ad_plan.create_time
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.create_time
     *
     * @param createTime the value for ad_plan.create_time
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_plan.update_time
     *
     * @return the value of ad_plan.update_time
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_plan.update_time
     *
     * @param updateTime the value for ad_plan.update_time
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}