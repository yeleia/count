package cn.sicau.count.dao;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface TeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Team record);

    int insertSelective(Team record);
    Team selectByproAndClass(Team team);
    Team selectByPrimaryKey(Integer id);
    List<Team> getAllTeamScore();

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

}