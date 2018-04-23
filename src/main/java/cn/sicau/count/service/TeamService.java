package cn.sicau.count.service;

import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.Team;

import java.util.List;

/**
 * @author yelei
 * @date 18-4-1
 */
public interface TeamService {
    String addTeamScore(Team team);
    String updateTeamScore(Team team);
    Integer deleteById(Integer id);
    List<Team> getAllTeamScore(Integer tempPage,Integer pageCapacity);
    List<Team> getByParameter(Team team);
    Integer count();
    //根据校区，项目查询并排序
    List<Team> getByCampusPro(Team team);
    List<Team> getByCampusProAsc(Team team);
    //根据id更新加分
    void updateGradeById(Team team);
    //根据学院查询
    List<Team> getByClasses(String classes);
    //根据项目查询
    List<Team> getByPro(String teamproject);
    List<Team> getByProAsc(String teamproject);
}
