package com.pakfortune.model.star;

import com.google.common.base.Enums;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

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
    private static final LookupInterface lookup = new LookupImpl();

    Study(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String stem) {
        return lookup.getIfPresent(Study.class, stem).getInformation();
    }

}
