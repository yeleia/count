package cn.sicau.count.controller;

import cn.sicau.count.domain.*;
import cn.sicau.count.service.*;
import cn.sicau.count.utils.CountUtil;
import cn.sicau.count.utils.JsonUtil;
import cn.sicau.count.utils.TimeUtil;
import cn.sicau.count.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Time;
import java.util.*;

/**
 * @author yelei
 * @date 18-4-6
 */
@Controller

public class SoloController {
    @Autowired
    private SoloService soloService;
    @Autowired
    private FinalSoloService finalSoloService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private TwoLevelService twoLevelService;
    @Autowired
    private AbstainService abstainService;

    /**
     * 初始化页面，计算每个校区各个学院的总分，学院排名，决赛项目的男子100米，预赛项目雅安校区男子一百米，集体项目雅安60x18人迎面接力
     *
     * @param model
     * @return
     */
    @RequestMapping("/getPreliminary")
    public String getPreliminary(Model model) {
        //初始化雅安男生100米并排名
        Solo solo = new Solo();
        solo.setUsersex("男");
        solo.setCampus("001");
        solo.setProject("001001");
        List<SoloVO> soloVOS = new ArrayList<>();
        List<Solo> solos = soloService.getSoloByParameter(solo);
        int rank = 0;
        for (int i = 0; i < solos.size(); i++) {
            SoloVO soloVO = new SoloVO();
            soloVO.setClasses(JsonUtil.getClasses(solos.get(i).getClasses()));
            String s;
            if (solos.get(i).getUsernumber().charAt(0) > 65) {
                s = solos.get(i).getUsernumber().substring(1, 5);
            } else {
                s = solos.get(i).getUsernumber().substring(0, 4);
            }
            soloVO.setProfession(s + "级" + JsonUtil.get(solos.get(i).getProfession()));
            if (i != 0 && solos.get(i).getScore().equals(solos.get(i - 1).getScore())) {
                soloVO.setRank(rank);
            } else {
                soloVO.setRank(i + 1);
                rank = i + 1;
            }
         /*   soloVO.setRank(i+1);*/
            soloVO.setScore(TimeUtil.conver(solos.get(i).getScore(), solos.get(i).getProject()));
            soloVO.setStudentName(solos.get(i).getUsername());
            if (solos.get(i).getCampus().equals("003") && rank > 6) {
                break;
            } else if (rank > 8) {
                break;
            }
            soloVOS.add(soloVO);
        }
        //初始化决赛男生１００米成绩并排名
        FinalSolo finalSolo = new FinalSolo();
        finalSolo.setFinalproject("001001");
        finalSolo.setStusex("男");
        List<FinalSoloVO> finalSoloVOS = new ArrayList<>();
        List<FinalSolo> finalSolos = finalSoloService.getPaAse(finalSolo);
        int rank1 = 0;
        for (int i = 0; i < finalSolos.size(); i++) {
            FinalSoloVO finalSoloVO = new FinalSoloVO();
            if (i != 0 && finalSolos.get(i).getSecscore().equals(finalSolos.get(i - 1).getSecscore())) {
                finalSoloVO.setRank(rank1);
            } else {
                finalSoloVO.setRank(i + 1);
                rank1 = i + 1;
            }
           /* finalSoloVO.setRank(i+1);*/
            if (rank1 > 8) {
                break;
            }
            finalSoloVO.setScore(TimeUtil.conver(finalSolos.get(i).getSecscore(), finalSolos.get(i).getFinalproject()));
            finalSoloVO.setStuName(finalSolos.get(i).getStuname());
            String s;
            if (finalSolos.get(i).getStunumber().charAt(0) > 65) {
                s = finalSolos.get(i).getStunumber().substring(1, 5);
            } else {
                s = finalSolos.get(i).getStunumber().substring(0, 4);
            }
            finalSoloVO.setProfession(s + "级" + JsonUtil.get(finalSolos.get(i).getFinalprofession()));
            finalSoloVO.setClasses(JsonUtil.getClasses(finalSolos.get(i).getFinalclasses()));
            finalSoloVO.setStuNumber(finalSolos.get(i).getStunumber());
            finalSoloVOS.add(finalSoloVO);
        }
        //初始化集体项目雅安６０＊１８人迎面接力
        //60m*18人迎面接力升序排序
        Team team = new Team();
        team.setTeamproject("003001");
        team.setTeamcampus("001");
        List<TeamVO> teams = new ArrayList<>();
        List<Team> teamList = teamService.getByParameter(team);
        for (int i = 0; i < teamList.size(); i++) {
            TeamVO team1 = new TeamVO();
            if (teamList.get(i).getTeamscore() == 1) {
                /*team1.setId("1");*/
                team1.setPrice("一等奖");
            } else if (teamList.get(i).getTeamscore() == 2) {
               /* team1.setId("2");*/
                team1.setPrice("二等奖");
            } else {
               /* team1.setId("3");*/
                team1.setPrice("三等奖");
            }
            team1.setId(String.valueOf(i+1));
            team1.setTeamcampus(JsonUtil.get(teamList.get(i).getTeamcampus()));
            team1.setTeamclass(JsonUtil.getClasses(teamList.get(i).getTeamclass()));
            team1.setTeamprofession(JsonUtil.get(teamList.get(i).getTeamprofession()));
            team1.setTeamscore(teamList.get(i).getTeamscore());
            team1.setTeamproject(JsonUtil.getPro(teamList.get(i).getTeamproject()));
            teams.add(team1);
        }
        //计算预赛单项加分，并计算是否破校级录和是否达到二级运动员标准
        String[] campus = {"001", "002", "003"};
        String[] project1 = {"001001", "001002", "001003", "001004", "001005", "001006", "001007", "001008", "001009", "001010", "001011", "" +
                "002001", "002002", "002003", "002004", "002005", "002006", "002007", "002008", "002009", "002010", "002011"};
        for (int i = 0; i < campus.length; i++) {
            for (int j = 0; j < project1.length; j++) {
                Solo solo1 = new Solo();
                solo1.setProject(project1[j]);
                solo1.setCampus(campus[i]);
                solo1.setProject(project1[j]);
                List<Solo> solos1 = new ArrayList<>();
                if (project1[j].equals("001006") || project1[j].equals("001007") || project1[j].equals("001008") || project1[j].equals("001009") ||
                        project1[j].equals("002006") || project1[j].equals("002007") || project1[j].equals("002008") || project1[j].equals("002009")) {
                    solos1 = soloService.getByCampusPro(solo1);
                } else {
                    solos1 = soloService.getByCampusProAse(solo1);
                }
                //根据成绩计算分数
                if (i == 2 && solos1 != null) {
                    solos1 = CountUtil.countUtil1(solos1);
                } else if (solos1 != null) {
                    solos1 = CountUtil.countUtil(solos1);
                }
                for (int k = 0; k < solos1.size(); k++) {
                    //是否破校级录
                    Record record = new Record();
                    record.setRecordsex(solos1.get(k).getUsersex());
                    record.setReproject(solos1.get(k).getProject());
                    Record record1 = recordService.getByPro(record);
                    if (record1 != null) {
                        String pro = record1.getReproject();
                        if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                                || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                            if (TimeUtil.timeCompare(solos1.get(k).getScore(), record1.getRecord()) > 0) {
                                solos1.get(k).setGrade(solos1.get(k).getGrade() + 10);
                            }
                        } else {
                            if (TimeUtil.timeCompare(solos1.get(k).getScore(), record1.getRecord()) < 0) {
                                solos1.get(k).setGrade(solos1.get(k).getGrade() + 10);
                            }
                        }

                    }
                    //是否达到二级运动员标准
                    TwoLevel twoLevel = new TwoLevel();
                    twoLevel.setLevelsex(solos1.get(k).getUsersex());
                    twoLevel.setLevelpro(solos1.get(k).getProject());
                    TwoLevel twoLevel1 = twoLevelService.getByProSex(twoLevel);
                    if (twoLevel1 != null) {
                        String pro = twoLevel1.getLevelpro();
                        if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                                || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {

                            if (TimeUtil.timeCompare(solos1.get(k).getScore(), twoLevel1.getLevelscore()) >= 0) {
                                solos1.get(k).setGrade(solos1.get(k).getGrade() + 10);
                            }
                        } else {
                            if (TimeUtil.timeCompare(solos1.get(k).getScore(), twoLevel1.getLevelscore()) <= 0) {
                                solos1.get(k).setGrade(solos1.get(k).getGrade() + 10);
                            }
                        }
                    }
                    soloService.updateGradeById(solos1.get(k));
                }
            }
        }
        //计算决赛单项成绩
        for (int i = 0; i < project1.length; i++) {
            FinalSolo finalSolo1 = new FinalSolo();
            finalSolo1.setFinalproject(project1[i]);
            List<FinalSolo> finalSolos1 = new ArrayList<>();
            if (project1[i].equals("001006") || project1[i].equals("001007") || project1[i].equals("001008") || project1[i].equals("001009") ||
                    project1[i].equals("002006") || project1[i].equals("002007") || project1[i].equals("002008") || project1[i].equals("002009")) {
                finalSolos1 = finalSoloService.getByPro(finalSolo1);
            } else {
                finalSolos1 = finalSoloService.getByProAsc(finalSolo1);
            }
            if (finalSolos1 != null) {
                finalSolos1 = CountUtil.count(finalSolos1);
            }
            for (int j = 0; j < finalSolos1.size(); j++) {
                //是否破校级录
                Record record = new Record();
                record.setReproject(finalSolos1.get(j).getFinalproject());
                record.setRecordsex(finalSolos1.get(j).getStusex());
                Record record1 = recordService.getByPro(record);
                if (record1 != null) {
                    String pro = record1.getReproject();
                    if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                            || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                        if (TimeUtil.timeCompare(finalSolos1.get(j).getSecscore(), record1.getRecord()) > 0) {
                            finalSolos1.get(j).setFinalscore(finalSolos1.get(j).getFinalscore() + 10);
                        }
                    } else {
                        if (TimeUtil.timeCompare(finalSolos1.get(j).getSecscore(), record1.getRecord()) < 0) {
                            finalSolos1.get(j).setFinalscore(finalSolos1.get(j).getFinalscore() + 10);
                        }
                    }
                }
                //是否达到二级运动员标准
                TwoLevel twoLevel = new TwoLevel();
                twoLevel.setLevelpro(finalSolos1.get(j).getFinalproject());
                twoLevel.setLevelsex(finalSolos1.get(j).getStusex());
                TwoLevel twoLevel1 = twoLevelService.getByProSex(twoLevel);
                if (twoLevel1 != null) {
                    String pro = twoLevel1.getLevelpro();
                    if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                            || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                        if (TimeUtil.timeCompare(finalSolos1.get(j).getSecscore(), twoLevel1.getLevelscore()) >= 0) {
                            finalSolos1.get(j).setFinalscore(finalSolos1.get(j).getFinalscore() + 10);
                        }
                    } else {
                        if (TimeUtil.timeCompare(finalSolos1.get(j).getSecscore(), twoLevel1.getLevelscore()) <= 0) {
                            finalSolos1.get(j).setFinalscore(finalSolos1.get(j).getFinalscore() + 10);
                        }
                    }
                }
                //比较两次成绩，将得分最高的一次计入到决赛的finalGrade
                for (int k = 0; k < finalSolos1.size(); k++) {
                    Solo solo2=new Solo();
                    solo2.setId(finalSolos1.get(k).getSoloid());
                    solo2.setProject(finalSolos1.get(k).getFinalproject());
                    Solo solo1 = soloService.getById(solo2);
                    if (solo1.getGrade() > finalSolos1.get(k).getFinalscore()) {
                        finalSolos1.get(k).setFinalgrade(solo1.getGrade());
                    } else {
                        finalSolos1.get(k).setFinalgrade(finalSolos1.get(k).getFinalscore());
                    }
                    solo1.setGrade(0.0);
                    soloService.updateGradeById(solo1);
                    finalSoloService.updateFinalScoreById(finalSolos1.get(k));
                }
            }
        }
        //计算集体项目成绩
        String[] project2 = {"003001", "003002", "003003", "003004", "003005", "003006", "003007", "003008"};
        List<Team> teams1 = new ArrayList<>();
        for (int i = 0; i < project2.length; i++) {
      /*      if (project2[i].equals("003001")||project2[i].equals("003002")){*/
            teams1 = teamService.getByProAsc(project2[i]);
            /*}else {
                teams1=teamService.getByPro(project2[i]);
            }*/
            if (teams1 != null) {
                teams1 = CountUtil.teamCount(teams1);
            }
            for (int j = 0; j < teams1.size(); j++) {
               /*System.out.println(teams1.get(j));*/
                teamService.updateGradeById(teams1.get(j));
            }
        }
        //计算团体总分
        String[] classes = {"003003", "003002", "003004", "003001", "002012", "002003", "002004", "002006", "002005", "002011", "002010",
                "002007", "002002", "002001", "002008", "001010", "001002", "001005", "001008", "001001", "001007", "001003", "001006", "001004"};
        List<ClassesVO> classesVOS = new ArrayList<>();
        for (int i = 0; i < classes.length; i++) {
            ClassesVO classesVO = new ClassesVO();
            if (i <= 8) {
                classesVO.setCampus("001");
            } else if (i > 8 && i <= 19) {
                classesVO.setCampus("002");
            } else {
                classesVO.setCampus("003");
            }
            classesVO.setClasses(classes[i]);
            classesVO.setGrade(0.0);
            //加上单项成绩的加分
            List<Solo> solos1 = soloService.getByClasses(classes[i]);
            List<FinalSolo> finalSolos1 = finalSoloService.getByClasses(classes[i]);
            if (solos1.size() >= 1) {
                for (int j = 0; j < solos1.size(); j++) {
                    classesVO.setGrade(solos1.get(j).getGrade() + classesVO.getGrade());
                }
            }
            if (finalSolos1.size() >= 1) {
                for (int k = 0; k < finalSolos1.size(); k++) {
                    classesVO.setGrade(classesVO.getGrade() + finalSolos1.get(k).getFinalgrade());
                }
            }
            //加上集体项目成绩的加分
            List<Team> teams2 = teamService.getByClasses(classes[i]);
            if (teams2.size() >= 1) {
                for (int l = 0; l < teams2.size(); l++) {
                    classesVO.setGrade(classesVO.getGrade() + teams2.get(l).getTeamgrade());
                }
            }
            //减去弃权人数
            Abstain abstain = abstainService.getByClasses(classes[i]);
            if (abstain != null) {
                classesVO.setGrade(classesVO.getGrade() - abstain.getCounts());
            }
            classesVOS.add(classesVO);
        }
        List<ClassesVO> classesVOList = new ArrayList<>();
        for (int i = 0; i < classesVOS.size(); i++) {
            classesVOList.add(classesVOS.get(i));
        }

        //团体成绩排序
        Collections.sort(classesVOS, new Comparator<ClassesVO>() {
            @Override
            public int compare(ClassesVO o1, ClassesVO o2) {
                if(o2.getGrade()>o1.getGrade())
                    return 1;
                else if(o2.getGrade()<o1.getGrade())
                    return -1;
                else return 0;
            }
        });

        for (int i = 0; i < classesVOS.size(); i++) {
            classesVOS.get(i).setClasses(JsonUtil.getClasses(classesVOS.get(i).getClasses()));
            classesVOS.get(i).setCampus(JsonUtil.get(classesVOS.get(i).getCampus()));
            classesVOS.get(i).setRank(i + 1);
        }
        //预赛查询破校级录
        List<Solo> solos1 = soloService.getAll();
        List<RecordVO> recordVOS = new ArrayList<>();
        for (int i = 0; i < solos1.size(); i++) {
            Record record = new Record();
            record.setRecordsex(solos1.get(i).getUsersex());
            record.setReproject(solos1.get(i).getProject());
            Record record1 = recordService.getByPro(record);
            if (record1 != null) {
                String pro = record1.getReproject();
                if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                        || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                    if (TimeUtil.timeCompare(solos1.get(i).getScore(), record1.getRecord()) > 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(solos1.get(i).getProject()));
                        recordVO.setSex(solos1.get(i).getUsersex());
                        String s;
                        if (solos1.get(i).getUsernumber().charAt(0) > 65) {
                            s = solos1.get(i).getUsernumber().substring(1, 5);
                        } else {
                            s = solos1.get(i).getUsernumber().substring(0, 4);
                        }
                        // System.out.println("yyuy");
                        recordVO.setProfession(s + "级" + JsonUtil.get(solos1.get(i).getProfession()));
                        recordVO.setNumber(solos1.get(i).getUsernumber());
                        recordVO.setName(solos1.get(i).getUsername());
                        recordVO.setCampus(JsonUtil.get(solos1.get(i).getCampus()));
                        recordVO.setScore(TimeUtil.conver(solos1.get(i).getScore(), solos1.get(i).getProject()));
                        recordVO.setClasses(JsonUtil.getClasses(solos1.get(i).getClasses()));
                        recordVOS.add(recordVO);
                    }
                } else {
                    if (TimeUtil.timeCompare(solos1.get(i).getScore(), record1.getRecord()) < 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(solos1.get(i).getProject()));
                        recordVO.setSex(solos1.get(i).getUsersex());
                        String s;
                        if (solos1.get(i).getUsernumber().charAt(0) > 65) {
                            s = solos1.get(i).getUsernumber().substring(1, 5);
                        } else {
                            s = solos1.get(i).getUsernumber().substring(0, 4);
                        }
                        recordVO.setProfession(s + "级" + JsonUtil.get(solos1.get(i).getProfession()));
                        recordVO.setNumber(solos1.get(i).getUsernumber());
                        recordVO.setName(solos1.get(i).getUsername());
                        recordVO.setCampus(JsonUtil.get(solos1.get(i).getCampus()));
                        recordVO.setScore(TimeUtil.conver(solos1.get(i).getScore(), solos1.get(i).getProject()));
                        recordVO.setClasses(JsonUtil.getClasses(solos1.get(i).getClasses()));
                        recordVOS.add(recordVO);
                    }
                }
            }
        }
        //决赛查询破校级录
        List<FinalSolo> finalSolos1 = finalSoloService.getAll();
        for (int i = 0; i < finalSolos1.size(); i++) {
            /*System.out.println(finalSolos1.size());*/
            Record record = new Record();
            record.setRecordsex(finalSolos1.get(i).getStusex());
            record.setReproject(finalSolos1.get(i).getFinalproject());
            Record record1 = recordService.getByPro(record);
            if (record1 != null) {
                String pro = record1.getReproject();
                if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                        || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                    if (TimeUtil.timeCompare(finalSolos1.get(i).getSecscore(), record1.getRecord()) > 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(finalSolos1.get(i).getFinalproject()));
                        recordVO.setSex(finalSolos1.get(i).getStusex());
                        String s;
                        if (finalSolos1.get(i).getStunumber().charAt(0) > 65) {
                            s = finalSolos1.get(i).getStunumber().substring(1, 5);
                        } else {
                            s = finalSolos1.get(i).getStunumber().substring(0, 4);
                        }
                        recordVO.setProfession(s + "级" + JsonUtil.get(finalSolos1.get(i).getFinalprofession()));
                        recordVO.setNumber(finalSolos1.get(i).getStunumber());
                        recordVO.setName(finalSolos1.get(i).getStuname());
                        recordVO.setCampus(JsonUtil.get(finalSolos1.get(i).getFinalcampus()));
                        recordVO.setScore(TimeUtil.conver(finalSolos1.get(i).getSecscore(), finalSolos1.get(i).getFinalproject()));
                        recordVO.setClasses(JsonUtil.getClasses(finalSolos1.get(i).getFinalclasses()));
                        recordVOS.add(recordVO);
                       /* System.out.println("test1");*/
                    }
                } else {

                    if (TimeUtil.timeCompare(finalSolos1.get(i).getSecscore(), record1.getRecord()) < 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(finalSolos1.get(i).getFinalproject()));
                        recordVO.setSex(finalSolos1.get(i).getStusex());
                        String s;
                        if (finalSolos1.get(i).getStunumber().charAt(0) > 65) {
                            s = finalSolos1.get(i).getStunumber().substring(1, 5);
                        } else {
                            s = finalSolos1.get(i).getStunumber().substring(0, 4);
                        }
                        recordVO.setProfession(s + "级" + JsonUtil.get(finalSolos1.get(i).getFinalprofession()));
                        recordVO.setNumber(finalSolos1.get(i).getStunumber());
                        recordVO.setName(finalSolos1.get(i).getStuname());
                        recordVO.setCampus(JsonUtil.get(finalSolos1.get(i).getFinalcampus()));
                        recordVO.setScore(TimeUtil.conver(finalSolos1.get(i).getSecscore(), finalSolos1.get(i).getFinalproject()));
                        recordVO.setClasses(JsonUtil.getClasses(finalSolos1.get(i).getFinalclasses()));
                        recordVOS.add(recordVO);
                        /*System.out.println("test2");*/
                    }

                }
            }
        }
        //查询预赛达到二级运动员标准
        List<RecordVO> recordVOS1 = new ArrayList<>();
        List<Solo> solos11 = soloService.getAll();
        for (int i = 0; i < solos11.size(); i++) {
            TwoLevel twoLevel = new TwoLevel();
            twoLevel.setLevelsex(solos11.get(i).getUsersex());
            twoLevel.setLevelpro(solos11.get(i).getProject());
            TwoLevel twoLevel1 = twoLevelService.getByProSex(twoLevel);
            if (twoLevel1 != null) {
                String pro = twoLevel1.getLevelpro();
                /*System.out.println(pro);*/
                if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                        || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                    if (TimeUtil.timeCompare(solos11.get(i).getScore(), twoLevel1.getLevelscore()) >= 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(solos1.get(i).getProject()));
                        recordVO.setSex(solos1.get(i).getUsersex());
                        String s;
                        if (solos1.get(i).getUsernumber().charAt(0) > 65) {
                            s = solos1.get(i).getUsernumber().substring(1, 5);
                        } else {
                            s = solos1.get(i).getUsernumber().substring(0, 4);
                        }
                        recordVO.setProfession(s + "级" + JsonUtil.get(solos1.get(i).getProfession()));
                        recordVO.setNumber(solos1.get(i).getUsernumber());
                        recordVO.setName(solos1.get(i).getUsername());
                        recordVO.setCampus(JsonUtil.get(solos1.get(i).getCampus()));
                        recordVO.setScore(TimeUtil.conver(solos1.get(i).getScore(), solos1.get(i).getProject()));
                        recordVO.setClasses(JsonUtil.getClasses(solos1.get(i).getClasses()));
                        recordVOS1.add(recordVO);
                        /*System.out.println();*/
                    }
                } else {
                    if (TimeUtil.timeCompare(solos11.get(i).getScore(), twoLevel1.getLevelscore()) <= 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(solos1.get(i).getProject()));
                        recordVO.setSex(solos1.get(i).getUsersex());
                        String s;
                        if (solos1.get(i).getUsernumber().charAt(0) > 65) {
                            s = solos1.get(i).getUsernumber().substring(1, 5);
                        } else {
                            s = solos1.get(i).getUsernumber().substring(0, 4);
                        }
                       /* System.out.println();*/
                        recordVO.setProfession(s + "级" + JsonUtil.get(solos1.get(i).getProfession()));
                        recordVO.setNumber(solos1.get(i).getUsernumber());
                        recordVO.setName(solos1.get(i).getUsername());
                        recordVO.setCampus(JsonUtil.get(solos1.get(i).getCampus()));
                        recordVO.setScore(TimeUtil.conver(solos1.get(i).getScore(), solos1.get(i).getProject()));
                        recordVO.setClasses(JsonUtil.getClasses(solos1.get(i).getClasses()));
                        recordVOS1.add(recordVO);
                    }
                }
            }
        }
        //查询决赛到达二级运动员标准
        List<FinalSolo> finalSolos2 = finalSoloService.getAll();
        for (int i = 0; i < finalSolos2.size(); i++) {
            TwoLevel twoLevel = new TwoLevel();
            twoLevel.setLevelsex(finalSolos2.get(i).getStusex());
            twoLevel.setLevelpro(finalSolos2.get(i).getFinalproject());
            TwoLevel twoLevel1 = twoLevelService.getByProSex(twoLevel);
            if (twoLevel1 != null) {
                String pro = twoLevel1.getLevelpro();
                if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009") || pro.equals("002006")
                        || pro.equals("002007") || pro.equals("002008") || pro.equals("002009")) {
                    if (TimeUtil.timeCompare(finalSolos1.get(i).getSecscore(), twoLevel1.getLevelscore()) >= 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(finalSolos2.get(i).getFinalproject()));
                        recordVO.setSex(finalSolos2.get(i).getStusex());
                        String s;
                        if (finalSolos2.get(i).getStunumber().charAt(0) > 65) {
                            s = finalSolos2.get(i).getStunumber().substring(1, 5);
                        } else {
                            s = finalSolos2.get(i).getStunumber().substring(0, 4);
                        }
                        recordVO.setProfession(s + "级" + JsonUtil.get(finalSolos2.get(i).getFinalprofession()));
                        recordVO.setNumber(finalSolos2.get(i).getStunumber());
                        recordVO.setName(finalSolos2.get(i).getStuname());
                        recordVO.setCampus(JsonUtil.get(finalSolos2.get(i).getFinalcampus()));
                        recordVO.setScore(TimeUtil.conver(finalSolos2.get(i).getSecscore(), finalSolos2.get(i).getFinalproject()));
                        recordVO.setClasses(JsonUtil.getClasses(finalSolos2.get(i).getFinalclasses()));
                        recordVOS1.add(recordVO);
                    }
                } else {
                    if (TimeUtil.timeCompare(finalSolos1.get(i).getSecscore(), twoLevel1.getLevelscore()) <= 0) {
                        RecordVO recordVO = new RecordVO();
                        recordVO.setProject(JsonUtil.getPro(finalSolos2.get(i).getFinalproject()));
                        recordVO.setSex(finalSolos2.get(i).getStusex());
                        String s;
                        if (finalSolos2.get(i).getStunumber().charAt(0) > 65) {
                            s = finalSolos2.get(i).getStunumber().substring(1, 5);
                        } else {
                            s = finalSolos2.get(i).getStunumber().substring(0, 4);
                        }
                        recordVO.setProfession(s + "级" + JsonUtil.get(finalSolos2.get(i).getFinalprofession()));
                        recordVO.setNumber(finalSolos2.get(i).getStunumber());
                        recordVO.setName(finalSolos2.get(i).getStuname());
                        recordVO.setCampus(JsonUtil.get(finalSolos2.get(i).getFinalcampus()));
                        recordVO.setScore(TimeUtil.conver(finalSolos2.get(i).getSecscore(), finalSolos2.get(i).getFinalproject()));
                        recordVO.setClasses(JsonUtil.getClasses(finalSolos2.get(i).getFinalclasses()));
                        recordVOS1.add(recordVO);
                    }
                }
            }
        }
        model.addAttribute("solo", soloVOS);
        model.addAttribute("finalSolo", finalSoloVOS);
        model.addAttribute("team", teams);
        model.addAttribute("vo", classesVOList);
     /*   model.addAttribute("yaan",classesVOS1);
        model.addAttribute("chengdu",classesVOS2);
        model.addAttribute("dujiangyan",classesVOS3);*/
        model.addAttribute("classes", classesVOS);
        model.addAttribute("record", recordVOS);
        model.addAttribute("twoLevel", recordVOS1);
        return "show";
    }

    /**
     * 查询决赛，根据项目和性别
     *
     * @param finalSolo
     * @return
     */
    @RequestMapping("/getQuery")
    @ResponseBody
    public Map<String, Object> getQuery(FinalSolo finalSolo) {
        String[] a = {"001001", "001002", "001003", "001004", "001005", "001010", "001011", "002001", "002002", "002003", "002004", "002005", "002010", "002011"};
        List<FinalSolo> finalSolos = new ArrayList<>();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (finalSolo.getFinalproject().equals(a[i])) {
                flag = true;
            }
        }
        //预赛查
        if (flag) {
            finalSolos = finalSoloService.getPaAse(finalSolo);
        } else {
            finalSolos = finalSoloService.getByParameter(finalSolo);
        }
        List<FinalSoloVO> finalSoloVOS = new ArrayList<>();
        int rank2 = 0;
        for (int i = 0; i < finalSolos.size(); i++) {
            FinalSoloVO finalSoloVO = new FinalSoloVO();
            String s;
            if (finalSolos.get(i).getStunumber().charAt(0) > 65) {
                s = finalSolos.get(i).getStunumber().substring(1, 5);
            } else {
                s = finalSolos.get(i).getStunumber().substring(0, 4);
            }
            finalSoloVO.setStuNumber(finalSolos.get(i).getStunumber());
            finalSoloVO.setClasses(JsonUtil.getClasses(finalSolos.get(i).getFinalclasses()));
            finalSoloVO.setProfession(s + "级" + JsonUtil.get(finalSolos.get(i).getFinalprofession()));
            finalSoloVO.setStuName(finalSolos.get(i).getStuname());
            if (i != 0 && finalSolos.get(i).getSecscore().equals(finalSolos.get(i - 1).getSecscore())) {
                finalSoloVO.setRank(rank2);
            } else {
                finalSoloVO.setRank(i + 1);
                rank2 = i + 1;
            }
            /*finalSoloVO.setRank(i + 1);*/
            if (rank2 > 8) {
                break;
            }
            finalSoloVO.setScore(TimeUtil.conver(finalSolos.get(i).getSecscore(), finalSolos.get(i).getFinalproject()));
            finalSoloVOS.add(finalSoloVO);
        }
        resultMap.put("finalSolo", finalSoloVOS);
        return resultMap;
    }

    /**
     * 根据参数查看预赛
     *
     * @param solo
     * @return
     */
    @RequestMapping("/getQuery1")
    @ResponseBody
    public Map<String, Object> query1(Solo solo) {
        String[] a = {"001001", "001002", "001003", "001004", "001005", "001010", "001011", "002001", "002002", "002003", "002004", "002005", "002010", "002011"};
        Map<String, Object> resultMap = new LinkedHashMap<>();
        List<SoloVO> soloVOS = new ArrayList<>();
        String project = solo.getProject();
        List<Solo> solos = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            if (project.equals(a[i])) {
                flag = true;
            }
        }
        if (!flag) {
            solos = soloService.getByAse(solo);

        } else {
            solos = soloService.getSoloByParameter(solo);
        }
        int rank3 = 0;
        for (int i = 0; i < solos.size(); i++) {
            SoloVO soloVO = new SoloVO();
            String s;
            if (solos.get(i).getUsernumber().charAt(0) > 65) {
                s = solos.get(i).getUsernumber().substring(1, 5);
            } else {
                s = solos.get(i).getUsernumber().substring(0, 4);
            }
            soloVO.setStuNumber(solos.get(i).getUsernumber());
            soloVO.setProfession(s + "级" + JsonUtil.get(solos.get(i).getProfession()));
            soloVO.setClasses(JsonUtil.getClasses(solos.get(i).getClasses()));
            soloVO.setStudentName(solos.get(i).getUsername());
            /*soloVO.setRank(i+1);*/

            if (i != 0 && solos.get(i).getScore().equals(solos.get(i - 1).getScore())) {
                soloVO.setRank(rank3);
            } else {
                soloVO.setRank(i + 1);
                rank3 = i + 1;
            }

            if (solos.get(i).getCampus().equals("003") && rank3 > 6) {
                break;
            } else if (rank3 > 8) {
                break;
            }
            soloVO.setScore(TimeUtil.conver(solos.get(i).getScore(), solos.get(i).getProject()));

            soloVOS.add(soloVO);
        }
        resultMap.put("solo", soloVOS);
        return resultMap;
    }

    /**
     * 根据参苏查询集体项目
     *
     * @param
     * @return
     */
    @RequestMapping("/getQuery2")
    @ResponseBody
    public Map<String, Object> query2(Team team1) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        List<TeamVO> teams = new ArrayList<>();
        String project = team1.getTeamproject();
        List<Team> teams1 = new ArrayList<>();
      /*  if (project.equals("003001")||project.equals("003002")){*/
        teams1 = teamService.getByCampusProAsc(team1);
/*
        }else {
            teams1=teamService.getByCampusPro(team1);
        }*/
        for (int i = 0; i < teams1.size(); i++) {
            TeamVO team = new TeamVO();
            if (teams1.get(i).getTeamscore() == 1) {
                team.setPrice("一等奖");
               /* team.setId("1");*/
            } else if (teams1.get(i).getTeamscore() == 2) {
                team.setPrice("二等奖");
               /* team.setId("2");*/
            } else {
                team.setPrice("三等奖");
               /* team.setId("3");*/
            }
            team.setId(String.valueOf(i+1));
            team.setTeamcampus(JsonUtil.get(teams1.get(i).getTeamcampus()));
            team.setTeamclass(JsonUtil.getClasses(teams1.get(i).getTeamclass()));
            team.setTeamprofession(JsonUtil.get(teams1.get(i).getTeamprofession()));
            team.setTeamscore(teams1.get(i).getTeamscore());
            teams.add(team);
        }
        resultMap.put("team", teams);
        return resultMap;

    }

    /**
     * 根据学号查询
     *
     * @param stuNumber
     * @return
     */
    @RequestMapping("/getQuery3")
    @ResponseBody
    public Map<String, Object> getQuery3(@RequestParam(value = "stuNumber", required = false) String stuNumber) {
        Map<String, Object> resultMap = new LinkedHashMap<>();
        boolean is_matcher = stuNumber.matches("[A-Za-z0-9]+");
        if (is_matcher && stuNumber.length() >= 8 && stuNumber.length() <= 10) {
            List<SoloVO> soloVOS = new ArrayList<>();
            //根据学号查找预赛的项目
            List<Solo> solos = soloService.getByStuNumber(stuNumber);
            if (solos != null) {
                for (int i = 0; i < solos.size(); i++) {
                    String pro = solos.get(i).getProject();
                    Solo solo = new Solo();
                    solo.setProject(solos.get(i).getProject());
                    solo.setUsersex(solos.get(i).getUsersex());
                    solo.setCampus(solos.get(i).getCampus());
                    List<Solo> soloList = new ArrayList<>();
                    if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009")||pro.equals("002006")||
                            pro.equals("002007")||pro.equals("002008")||pro.equals("002009") ){
                        soloList = soloService.getByProSex(solo);
                    } else {
                        soloList = soloService.getByProSexAsc(solo);
                    }
                    int rank4 = 0;
                    for (int j = 0; j < soloList.size(); j++) {
                        SoloVO soloVO = new SoloVO();
                        if (j != 0 && soloList.get(j).getScore().equals(soloList.get(j - 1).getScore())) {
                            soloVO.setRank(rank4);
                        } else {
                            soloVO.setRank(j + 1);
                            rank4 = j + 1;
                        }
                        soloVO.setStuNumber(soloList.get(j).getUsernumber());
                        soloVO.setStudentName(soloList.get(j).getUsername());
                        soloVO.setProfession(JsonUtil.get(soloList.get(j).getProfession()));
                        soloVO.setClasses(JsonUtil.getClasses(soloList.get(j).getClasses()));
                        soloVO.setFormate("预选赛");
                        soloVO.setProject(JsonUtil.getPro(soloList.get(j).getProject()));
                        soloVO.setScore(TimeUtil.conver(soloList.get(j).getScore(), soloList.get(j).getProject()));
                        if (soloList.get(j).getUsernumber().equals(stuNumber)) {
                            soloVOS.add(soloVO);
                        }
                    }
                }
            }
            //根据学号查询决赛的成绩
            List<FinalSolo> finalSolos = finalSoloService.getByStuNumber(stuNumber);
            if (finalSolos != null) {
                for (int i = 0; i < finalSolos.size(); i++) {
                    String pro = finalSolos.get(i).getFinalproject();
                    List<FinalSolo> finalSoloList = new ArrayList<>();
                    FinalSolo finalSolo = new FinalSolo();
                    finalSolo.setFinalproject(finalSolos.get(i).getFinalproject());
                    finalSolo.setStusex(finalSolos.get(i).getStusex());
                    if (pro.equals("001006") || pro.equals("001007") || pro.equals("001008") || pro.equals("001009")||pro.equals("002006")||
                            pro.equals("002007")||pro.equals("002008")||pro.equals("002009") ){

                        finalSoloList = finalSoloService.getByProSex(finalSolo);
                    } else {
                        finalSoloList = finalSoloService.getByProSexAsc(finalSolo);
                    }
                    int rank5 = 0;
                    for (int j = 0; j < finalSoloList.size(); j++) {
                        SoloVO soloVO = new SoloVO();
                        soloVO.setProject(JsonUtil.getPro(finalSoloList.get(j).getFinalproject()));
                        soloVO.setFormate("决赛");
                        soloVO.setClasses(JsonUtil.getClasses(finalSoloList.get(j).getFinalclasses()));
                        soloVO.setProfession(JsonUtil.get(finalSoloList.get(j).getFinalprofession()));
                             /* soloVO.setRank(j+1);*/
                        if (j != 0 && finalSoloList.get(j).getSecscore().equals(finalSoloList.get(j - 1).getSecscore())) {
                            soloVO.setRank(rank5);
                        } else {
                            soloVO.setRank(j + 1);
                            rank5 = j + 1;
                        }
                        soloVO.setStudentName(finalSoloList.get(j).getStuname());
                        soloVO.setScore(TimeUtil.conver(finalSoloList.get(j).getSecscore(), finalSoloList.get(j).getFinalproject()));
                        soloVO.setStuNumber(stuNumber);
                        if (finalSoloList.get(j).getStunumber().equals(stuNumber)) {
                            soloVOS.add(soloVO);
                        }
                    }
                }
            }
            resultMap.put("status", 200);
            resultMap.put("soloVO", soloVOS);
        } else {
            resultMap.put("status", 500);
            resultMap.put("message", "请输入正确的学号");
        }
        return resultMap;

    }

//    List<SoloVO> convertToSoloVo(List<Solo> solos){
//        List<SoloVO> soloVOS=new ArrayList<>();
//        String baseScore=solos.get(0).getScore();
//        int baseRank=1;
//        int currRank=0;
//        int len=solos.size();
//        for (int i = 1; i < len; i++) {
//            Solo solo=solos.get(i);
//            SoloVO soloVO=new SoloVO(solo.getId(),
//                    solo.getUsername(),
//                    solo.get);
//            if (baseScore.equals(solo.getScore())){
//
//            }
//        }
//    }

}
