package edu.nuaa.wwn.ad.entity;

import java.util.Date;

public class UserPO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.user_id
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.user_name
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.user_pwd
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private String userPwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.user_sex
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private Integer userSex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.email
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.user_phone
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private String userPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.begin_time
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private Date beginTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_user_t.update_time
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.user_id
     *
     * @return the value of ad_user_t.user_id
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.user_id
     *
     * @param userId the value for ad_user_t.user_id
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.user_name
     *
     * @return the value of ad_user_t.user_name
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.user_name
     *
     * @param userName the value for ad_user_t.user_name
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.user_pwd
     *
     * @return the value of ad_user_t.user_pwd
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.user_pwd
     *
     * @param userPwd the value for ad_user_t.user_pwd
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.user_sex
     *
     * @return the value of ad_user_t.user_sex
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public Integer getUserSex() {
        return userSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.user_sex
     *
     * @param userSex the value for ad_user_t.user_sex
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.email
     *
     * @return the value of ad_user_t.email
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.email
     *
     * @param email the value for ad_user_t.email
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.user_phone
     *
     * @return the value of ad_user_t.user_phone
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.user_phone
     *
     * @param userPhone the value for ad_user_t.user_phone
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.begin_time
     *
     * @return the value of ad_user_t.begin_time
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.begin_time
     *
     * @param beginTime the value for ad_user_t.begin_time
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_user_t.update_time
     *
     * @return the value of ad_user_t.update_time
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_user_t.update_time
     *
     * @param updateTime the value for ad_user_t.update_time
     *
     * @mbg.generated Wed Sep 02 17:28:51 CST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}