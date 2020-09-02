package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  沐浴
 */
@SuppressWarnings("NonAsciiCharacters")
public enum Shower {
    甲("子"),
    乙("巳"),
    丙("卯"),
    丁("申"),
    戊("卯"),
    己("申"),
    庚("午"),
    辛("亥"),
    壬("酉"),
    癸("寅");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    Shower(final String information) {
        this.information = information;
    }

    private String getInformation() {
        return this.information;
    }

    public static String calculate(String stem) {
        return lookup.getIfPresent(Shower.class, stem).getInformation();
    }
}
