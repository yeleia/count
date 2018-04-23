package cn.sicau.count.domain;

public class Abstain {
    private Integer id;

    private String campus;

    private String classes;

    private Integer counts;

    public Abstain(Integer id, String campus, String classes, Integer counts) {
        this.id = id;
        this.campus = campus;
        this.classes = classes;
        this.counts = counts;
    }

    public Abstain() {
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

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}