package cn.sicau.count.dao;

import cn.sicau.count.domain.Solo;

import java.util.List;

public interface SoloMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Solo record);

    int insertSelective(Solo record);

    Solo selectByPrimaryKey(Integer id);
    Solo selectByUserNummberPro(Solo solo);
    List<Solo> getAllSoloScore();
    int updateByPrimaryKeySelective(Solo record);

    int updateByPrimaryKey(Solo record);
}