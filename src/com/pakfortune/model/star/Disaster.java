package com.pakfortune.model.star;

import com.google.common.collect.Maps;
import com.pakfortune.common.FiveTigerHop;
import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

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

    public static String calculate(String input) {
        String [] arr = input.split("(?!^)");
        String tempStem = Stem.valueOf(arr[0]).name();
        String tempBranch = Branch.valueOf(arr[1]).name();
        String location = lookup.get(tempBranch);

        // 取地支序數
        int branchOrdinal = Branch.valueOf(location).ordinal();
        // 由序數計算飛遁天干
        int numOfJump = (FiveTigerHop.hop(tempStem).ordinal() +
                ((branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + location;
    }
}
