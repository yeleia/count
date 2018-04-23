package cn.sicau.count.utils;

/**
 * @author yelei
 * @date 18-4-6
 */
public class Page {
    Integer id;
    Integer tempPage;//当前页数
    Integer pageCapacity;//每页显示的数据量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTempPage() {
        return tempPage;
    }

    public void setTempPage(Integer tempPage) {
        this.tempPage = tempPage;
    }

    public Integer getPageCapacity() {
        return pageCapacity;
    }

    public void setPageCapacity(Integer pageCapacity) {
        this.pageCapacity = pageCapacity;
    }
}
