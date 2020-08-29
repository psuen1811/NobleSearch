package com.pakfortune.common;

import com.google.common.base.Enums;

public class LookupImpl implements LookupInterface {

    @Override
    public <E extends Enum<E>> E getIfPresent(Class<E> clazz, String name) {
        return Enums.getIfPresent(clazz, name).orNull();
    }
}
