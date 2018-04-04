package cn.sicau.count.controller;

import cn.sicau.count.domain.Team;
import cn.sicau.count.service.TeamService;
import cn.sicau.count.utils.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yelei
 * @date 18-4-2
 */
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * 添加集体项目的成绩
     * @param team
     * @return
     */
    @RequestMapping("/addTeamScore")
    @ResponseBody
    public Map<String,Object> addTeamScoore(Team team){
        if ("success".equals(teamService.addTeamScore(team))){
           return ReturnMap.resultMap(200,"添加成功");
        }else {
           return ReturnMap.resultMap(500,"该学院的该项目成绩已经录入");
        }
    }

    /**
     * 修改集体项目的信息
     * @param team
     * @return
     */
    @RequestMapping("/updateTeamScore")
    @ResponseBody
    public Map<String,Object> updateTeamScore(Team team){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        String re=teamService.updateTeamScore(team);
        if ("success".equals(re)){
            resultMap.put("status",200);
            resultMap.put("message","修改成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","修改失败");
        }
        return resultMap;
    }

    /**
     * 根据id删除集体项目记录
     * @param id
     * @return
     */
    @RequestMapping("/deleteTeamScore")
    @ResponseBody
    public Map<String,Object> deleteTeamScore(@RequestParam(value = "id") Integer id){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        if (teamService.deleteById(id)!=null){
            resultMap.put("status",200);
            resultMap.put("message","删除成功");
        }else {
            resultMap.put("status",500);
            resultMap.put("message","删除失败");
        }
        return resultMap;
    }

    /**
     * 查询所有集体项目的记录
     * @return
     */
    @RequestMapping("/getAllTeamScore")
    @ResponseBody
    public Map<String,Object> getAllTeamScore(){
        Map<String,Object> resultMap=new LinkedHashMap<>();
        List<Team> teams=teamService.getAllTeamScore();
        resultMap.put("team",teams);
        return resultMap;
    }

}
