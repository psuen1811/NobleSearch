package com.pakfortune;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import java.util.List;

public enum Richman {
    // empty enum
    ;
    /* use Google Guava ArrayListMultimap instead of building individual list per enum */
    private static final ArrayListMultimap<String, String> list = ArrayListMultimap.create();

    static {
        list.put("甲", "丁丑");
        list.put("甲", "辛未");
        list.put("乙", "甲申");
        list.put("乙", "戊子");
        list.put("丙", "丁酉");
        list.put("丙", "己亥");
        list.put("丁", "己酉");
        list.put("丁", "辛亥");
        list.put("戊","乙丑");
        list.put("戊","己未");
        list.put("己","丙子");
        list.put("己","壬申");
        list.put("庚","己丑");
        list.put("庚","癸未");
        list.put("辛","甲午");
        list.put("辛","庚寅");
        list.put("壬","乙巳");
        list.put("壬","癸卯");
        list.put("癸","乙卯");
        list.put("癸","丁巳");
    }

    public static List<String> calculate(String input) {
        // 取天干
        String s = null;
        for( Stem stem : Stem.values()) {
            if( input.contains(stem.name()) )
                s = stem.name();
        }
        for( String stem : list.keySet() ) {
            if( stem.equals(Preconditions.checkNotNull(s)) ) return list.get(s);
        }
        return null;
    }
}
