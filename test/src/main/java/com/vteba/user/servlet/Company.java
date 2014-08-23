package com.vteba.user.servlet;

import java.util.List;

public class Company {

    private String        companyName;
    private String        title;
    private Long          number;
    private String        source;
    private String        datetime;
    private Long          reprint;
    private String        summary;
    private String        sourceFile;

    private List<Company> zhengList;
    private List<Company> fuList;
    private List<Company> comList;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Long getReprint() {
        return reprint;
    }

    public void setReprint(Long reprint) {
        this.reprint = reprint;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public List<Company> getZhengList() {
        return zhengList;
    }

    public void setZhengList(List<Company> zhengList) {
        this.zhengList = zhengList;
    }

    public List<Company> getFuList() {
        return fuList;
    }

    public void setFuList(List<Company> fuList) {
        this.fuList = fuList;
    }

    public List<Company> getComList() {
        return comList;
    }

    public void setComList(List<Company> comList) {
        this.comList = comList;
    }

}
