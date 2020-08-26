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

    private final String information;

    Money(String information) {
        this.information = information;
    }

    private String getInformation() {
        return this.information;
    }

    public static String calculate(String input) {
        String[] arr = input.split("(?!^)");
        return Money.valueOf(arr[0]).getInformation();
    }
}
