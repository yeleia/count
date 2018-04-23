package cn.sicau.count.domain;

import cn.sicau.count.utils.ScoreInterface;
import cn.sicau.count.utils.TimeUtil;

public class FinalSolo implements ScoreInterface{
    private Integer id;

    private Integer soloid;

    private String secscore;

    //TODO chenge to doutle
    private Double finalscore;

    //TODO chenge to double
    private Double finalgrade;

    private String finalcampus;

    private String finalclasses;

    private String finalproject;

    private String finalprofession;

    private String stuname;

    private String stunumber;

    private String stusex;

    @Override
    public String getScore(){
        return this.secscore;
    }

    @Override
    public void setGrade(double grade){
        this.finalscore=grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoloid() {
        return soloid;
    }

    public void setSoloid(Integer soloid) {
        this.soloid = soloid;
    }

    public String getSecscore() {
        return secscore;
    }

    public void setSecscore(String secscore) {
        this.secscore = TimeUtil.get8bitTime(secscore);
    }

    public Double getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(Double finalscore) {
        this.finalscore = finalscore;
    }

    public Double getFinalgrade() {
        return finalgrade;
    }

    public void setFinalgrade(Double finalgrade) {
        this.finalgrade = finalgrade;
    }

    public String getFinalcampus() {
        return finalcampus;
    }

    public void setFinalcampus(String finalcampus) {
        this.finalcampus = finalcampus;
    }

    public String getFinalclasses() {
        return finalclasses;
    }

    public void setFinalclasses(String finalclasses) {
        this.finalclasses = finalclasses;
    }

    public String getFinalproject() {
        return finalproject;
    }

    public void setFinalproject(String finalproject) {
        this.finalproject = finalproject;
    }

    public String getFinalprofession() {
        return finalprofession;
    }

    public void setFinalprofession(String finalprofession) {
        this.finalprofession = finalprofession;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStunumber() {
        return stunumber;
    }

    public void setStunumber(String stunumber) {
        this.stunumber = stunumber;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }
}