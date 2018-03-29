package cn.sicau.count.domain;

public class Record {
    private Integer id;

    private String reproject;

    private Double record;

    private String recordsex;

    public Record(Integer id, String reproject, Double record, String recordsex) {
        this.id = id;
        this.reproject = reproject;
        this.record = record;
        this.recordsex = recordsex;
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

    public String getRecordsex() {
        return recordsex;
    }

    public void setRecordsex(String recordsex) {
        this.recordsex = recordsex == null ? null : recordsex.trim();
    }
}