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
    List<Record> getAll();
    Integer deleteRecord(Integer id);
}
