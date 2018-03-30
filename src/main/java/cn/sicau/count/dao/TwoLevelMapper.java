package cn.sicau.count.dao;

import cn.sicau.count.domain.TwoLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TwoLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TwoLevel record);

    int insertSelective(TwoLevel record);

    TwoLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TwoLevel record);

    int updateByPrimaryKey(TwoLevel record);
    List<TwoLevel> getAll();
}