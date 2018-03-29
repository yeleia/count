package cn.sicau.count.dao;

import cn.sicau.count.domain.TwoLevel;

public interface TwoLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TwoLevel record);

    int insertSelective(TwoLevel record);

    TwoLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TwoLevel record);

    int updateByPrimaryKey(TwoLevel record);
}