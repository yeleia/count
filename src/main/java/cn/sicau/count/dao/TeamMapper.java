package cn.sicau.count.dao;

import cn.sicau.count.domain.Team;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Integer id);
    Team selectByproAndClass(Team team);
    List<Team> getAllTeamScore(Map<String,Object> map);
    List<Team> getByParameter(Team team);
    int updateByPrimaryKeySelective(Team record);
    Integer count();
    int updateByPrimaryKey(Team record);
    //根据校区，项目查询并排序
    List<Team> getbyCampusPro(Team team);
    List<Team> getByCampusProAsc(Team team);
    //根据id更新加分
    void updateGradeById(Team team);
    //根据学院查询
    List<Team> getByClasses(String classes);
    //根据项目查询
    List<Team> getByPro(String teamproject);
    List<Team> getByProAsc(String teamproject);
}