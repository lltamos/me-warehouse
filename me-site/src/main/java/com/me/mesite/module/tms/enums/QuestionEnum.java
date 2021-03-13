package com.me.mesite.module.tms.enums;

public enum QuestionEnum {
    SINGLE_CHOICE("选择题", 0),
    MULTIPLE_CHOICE("多选题", 1),
    VERDICT("判断题", 2),//判断
    INTERPOSE("填空题", 3),//填空
    SHORT_ANSWER("简答题", 4),
    GROUP_QUESTION("组合题", 5);

    QuestionEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }


    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static String getVal(int value) {
        for (QuestionEnum ele : values()) {
            if (ele.getValue() == value) return ele.getName();
        }
        return null;
    }

}
