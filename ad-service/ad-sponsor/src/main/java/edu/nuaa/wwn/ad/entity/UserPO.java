package edu.nuaa.wwn.ad.entity;

import java.util.Date;

public class UserPO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user.username
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user.token
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user.user_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Byte userStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user.id
     *
     * @return the value of ad_user.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user.id
     *
     * @param id the value for ad_user.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user.username
     *
     * @return the value of ad_user.username
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user.username
     *
     * @param username the value for ad_user.username
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user.token
     *
     * @return the value of ad_user.token
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user.token
     *
     * @param token the value for ad_user.token
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user.user_status
     *
     * @return the value of ad_user.user_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Byte getUserStatus() {
        return userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user.user_status
     *
     * @param userStatus the value for ad_user.user_status
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user.create_time
     *
     * @return the value of ad_user.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user.create_time
     *
     * @param createTime the value for ad_user.create_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user.update_time
     *
     * @return the value of ad_user.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user.update_time
     *
     * @param updateTime the value for ad_user.update_time
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}