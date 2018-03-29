package cn.sicau.count.domain;

public class TwoLevel {
    private Integer id;

    private String levelpro;

    private Double levelscore;

    private String levelsex;

    public TwoLevel(Integer id, String levelpro, Double levelscore, String levelsex) {
        this.id = id;
        this.levelpro = levelpro;
        this.levelscore = levelscore;
        this.levelsex = levelsex;
    }

    public TwoLevel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelpro() {
        return levelpro;
    }

    public void setLevelpro(String levelpro) {
        this.levelpro = levelpro == null ? null : levelpro.trim();
    }

    public Double getLevelscore() {
        return levelscore;
    }

    public void setLevelscore(Double levelscore) {
        this.levelscore = levelscore;
    }

    public String getLevelsex() {
        return levelsex;
    }

    public void setLevelsex(String levelsex) {
        this.levelsex = levelsex == null ? null : levelsex.trim();
    }
}