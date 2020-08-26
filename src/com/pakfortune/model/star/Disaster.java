package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/*
 灾煞的歌诀为
 申子辰见午, 亥卯未见酉, 寅午戌见子, 巳酉丑见卯
*/
public enum Disaster {
    ;
    private static final Map<String, String> lookup = Maps.newHashMap();

    static {
        lookup.put("申", "午");
        lookup.put("子", "午");
        lookup.put("辰", "午");
        lookup.put("亥", "酉");
        lookup.put("卯", "酉");
        lookup.put("未", "酉");
        lookup.put("寅", "子");
        lookup.put("午", "子");
        lookup.put("戌", "子");
        lookup.put("巳", "卯");
        lookup.put("酉", "卯");
        lookup.put("丑", "卯");
    }

    public static Map<String, String> getLookup() {
        return ImmutableMap.copyOf(lookup);
    }
}
