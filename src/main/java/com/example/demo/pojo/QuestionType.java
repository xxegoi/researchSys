package com.example.demo.pojo;

public enum QuestionType {

    Choose("单选题",1),Multiple("多选题",2),Fill("填空/问答题",3);

    private String title;
    private int index;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    QuestionType(String s, int i) {
        this.title=s;
        this.index=i;
    }

    public static QuestionType GetTypeById(int id){
        for (QuestionType type:QuestionType.values()){
            if(type.getIndex()==id){
                return type;
            }
        }
        return null;
    }

    public static QuestionType GetTypeByName(String str){
        for(QuestionType type:QuestionType.values()){
            if(type.getTitle().equals(str)){
                return type;
            }
        }
        return null;
    }
}
