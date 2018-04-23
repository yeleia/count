package cn.sicau.count.dao;

import cn.sicau.count.domain.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
    List<Record> getAll(Map<String,Object> map);
    Integer count();
    //根据项目和性别查询校级录
    Record selectByProSex(Record record);
}