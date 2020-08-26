package com.pakfortune.model.star;

import com.google.common.collect.Maps;
import com.pakfortune.common.FiveTigerHop;
import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

import java.util.Map;

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

    public static String calculate(String input) {
        String [] arr = input.split("(?!^)");
        String tempStem = Stem.valueOf(arr[0]).name();
        String tempBranch = Branch.valueOf(arr[1]).name();
        String branchKillerLocation = lookup.get(tempBranch);

        // 取地支序數
        int branchOrdinal = Branch.valueOf(branchKillerLocation).ordinal();
        // 由序數計算飛遁天干
        int numOfJump = (FiveTigerHop.hop(tempStem).ordinal() +
                        ((branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + branchKillerLocation;
    }
}
