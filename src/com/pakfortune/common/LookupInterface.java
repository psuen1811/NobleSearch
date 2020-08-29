package com.pakfortune.common;

public interface LookupInterface {

    <E extends Enum<E>> E getIfPresent(Class<E> clazz, String name);
}
