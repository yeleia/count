package cn.sicau.count.dao;

import cn.sicau.count.domain.FinalSolo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FinalSoloMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FinalSolo record);

    int insertSelective(FinalSolo record);

    FinalSolo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinalSolo record);

    int updateByPrimaryKey(FinalSolo record);
}