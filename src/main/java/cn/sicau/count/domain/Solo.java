package cn.sicau.count.domain;

public class Solo {
    private Integer id;

    private String campus;

    private String classes;

    private String project;

    private String username;

    private String usernumber;

    private Double score;

    private Integer grade;

    public Solo(Integer id, String campus, String classes, String project, String username, String usernumber, Double score, Integer grade) {
        this.id = id;
        this.campus = campus;
        this.classes = classes;
        this.project = project;
        this.username = username;
        this.usernumber = usernumber;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}