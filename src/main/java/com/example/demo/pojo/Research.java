package com.example.demo.pojo;

import java.util.Date;
import java.util.List;

public class Research {
    //调查ID
    private int researchId;
    //调查主题
    private String researchTitle;
    //调查开始时间
    private Date researchStart;
    //调查结束时间
    private Date researchEnd;
    //问题列表
    private List<Question> questionList;
    //是否匿名
    private Boolean researchGuest;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
    }

    public Date getResearchStart() {
        return researchStart;
    }

    public void setResearchStart(Date researchStart) {
        this.researchStart = researchStart;
    }

    public Date getResearchEnd() {
        return researchEnd;
    }

    public void setResearchEnd(Date researchEnd) {
        this.researchEnd = researchEnd;
    }


    public Boolean getResearchGuest() {
        return researchGuest;
    }

    public void setResearchGuest(Boolean researchGuest) {
        this.researchGuest = researchGuest;
    }
}
