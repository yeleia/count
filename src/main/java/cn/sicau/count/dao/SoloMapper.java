package cn.sicau.count.dao;

import cn.sicau.count.domain.Solo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SoloMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Solo record);

    int insertSelective(Solo record);

    Solo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Solo record);

    int updateByPrimaryKey(Solo record);
    List<Solo> getAllBoyOneHundredScore();
}