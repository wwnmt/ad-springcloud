package edu.nuaa.wwn.ad.entity;

public class UnitDistrictPO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_district.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_district.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Integer unitId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_district.province
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String province;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_district.city
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String city;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_district.id
     *
     * @return the value of ad_unit_district.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_district.id
     *
     * @param id the value for ad_unit_district.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_district.unit_id
     *
     * @return the value of ad_unit_district.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_district.unit_id
     *
     * @param unitId the value for ad_unit_district.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_district.province
     *
     * @return the value of ad_unit_district.province
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_district.province
     *
     * @param province the value for ad_unit_district.province
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_district.city
     *
     * @return the value of ad_unit_district.city
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_district.city
     *
     * @param city the value for ad_unit_district.city
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
}