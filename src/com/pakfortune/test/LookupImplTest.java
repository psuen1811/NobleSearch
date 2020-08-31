package com.pakfortune.test;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;
import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.Money;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class LookupImplTest {

    private final LookupInterface lookup = new LookupImpl();

    @Test
    void getIfPresent() {
        String result = lookup.getIfPresent(Money.class, "庚").name();
        Assert.assertEquals(result, "庚");
    }

    @Test
    void ifStemBranchInputExists() {
        //boolean result = lookup.ifStemBranchInputExists(SixtyJiaziTable.class, "己亥");
        boolean result = lookup.ifStemBranchInputExists(SixtyJiaziTable.class, "甲丑");
        Assert.assertFalse(result);
        // Assert.assertTrue(result);
    }

    @Test
    void findByValue() {
        Direction c = lookup.findByValue(Direction.class, 3);
        Assert.assertEquals(c.name(), "艮");
    }
}