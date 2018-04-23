package cn.sicau.count.dao;

import cn.sicau.count.domain.Solo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SoloMapper {
    int deleteByPrimaryKey(Integer id);
    Integer insert(Solo record);
    int insertSelective(Solo record);
    Solo selectByPrimaryKey(Solo solo);
    Solo selectByUserNummberPro(Solo solo);
    List<Solo> getAllSoloScore(Map<String, Object> map);
    Integer getCount();
    List<Solo> getByParameter(Solo solo);
    List<Solo> getByPaAse(Solo solo);
    int updateByPrimaryKeySelective(Solo record);
    int updateByPrimaryKey(Solo record);
    //根据校区，项目查询并排序
    List<Solo> getByCampusPro(Solo solo);
    //根据校区，项目降序排序
    List<Solo> getByCampusProAse(Solo solo);
    //根据id更新加分
    int updateGradeById(Solo solo);
    //根据学院查询
    List<Solo> getByClasses(String classes);
    //查询所有
    List<Solo> getAll();
    //根据学号查询
    List<Solo> getByStuNumber(String usernumber);
    //根据性别项目查询
    List<Solo> getByProSex(Solo solo);
    List<Solo> getByProSexAsc(Solo solo);

}