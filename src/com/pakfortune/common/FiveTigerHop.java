package com.pakfortune.common;

import com.pakfortune.model.element.Stem;

// 五虎遁
public class FiveTigerHop {

    private static final LookupInterface lookup = new LookupImpl();

    public static Stem hop(String input) {
        String s = null;
        if (input.equals("甲") || input.equals("己"))
            s = "丙";
        if (input.equals("乙") || input.equals("庚"))
            s = "戊";
        if (input.equals("丙") || input.equals("辛"))
            s = "庚";
        if (input.equals("丁") || input.equals("壬"))
            s = "壬";
        if (input.equals("戊") || input.equals("癸"))
            s = "甲";
        return lookup.getIfPresent(Stem.class, s);
    }
}
