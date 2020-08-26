package com.pakfortune.model.star;

import com.google.common.collect.Maps;
import com.pakfortune.common.FiveTigerHop;
import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

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
