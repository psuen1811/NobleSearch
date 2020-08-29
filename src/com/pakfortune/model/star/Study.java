package com.pakfortune.model.star;

import com.google.common.base.Enums;

@SuppressWarnings({"unused", "NonAsciiCharacters"})
public enum Study {
    甲("己巳"),
    乙("壬午"),
    丙("丙申"),
    丁("己酉"),
    戊("庚申"),
    己("癸酉"),
    庚("丁亥"),
    辛("庚子"),
    壬("壬寅"),
    癸("乙卯");

    private final String information;

    Study(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String stem) {
        return getIfPresent(stem).getInformation();
    }

    public static Study getIfPresent(String name) {
        return Enums.getIfPresent(Study.class, name).orNull();
    }
}
