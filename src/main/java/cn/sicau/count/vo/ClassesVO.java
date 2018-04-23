package cn.sicau.count.vo;

/**
 * @author yelei
 * @date 18-4-11
 */
public class ClassesVO {
    Integer id;
    String campus;//校区
    String classes;//学院
    Integer rank;//排名
    Double grade;//总分

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "ClassesVO{" +
                "id=" + id +
                ", campus='" + campus + '\'' +
                ", classes='" + classes + '\'' +
                ", rank=" + rank +
                ", grade=" + grade +
                '}';
    }
}
