package cn.sicau.count.service.impl;

import cn.sicau.count.dao.TeamMapper;
import cn.sicau.count.domain.Team;
import cn.sicau.count.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yelei
 * @date 18-4-1
 */
@Service("teamService")
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public String addTeamScore(Team team) {
        if (teamMapper.selectByproAndClass(team)!=null){
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
    public List<Team> getAllTeamScore() {
        return teamMapper.getAllTeamScore();
    }
}
