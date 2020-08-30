package edu.nuaa.wwn.ad.dao;

import edu.nuaa.wwn.ad.entity.CreativeUnitPO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreativeUnitPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creative_unit
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creative_unit
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    long insert(CreativeUnitPO record);

    List<CreativeUnitPO> findAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creative_unit
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    long insertSelective(CreativeUnitPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creative_unit
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    CreativeUnitPO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creative_unit
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int updateByPrimaryKeySelective(CreativeUnitPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table creative_unit
     *
     * @mbg.generated Wed Aug 26 17:51:18 CST 2020
     */
    int updateByPrimaryKey(CreativeUnitPO record);
}