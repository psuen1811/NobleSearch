package com.pakfortune;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class CircularArrayList<E> extends ArrayList<E> {
    public CircularArrayList() {
    }

    public CircularArrayList(int size) {
        super(size);
    }

    public CircularArrayList(final List<E> list) {
        super(list);
    }

    public void shiftRight(int shiftSize) {
        int size = this.size();

        Map<Integer, E> temp = new HashMap<>();

        int i = 0;
        while (i < size) {
            int k = (i + shiftSize) % size;

            temp.put(k, this.get(i));
            i++;
        }

        this.clear();
        this.addAll(temp.values());
    }
}
