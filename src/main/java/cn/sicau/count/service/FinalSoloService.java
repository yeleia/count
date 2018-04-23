package cn.sicau.count.service;

import cn.sicau.count.dao.FinalSoloMapper;
import cn.sicau.count.domain.FinalSolo;
import cn.sicau.count.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author yelei
 * @date 18-4-8
 */
public interface FinalSoloService {
   List<FinalSolo> getByParameter(FinalSolo solo);
   List<FinalSolo> getPaAse(FinalSolo finalSolo);
   List<FinalSolo> getAll(Integer tempPage,Integer pageCapacity);
   Integer count();
   String addFinal(FinalSolo finalSolo);
   String updateFinal(FinalSolo finalSolo);
   String deleteById(Integer id);
   //根据项目查询并排序
   List<FinalSolo> getByPro(FinalSolo finalSolo);
   List<FinalSolo> getByProAsc(FinalSolo finalSolo);
   //更新finalScoreAndFianlGrade
   void updateFinalScoreById(FinalSolo finalSolo);
   //根据学院查询
   List<FinalSolo> getByClasses(String classes);
   //查询所有
   List<FinalSolo> getAll();
   //根据学号查询
   List<FinalSolo> getByStuNumber(String stunumber);
   //根据项目和性别查询
   List<FinalSolo> getByProSex(FinalSolo finalSolo);
   List<FinalSolo> getByProSexAsc(FinalSolo finalSolo);



}
