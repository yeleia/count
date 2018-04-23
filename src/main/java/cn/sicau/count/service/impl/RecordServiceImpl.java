package cn.sicau.count.service.impl;

import cn.sicau.count.dao.RecordMapper;
import cn.sicau.count.domain.Record;
import cn.sicau.count.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if (recordMapper.selectByProSex(record)==null)
        {
            recordMapper.insert(record);
            return "success";
        }else {
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
    public List<Record> getAll(Integer tempPage,Integer pageCapacity) {
        Map<String,Object> map=new HashMap<>();
        map.put("tempPage",tempPage);
        map.put("pageCapacity",pageCapacity);
        return recordMapper.getAll(map);
    }

    @Override
    public Integer count() {
        return recordMapper.count();
    }

    @Override
    public Integer deleteRecord(Integer id) {
        return recordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Record getByPro(Record record) {
        return recordMapper.selectByProSex(record);
    }
}
