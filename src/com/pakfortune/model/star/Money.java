package com.pakfortune.model.star;

import com.google.common.base.Enums;

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

    Money(final String information) {
        this.information = information;
    }

    private String getInformation() {
        return this.information;
    }

    public static String calculate(String stem) {
        return getIfPresent(stem).getInformation();
    }

    public static Money getIfPresent(String name) {
        return Enums.getIfPresent(Money.class, name).orNull();
    }
}
