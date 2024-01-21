package com.StudyGo.model;

public enum MonthEnum {
    JANUARY(1, "January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    private final int monthValue;
    private final String monthName;

    MonthEnum(int monthValue, String monthName) {
        this.monthValue = monthValue;
        this.monthName = monthName;
    }

    public int getMonthValue() {
        return monthValue;
    }

    public String getMonthName() {
        return monthName;
    }

    public static MonthEnum fromMonthValue(int monthValue) {
        for (MonthEnum month : MonthEnum.values()) {
            if (month.getMonthValue() == monthValue) {
                return month;
            }
        }
        throw new IllegalArgumentException("Invalid month value: " + monthValue);
    }
}

