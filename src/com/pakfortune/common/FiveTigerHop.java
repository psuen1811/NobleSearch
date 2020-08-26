package com.pakfortune.common;

import com.pakfortune.model.element.Stem;

public class FiveTigerHop {

    public static Stem hop(String input) {
        String s = null;
        if(input.equals("甲") || input.equals("己"))
            s = "丙";
        if(input.equals("乙") || input.equals("庚"))
            s = "戊";
        if(input.equals("丙") || input.equals("辛"))
            s = "庚";
        if(input.equals("") || input.equals("壬"))
            s = "壬";
        if(input.equals("戊") || input.equals("癸"))
            s = "甲";
        return Stem.valueOf(s);
    }
}
