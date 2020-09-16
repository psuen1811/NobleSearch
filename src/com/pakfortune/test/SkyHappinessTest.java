package com.pakfortune.test;

import com.google.common.collect.Lists;
import com.pakfortune.common.CircularArrayList;
import com.pakfortune.common.GetBranchByStem;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;
import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.SkyHappiness;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class SkyHappinessTest {

    private final LookupInterface lookup = new LookupImpl();

    @Test
    void calculate() {
        ArrayList<Integer> arrayList = Lists.newArrayList(SixtyJiaziTable.getSixJiaziList());
        //noinspection rawtypes
        @SuppressWarnings("unchecked") CircularArrayList circularArrayList = new CircularArrayList(arrayList);
        circularArrayList.shiftRight(lookup.getIfPresent(SixtyJiaziTable.class, "庚子").ordinal());

        String location = SkyHappiness.calculate("子");
        String finalLocation = GetBranchByStem.calculate("庚", location);

        int temp = lookup.getIfPresent(SixtyJiaziTable.class, finalLocation).ordinal();
        int index = (Integer) circularArrayList.get(temp) % 9;
        // 真祿馬飛度方向
        Assert.assertEquals(Direction.中, lookup.findByValue(Direction.class, index));
    }

}