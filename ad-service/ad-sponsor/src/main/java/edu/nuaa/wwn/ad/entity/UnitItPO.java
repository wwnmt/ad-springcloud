package edu.nuaa.wwn.ad.entity;

public class UnitItPO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_it.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_it.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private Integer unitId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ad_unit_it.it_tag
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    private String itTag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_it.id
     *
     * @return the value of ad_unit_it.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_it.id
     *
     * @param id the value for ad_unit_it.id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_it.unit_id
     *
     * @return the value of ad_unit_it.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public Integer getUnitId() {
        return unitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_it.unit_id
     *
     * @param unitId the value for ad_unit_it.unit_id
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ad_unit_it.it_tag
     *
     * @return the value of ad_unit_it.it_tag
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public String getItTag() {
        return itTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ad_unit_it.it_tag
     *
     * @param itTag the value for ad_unit_it.it_tag
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    public void setItTag(String itTag) {
        this.itTag = itTag == null ? null : itTag.trim();
    }
}