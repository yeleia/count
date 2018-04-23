package cn.sicau.count.utils;

import cn.sicau.count.domain.FinalSolo;
import cn.sicau.count.domain.Solo;
import cn.sicau.count.domain.Team;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yelei
 * @date 18-4-10
 */
public class CountUtil {
    //成都和雅安
    public static List<Solo> countUtil(List<Solo> solos) {
        return setScore(solos,1);
    }

    //都江堰
    public static List<Solo> countUtil1(List<Solo> solos) {
        return setScore(solos,0);
    }


    public static List<Team> teamCount(List<Team> teams) {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamscore() == 1) {
                teams.get(i).setTeamgrade(27);
            } else if (teams.get(i).getTeamscore() == 2) {
                teams.get(i).setTeamgrade(21);
            } else {
                teams.get(i).setTeamgrade(18);
            }
        }
        return teams;
    }

    public static List<FinalSolo> count(List<FinalSolo> solos){


        int indexStart = 0;
        int len = solos.size();

        if (solos.size()==1){
            addFinalGrade(solos,0,1);
            return solos;
        }

        for (int i = 0; i < len; i++) {
            //last
            if (i == len - 1) {
                //last == last-1
                if (solos.get(i - 1).getScore().equals(solos.get(i).getScore())) {
                    //TODO add indexStart avg to last
                    addFinalGrade(solos,indexStart,len);
                } else {
                    //TODO add avg indexStart to i-1
                    addFinalGrade(solos,indexStart,i);
                    //TODO add avg last
                    addFinalGrade(solos,len-1,len);
                }
                break;
            }

            //i==i+1
            if (solos.get(i).getScore().equals(solos.get(i + 1).getScore())) {
                continue;
            } else {
                //TODO add indexStart to i
                addFinalGrade(solos,indexStart,i+1);
                indexStart = i + 1;
            }

        }

        List<FinalSolo> finalSoloList=new ArrayList<>();
        for (int i = 0; i < solos.size(); i++) {
            finalSoloList.add(solos.get(i));
        }
        return finalSoloList;
    }

    public static List<FinalSolo> countOld(List<FinalSolo> finalSolos) {
        int temp = 0;
        String n = null;
        for (int i = 0; i < finalSolos.size(); i++) {

            if (finalSolos.get(i).getSecscore().equals(n)) {
                if (temp == 0) {
                    finalSolos.get(i).setFinalscore(27.0);
                } else if (temp == 1) {
                    finalSolos.get(i).setFinalscore(21.0);
                } else if (temp == 2) {
                    finalSolos.get(i).setFinalscore(18.0);
                } else if (temp == 3) {
                    finalSolos.get(i).setFinalscore(15.0);
                } else if (temp == 4) {
                    finalSolos.get(i).setFinalscore(12.0);
                } else if (temp == 5) {
                    finalSolos.get(i).setFinalscore(9.0);
                } else if (temp == 6) {
                    finalSolos.get(i).setFinalscore(6.0);
                } else if (temp == 7) {
                    finalSolos.get(i).setFinalscore(3.0);
                } else {
                    finalSolos.get(i).setFinalscore(0.0);
                }
            } else {
                if (temp == 1) {
                    finalSolos.get(i).setFinalscore(21.0);
                } else if (temp == 2) {
                    finalSolos.get(i).setFinalscore(18.0);
                } else if (temp == 3) {
                    finalSolos.get(i).setFinalscore(15.0);
                } else if (temp == 4) {
                    finalSolos.get(i).setFinalscore(12.0);
                } else if (temp == 5) {
                    finalSolos.get(i).setFinalscore(9.0);
                } else if (temp == 6) {
                    finalSolos.get(i).setFinalscore(6.0);
                } else if (temp == 7) {
                    finalSolos.get(i).setFinalscore(3.0);
                } else {
                    finalSolos.get(i).setFinalscore(0.0);
                }
            }
        }
        return finalSolos;
    }

    private static List<Solo> setScore(List<Solo> solos0, int isYaan) {

        List<ScoreInterface> solos=new ArrayList<>();
        for (int i = 0; i < solos0.size(); i++) {
            solos.add(solos0.get(i));
        }

        int indexStart = 0;
        int len = solos.size();
        for (int i = 0; i < len; i++) {
            //last
            if (i == len - 1) {
                //last == last-1
                if (solos.get(i - 1).getScore().equals(solos.get(i).getScore())) {
                    //TODO add indexStart avg to last
                    addGrade(solos,indexStart,len,isYaan);
                } else {
                    //TODO add avg indexStart to i-1
                    addGrade(solos,indexStart,i,isYaan);
                    //TODO add avg last
                    addGrade(solos,len-1,len,isYaan);
                }
                break;
            }

            //i==i+1
            if (solos.get(i).getScore().equals(solos.get(i + 1).getScore())) {
                continue;
            } else {
                //TODO add indexStart to i
                addGrade(solos,indexStart,i+1,isYaan);
                indexStart = i + 1;
            }

        }

        List<Solo> soloList=new ArrayList<>();
        for (int i = 0; i < solos.size(); i++) {
            soloList.add((Solo)solos.get(i));
        }
        return soloList;
    }

    //加分
    private static void addGrade(List<ScoreInterface> source, int start, int end, int isYan) {
        for (int i = start; i < end; i++) {
            if (isYan == 1)
                source.get(i).setGrade(ScoreUtil.getAvgYaAndCheng(start, end));
            else if(isYan==10)
                source.get(i).setGrade(ScoreUtil.getAvgFinle(start,end));
            else
                source.get(i).setGrade(ScoreUtil.getAvgDuJiangYan(start, end));
        }
    }

    //加分
    private static void addFinalGrade(List<FinalSolo> source, int start, int end) {
        for (int i = start; i < end; i++) {
                source.get(i).setGrade(ScoreUtil.getAvgFinle(start,end));
        }
    }

    public static void main(String[] args) {

        List<Solo> soloList = new ArrayList<>();

        Solo solo = new Solo();
        solo.setScore("8.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("8.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("7.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("6.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("5.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("5.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("4.00");
        soloList.add(solo);

        solo = new Solo();
        solo.setScore("4.00");
        soloList.add(solo);

        List<Solo> count = countUtil(soloList);

        for (Solo  s :
                count) {
            System.out.println(s.getGrade());
        }
    }

}
