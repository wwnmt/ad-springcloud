package edu.nuaa.wwn.ad.dao;

import edu.nuaa.wwn.ad.entity.PlanPO;

public interface PlanPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_plan
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_plan
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int insert(PlanPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_plan
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int insertSelective(PlanPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_plan
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    PlanPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_plan
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int updateByPrimaryKeySelective(PlanPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_plan
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int updateByPrimaryKey(PlanPO record);
}