package com.dao;

import com.entity.Insuranceexchange;
import com.entity.InsuranceexchangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InsuranceexchangeMapper {
    long countByExample(InsuranceexchangeExample example);

    int deleteByExample(InsuranceexchangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Insuranceexchange record);

    int insertSelective(Insuranceexchange record);

    List<Insuranceexchange> selectByExample(InsuranceexchangeExample example);

    Insuranceexchange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Insuranceexchange record, @Param("example") InsuranceexchangeExample example);

    int updateByExample(@Param("record") Insuranceexchange record, @Param("example") InsuranceexchangeExample example);

    int updateByPrimaryKeySelective(Insuranceexchange record);

    int updateByPrimaryKey(Insuranceexchange record);
}