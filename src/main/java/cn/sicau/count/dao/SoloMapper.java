package cn.sicau.count.dao;

import cn.sicau.count.domain.Solo;

public interface SoloMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Solo record);

    int insertSelective(Solo record);

    Solo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Solo record);

    int updateByPrimaryKey(Solo record);
}