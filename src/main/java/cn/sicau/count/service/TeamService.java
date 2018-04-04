package cn.sicau.count.service;

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
    List<Team> getAllTeamScore();
}
