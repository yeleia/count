package cn.sicau.count.dao;

import cn.sicau.count.domain.FinalSolo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FinalSoloMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(FinalSolo record);
    int insertSelective(FinalSolo record);
    FinalSolo selectByPrimaryKey(Integer id);
    List<FinalSolo> getByParameter(FinalSolo solo);
    List<FinalSolo> getByAse(FinalSolo solo);
    List<FinalSolo> getAll(Map<String,Object> map);
    int updateByPrimaryKeySelective(FinalSolo record);
    int updateByPrimaryKey(FinalSolo record);
    Integer count();
    FinalSolo getByNumberPro(FinalSolo finalSolo);
    //根据项目查询并排序
    List<FinalSolo> getByPro(FinalSolo finalSolo);
    List<FinalSolo> getByProAsc(FinalSolo finalSolo);
    //根据id修改finalScore
    Integer updateFinalScoreById(FinalSolo finalSolo);
    //根据学院查询
    List<FinalSolo> getByClasses(String classes);
    //查询所有
    List<FinalSolo> getAlls();
    //根据学号查询
    List<FinalSolo> getByStuNumber(String stunumber);
    //根据项目和性别查询
    List<FinalSolo> getByProSex(FinalSolo finalSolo);
    List<FinalSolo> getByProSexAsc(FinalSolo finalSolo);
}