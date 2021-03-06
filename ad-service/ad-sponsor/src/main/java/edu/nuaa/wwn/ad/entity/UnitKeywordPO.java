package edu.nuaa.wwn.ad.entity;

import lombok.ToString;

@ToString
public class UnitKeywordPO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_keyword.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_keyword.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Integer unitId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_keyword.keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String keyword;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_keyword.id
     *
     * @return the value of ad_unit_keyword.id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_keyword.id
     *
     * @param id the value for ad_unit_keyword.id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_keyword.unit_id
     *
     * @return the value of ad_unit_keyword.unit_id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_keyword.unit_id
     *
     * @param unitId the value for ad_unit_keyword.unit_id
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_keyword.keyword
     *
     * @return the value of ad_unit_keyword.keyword
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_keyword.keyword
     *
     * @param keyword the value for ad_unit_keyword.keyword
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }
}