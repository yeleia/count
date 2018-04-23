package cn.sicau.count.vo;

/**
 * @author yelei
 * @date 18-4-7
 */
public class SoloVO {
    private Integer id;//soloid
    private Integer rank;//名次
    private String studentName;//学生姓名
    private String stuNumber;//学生学号
    private String classes;//学院
    private String profession;//专业
    private String score;//成绩
    private String formate;//赛制
    private String project;//项目

    public SoloVO() {
    }

    public SoloVO(Integer id, String studentName, String stuNumber, String classes, String profession, String score, String formate, String project) {
        this.id = id;
        this.studentName = studentName;
        this.stuNumber = stuNumber;
        this.classes = classes;
        this.profession = profession;
        this.score = score;
        this.formate = formate;
        this.project = project;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClasses() {
        return classes;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }
}
