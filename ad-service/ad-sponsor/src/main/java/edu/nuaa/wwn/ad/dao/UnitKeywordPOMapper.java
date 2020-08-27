package edu.nuaa.wwn.ad.dao;

import edu.nuaa.wwn.ad.entity.UnitKeywordPO;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitKeywordPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_unit_keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_unit_keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    long insert(UnitKeywordPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_unit_keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    long insertSelective(UnitKeywordPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_unit_keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    UnitKeywordPO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_unit_keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int updateByPrimaryKeySelective(UnitKeywordPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_unit_keyword
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int updateByPrimaryKey(UnitKeywordPO record);
}