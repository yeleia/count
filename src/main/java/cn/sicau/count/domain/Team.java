package cn.sicau.count.domain;

public class Team {
    private Integer id;

    private String teamcampus;

    private String teamproject;

    private String teamclass;

    private Double teamscore;

    private Integer teamgrade;

    public Team(Integer id, String teamcampus, String teamproject, String teamclass, Double teamscore, Integer teamgrade) {
        this.id = id;
        this.teamcampus = teamcampus;
        this.teamproject = teamproject;
        this.teamclass = teamclass;
        this.teamscore = teamscore;
        this.teamgrade = teamgrade;
    }

    public Team() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamcampus() {
        return teamcampus;
    }

    public void setTeamcampus(String teamcampus) {
        this.teamcampus = teamcampus == null ? null : teamcampus.trim();
    }

    public String getTeamproject() {
        return teamproject;
    }

    public void setTeamproject(String teamproject) {
        this.teamproject = teamproject == null ? null : teamproject.trim();
    }

    public String getTeamclass() {
        return teamclass;
    }

    public void setTeamclass(String teamclass) {
        this.teamclass = teamclass == null ? null : teamclass.trim();
    }

    public Double getTeamscore() {
        return teamscore;
    }

    public void setTeamscore(Double teamscore) {
        this.teamscore = teamscore;
    }

    public Integer getTeamgrade() {
        return teamgrade;
    }

    public void setTeamgrade(Integer teamgrade) {
        this.teamgrade = teamgrade;
    }
}