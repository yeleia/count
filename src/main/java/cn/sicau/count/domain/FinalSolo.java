package cn.sicau.count.domain;

public class FinalSolo {
    private Integer id;

    private Integer soloid;

    private Double secscore;

    private Double finalscore;

    private Integer finalgrade;

    public FinalSolo(Integer id, Integer soloid, Double secscore, Double finalscore, Integer finalgrade) {
        this.id = id;
        this.soloid = soloid;
        this.secscore = secscore;
        this.finalscore = finalscore;
        this.finalgrade = finalgrade;
    }

    public FinalSolo() {
        super();
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

    public Double getSecscore() {
        return secscore;
    }

    public void setSecscore(Double secscore) {
        this.secscore = secscore;
    }

    public Double getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(Double finalscore) {
        this.finalscore = finalscore;
    }

    public Integer getFinalgrade() {
        return finalgrade;
    }

    public void setFinalgrade(Integer finalgrade) {
        this.finalgrade = finalgrade;
    }
}