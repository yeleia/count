package cn.sicau.count.vo;

/**
 * @author yelei
 * @date 18-4-8
 */
public class FinalSoloVO {
    private Integer id;//决赛id
    private Integer rank;//排名
    private String stuName;//学生姓名
    private String stuNumber;//学号
    private String classes;//学院
    private String profession;//专业
    private String  score;//成绩

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

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getClasses() {
        return classes;
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

    public String  getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
