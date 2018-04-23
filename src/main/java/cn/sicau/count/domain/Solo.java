package cn.sicau.count.domain;

import cn.sicau.count.utils.ScoreInterface;
import cn.sicau.count.utils.TimeUtil;

public class Solo implements ScoreInterface{

    private Integer id;

    private String campus;

    private String classes;

    private String project;

    private String profession;

    private String username;

    private String usernumber;

    private String usersex;

    private String score;

    //TODO chenge to double
    private Double grade;

    public Solo(Integer id, String campus, String classes, String project, String profession, String username, String usernumber, String usersex, String score, Double grade) {
        this.id = id;
        this.campus = campus;
        this.classes = classes;
        this.project = project;
        this.profession = profession;
        this.username = username;
        this.usernumber = usernumber;
        this.usersex = usersex;
        this.score = score;
        this.grade = grade;
    }

    public Solo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus == null ? null : campus.trim();
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsernumber() {
        return usernumber;
    }

    public void setUsernumber(String usernumber) {
        this.usernumber = usernumber == null ? null : usernumber.trim();
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex == null ? null : usersex.trim();
    }

    @Override
    public void setGrade(double grade) {
        this.grade=grade;
    }

    @Override
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = TimeUtil.get8bitTime(score);
    }

    public Double getGrade() {
        return grade;
    }

}