package com.pakfortune;

import java.util.*;

public class NobleSearch {

    public static void main(String[] arg) {
        ArrayList<Integer> arrayList = new ArrayList<>(SixtyJiaziTable.getSixJiaziList());
        Calculate calculate = new Calculate(arrayList);
        calculate.getYearlyResult();
        calculate.getMonthlyResult(arrayList);
    }
}
