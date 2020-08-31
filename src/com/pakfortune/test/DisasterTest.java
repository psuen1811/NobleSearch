package com.pakfortune.test;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;
import com.pakfortune.model.star.Disaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DisasterTest {

    private final LookupInterface lookup = new LookupImpl();

    @Test
    void calculate() {
        String result = lookup.getIfPresent(Disaster.class, "卯").getInformation();
        Assert.assertEquals(result, "酉");

    }
}