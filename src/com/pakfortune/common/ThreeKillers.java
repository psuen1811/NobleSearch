package com.pakfortune.common;

import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

import java.util.Map;

/*
 真三煞計算
 */
public class ThreeKillers {

    public static String calculate(String input, Map<String, String> lookup) {
        String[] arr = input.split("(?!^)");
        String tempStem = Stem.getIfPresent(arr[0]).toString();
        String tempBranch = Branch.getIfPresent(arr[1]).toString();
        String location = lookup.get(tempBranch);

        // 取地支序數
        int branchOrdinal = Branch.getIfPresent(location).ordinal();
        // 由序數計算飛遁天干
        int numOfJump = (FiveTigerHop.hop(tempStem).ordinal() +
                ((branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + location;
    }
}
