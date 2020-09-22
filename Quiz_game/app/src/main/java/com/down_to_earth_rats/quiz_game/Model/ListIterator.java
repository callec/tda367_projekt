package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ListIterator<T> implements Iterator<T> {

    private List<T> list = new ArrayList<>();

    private int pos = -1;

    public ListIterator(List<T> list) {
        this.list.addAll(list);
    }

    @Override
    public boolean hasNext() {
        return ++pos < list.size();
    }

    @Override
    public T next() {
        return list.get(pos);
    }
}
