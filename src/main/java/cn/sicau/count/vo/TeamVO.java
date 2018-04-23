package cn.sicau.count.vo;

/**
 * @author yelei
 * @date 18-4-19
 */
public class TeamVO {
    private String teamcampus;

    private String teamproject;

    private String teamclass;

    private String teamprofession;

    private Double teamscore;

    private Integer teamgrade;
    private String id;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTeamcampus() {
        return teamcampus;
    }

    public void setTeamcampus(String teamcampus) {
        this.teamcampus = teamcampus;
    }

    public String getTeamproject() {
        return teamproject;
    }

    public void setTeamproject(String teamproject) {
        this.teamproject = teamproject;
    }

    public String getTeamclass() {
        return teamclass;
    }

    public void setTeamclass(String teamclass) {
        this.teamclass = teamclass;
    }

    public String getTeamprofession() {
        return teamprofession;
    }

    public void setTeamprofession(String teamprofession) {
        this.teamprofession = teamprofession;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
