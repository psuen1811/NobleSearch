package com.pakfortune.model.star;

import com.google.common.base.Enums;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

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
    private static final LookupInterface lookup = new LookupImpl();

    Money(final String information) {
        this.information = information;
    }

    private String getInformation() {
        return this.information;
    }

    public static String calculate(String stem) {
        return lookup.getIfPresent(Money.class, stem).getInformation();
    }
}
