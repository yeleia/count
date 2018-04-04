package cn.sicau.count.dao;

import cn.sicau.count.domain.Team;

import java.util.List;

public interface TeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer id);
    Team selectByproAndClass(Team team);
    List<Team> getAllTeamScore();

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);
}