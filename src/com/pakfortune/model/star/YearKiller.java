package com.pakfortune.model.star;

import com.google.common.collect.Maps;
import com.pakfortune.common.FiveTigerHop;
import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

import java.util.Map;

public enum YearKiller {
    ;
    private static final Map<String, String> map = Maps.newHashMap();

    static {
        map.put("申", "未");
        map.put("子", "未");
        map.put("辰", "未");
        map.put("巳", "辰");
        map.put("酉", "辰");
        map.put("丑", "辰");
        map.put("寅", "丑");
        map.put("午", "丑");
        map.put("戌", "丑");
        map.put("亥", "戌");
        map.put("卯", "戌");
        map.put("未", "戌");
    }

    public static String calculate(String input) {
        String [] arr = input.split("(?!^)");
        String tempStem = Stem.valueOf(arr[0]).name();
        String tempBranch = Branch.valueOf(arr[1]).name();
        String branchKillerLocation = map.get(tempBranch);

        int branchOrdinal = Branch.valueOf(branchKillerLocation).ordinal();
        int numOfJump = (FiveTigerHop.hop(tempStem).ordinal() +
                        ((branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + branchKillerLocation;
    }
}
