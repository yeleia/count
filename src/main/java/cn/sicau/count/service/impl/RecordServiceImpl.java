package cn.sicau.count.service.impl;

import cn.sicau.count.dao.RecordMapper;
import cn.sicau.count.domain.Record;
import cn.sicau.count.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yelei
 * @date 18-3-29
 */
@Service("recordService")
public class RecordServiceImpl implements RecordService{
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public String  addSchoolRecord(Record record) {
        try {
            recordMapper.insert(record);
            return "success";
        }catch (Exception e){
            return "error";
        }

    }

    @Override
    public String updateSchoolRecord(Record record) {
        try{
            recordMapper.updateByPrimaryKeySelective(record);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    public List<Record> getAll() {
        return recordMapper.getAll();
    }

    @Override
    public Integer deleteRecord(Integer id) {
        return recordMapper.deleteByPrimaryKey(id);
    }
}
