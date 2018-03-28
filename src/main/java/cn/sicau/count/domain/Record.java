package cn.sicau.count.domain;

public class Record {
    private Integer id;

    private String reproject;

    private Double record;

    public Record(Integer id, String reproject, Double record) {
        this.id = id;
        this.reproject = reproject;
        this.record = record;
    }

    public Record() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReproject() {
        return reproject;
    }

    public void setReproject(String reproject) {
        this.reproject = reproject == null ? null : reproject.trim();
    }

    public Double getRecord() {
        return record;
    }

    public void setRecord(Double record) {
        this.record = record;
    }
}