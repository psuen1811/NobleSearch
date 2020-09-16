package com.pakfortune.test;

import com.google.common.collect.Lists;
import com.pakfortune.common.CircularArrayList;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;
import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class NobleSearchServiceTest {

    private final LookupInterface lookup = new LookupImpl();

    @Test
    void getYearlyResult() {
        ArrayList<Integer> arrayList = Lists.newArrayList(SixtyJiaziTable.getSixJiaziList());
        //noinspection rawtypes
        @SuppressWarnings("unchecked") CircularArrayList circularArrayList = new CircularArrayList(arrayList);
        circularArrayList.shiftRight(lookup.getIfPresent(SixtyJiaziTable.class, "癸亥").ordinal());

        int temp = lookup.getIfPresent(SixtyJiaziTable.class, "甲子").ordinal();
        int index = (Integer) circularArrayList.get(temp) % 9;
        String result = lookup.findByValue(Direction.class, index).name();
        Assert.assertEquals("乾", result);
    }
}