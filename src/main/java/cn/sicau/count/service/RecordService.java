package cn.sicau.count.service;

import cn.sicau.count.domain.Record;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-29
 */
public interface RecordService {
    String  addSchoolRecord(Record record);
    String updateSchoolRecord(Record record);
    List<Record> getAll(Integer tempPage,Integer pageCapacity);
    Integer count();
    Integer deleteRecord(Integer id);
    //根据项目查询校级录
    Record getByPro(Record record);
}
