package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/*
 歲煞的歌诀为
 申子辰煞在未, 巳酉丑煞在辰, 寅午戌煞在丑, 亥卯未煞在未
 */
public enum YearKiller {
    ;
    private static final Map<String, String> lookup = Maps.newHashMap();

    static {
        lookup.put("申", "未");
        lookup.put("子", "未");
        lookup.put("辰", "未");
        lookup.put("巳", "辰");
        lookup.put("酉", "辰");
        lookup.put("丑", "辰");
        lookup.put("寅", "丑");
        lookup.put("午", "丑");
        lookup.put("戌", "丑");
        lookup.put("亥", "戌");
        lookup.put("卯", "戌");
        lookup.put("未", "戌");
    }

    public static Map<String, String> getLookup() {
        return ImmutableMap.copyOf(lookup);
    }
}
