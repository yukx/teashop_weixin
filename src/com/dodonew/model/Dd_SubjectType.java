package com.dodonew.model;

public class Dd_SubjectType {
    private String subjectID;

    private String subjectName;

    private Integer displayInPortal;

    private String en_subjectName;

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID == null ? null : subjectID.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public Integer getDisplayInPortal() {
        return displayInPortal;
    }

    public void setDisplayInPortal(Integer displayInPortal) {
        this.displayInPortal = displayInPortal;
    }

    public String getEn_subjectName() {
        return en_subjectName;
    }

    public void setEn_subjectName(String en_subjectName) {
        this.en_subjectName = en_subjectName == null ? null : en_subjectName.trim();
    }
}