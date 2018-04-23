package cn.sicau.count.dao;

import cn.sicau.count.domain.Abstain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface AbstainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Abstain record);

    int insertSelective(Abstain record);

    Abstain selectByPrimaryKey(Integer id);
    List<Abstain> getAll(Map<String,Object> map);
    int updateByPrimaryKeySelective(Abstain record);
    Integer count();
    int updateByPrimaryKey(Abstain record);
    //根据学院查询弃权的人数
    Abstain getByClasses(String classes);
}