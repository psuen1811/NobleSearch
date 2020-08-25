package com.pakfortune;

import com.google.common.collect.Lists;
import com.pakfortune.model.element.SixtyJiaziTable;

import java.util.*;

public class NobleSearch {

    public static void main(String[] arg) {
        // declare 60 lunar "六十甲子"" by sequence
        ArrayList<Integer> arrayList = Lists.newArrayList(SixtyJiaziTable.getSixJiaziList());

        // initialize CircularArrayList for shifting elements purpose
        Calculate calculate = new Calculate(arrayList);
        calculate.getYearlyResult();
        calculate.getMonthlyResult(arrayList);
    }
}
