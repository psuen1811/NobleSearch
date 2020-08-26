package com.pakfortune.model.star;

@SuppressWarnings({"NonAsciiCharacters", "unused"})
public enum Money {
    甲("丙寅"),
    乙("己卯"),
    丙("癸巳"),
    丁("丙午"),
    戊("丁巳"),
    己("庚午"),
    庚("甲申"),
    辛("丁酉"),
    壬("辛亥"),
    癸("甲子");

    private final String moneyResult;

    Money(String moneyResult) {
        this.moneyResult = moneyResult;
    }

    private String getMoneyResult() {
        return this.moneyResult;
    }

    public static String calculate(String input) {
        String [] arr = input.split("(?!^)");
        return Money.valueOf(arr[0]).getMoneyResult();
    }
}
