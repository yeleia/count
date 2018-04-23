package cn.sicau.count.domain;

import cn.sicau.count.utils.TimeUtil;

public class TwoLevel {
    private Integer id;

    private String levelpro;

    private String levelscore;

    private String levelsex;

    public TwoLevel(Integer id, String levelpro, String levelscore, String levelsex) {
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

    public String getLevelscore() {
        return levelscore;
    }

    public void setLevelscore(String levelscore) {
        this.levelscore = TimeUtil.get8bitTime(levelscore);
    }

    public String getLevelsex() {
        return levelsex;
    }

    public void setLevelsex(String levelsex) {
        this.levelsex = levelsex == null ? null : levelsex.trim();
    }
}