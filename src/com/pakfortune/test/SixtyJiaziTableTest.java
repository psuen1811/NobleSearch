package com.pakfortune.test;

import com.pakfortune.model.element.SixtyJiaziTable;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class SixtyJiaziTableTest {

    private static final List<Integer> values = Arrays.stream(SixtyJiaziTable.values())
            .map(Enum::ordinal)
            .collect(Collectors.toList());
    @Test
    void getSixJiaziList() {
        // Assert.assertEquals(java.util.Optional.of(values.get(63)), java.util.Optional.of(63));
        Assert.assertEquals(java.util.Optional.of(values.get(59)), java.util.Optional.of(59));

    }
}