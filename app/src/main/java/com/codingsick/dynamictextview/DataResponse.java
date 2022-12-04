package com.codingsick.dynamictextview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DataResponse {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {

        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



public class CreatedBy {

    @SerializedName("$oid")
    @Expose
    private String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

}



public static class Data {

    @SerializedName("_id")
    @Expose
    private Id id;
    @SerializedName("find_hint")
    @Expose
    private String findHint;
    @SerializedName("subject")
    @Expose
    private Subject subject;
    @SerializedName("marks_positive")
    @Expose
    private String marksPositive;
    @SerializedName("marks_negative")
    @Expose
    private String marksNegative;
    @SerializedName("question_type")
    @Expose
    private String questionType;
    @SerializedName("font")
    @Expose
    private String font;
    @SerializedName("created")
    @Expose
    private Integer created;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_by")
    @Expose
    private CreatedBy createdBy;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("q_lang")
    @Expose
    private String qLang;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("opt1")
    @Expose
    private String opt1;
    @SerializedName("opt2")
    @Expose
    private String opt2;
    @SerializedName("opt3")
    @Expose
    private String opt3;
    @SerializedName("opt4")
    @Expose
    private String opt4;
    @SerializedName("ans")
    @Expose
    private String ans;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getFindHint() {
        return findHint;
    }

    public void setFindHint(String findHint) {
        this.findHint = findHint;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getMarksPositive() {
        return marksPositive;
    }

    public void setMarksPositive(String marksPositive) {
        this.marksPositive = marksPositive;
    }

    public String getMarksNegative() {
        return marksNegative;
    }

    public void setMarksNegative(String marksNegative) {
        this.marksNegative = marksNegative;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public String getqLang() {
        return qLang;
    }

    public void setqLang(String qLang) {
        this.qLang = qLang;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

}


public class Id {

    @SerializedName("$oid")
    @Expose
    private String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

}

public class Subject {

    @SerializedName("$oid")
    @Expose
    private String $oid;

    public String get$oid() {
        return $oid;
    }

    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

}
}