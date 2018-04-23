package cn.sicau.count.service;

import cn.sicau.count.domain.Solo;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-30
 */
public interface SoloService {
     Integer deleteById(Integer id);
     List<Solo> getSoloByParameter(Solo solo);
     //根据校区，项目查询并排序
     List<Solo> getByCampusPro(Solo solo);
     //根据校区，项目查询并降序排序
     List<Solo> getByCampusProAse(Solo solo);
     //根据校区，项目，性别降序排序
     List<Solo> getByAse(Solo solo);
     //根据id更新加分
     void updateGradeById(Solo solo);
     Solo getById(Solo solo);
     List<Solo> getByClasses(String classes);
     //查询所有记录
     List<Solo> getAll();
     List<Solo> getByStuNumber(String usernumber);
     //根据性别项目查询
     List<Solo> getByProSex(Solo solo);
     List<Solo> getByProSexAsc(Solo solo);


}
