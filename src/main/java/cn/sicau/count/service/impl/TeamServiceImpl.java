package cn.sicau.count.service.impl;

import cn.sicau.count.dao.TeamMapper;
import cn.sicau.count.domain.Team;
import cn.sicau.count.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-1
 */
@Service("teamService")
public class
TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public String addTeamScore(Team team) {
        if (teamMapper.selectByproAndClass(team)==null){
            teamMapper.insert(team);
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public String updateTeamScore(Team team) {
        if (teamMapper.updateByPrimaryKeySelective(team)!=0){
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public Integer deleteById(Integer id) {
        return teamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Team> getAllTeamScore(Integer tempPage,Integer pageCapacity) {
        Map<String,Object> map=new HashMap<>();
        map.put("tempPage",tempPage);
        map.put("pageCapacity",pageCapacity);
        return teamMapper.getAllTeamScore(map);
    }

    @Override
    public List<Team> getByParameter(Team team) {
        return teamMapper.getByParameter(team);
    }

    @Override
    public Integer count() {
        return teamMapper.count();
    }

    @Override
    public List<Team> getByCampusPro(Team team) {
        return teamMapper.getbyCampusPro(team);
    }

    @Override
    public List<Team> getByCampusProAsc(Team team) {
        return teamMapper.getByCampusProAsc(team);
    }

    @Override
    public void updateGradeById(Team team) {
        teamMapper.updateGradeById(team);
    }

    @Override
    public List<Team> getByClasses(String classes) {
        return teamMapper.getByClasses(classes);
    }

    @Override
    public List<Team> getByPro(String teamproject) {
        return teamMapper.getByPro(teamproject);
    }

    @Override
    public List<Team> getByProAsc(String teamproject) {
        return teamMapper.getByProAsc(teamproject);
    }
}
