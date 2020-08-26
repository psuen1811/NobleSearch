package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/*
 劫煞的歌诀为：
 申子辰见巳，亥卯未见申，寅午戌见亥，巳酉丑见寅
 */
public enum RobKiller {
    ;
    private static final Map<String, String> lookup = Maps.newHashMap();

    static {
        lookup.put("申", "巳");
        lookup.put("子", "巳");
        lookup.put("辰", "巳");
        lookup.put("亥", "申");
        lookup.put("卯", "申");
        lookup.put("未", "申");
        lookup.put("寅", "亥");
        lookup.put("午", "亥");
        lookup.put("戌", "亥");
        lookup.put("巳", "寅");
        lookup.put("酉", "寅");
        lookup.put("丑", "寅");
    }

    public static Map<String, String> getLookup() {
        return ImmutableMap.copyOf(lookup);
    }
}
