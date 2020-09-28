package com.down_to_earth_rats.quiz_game.Model.Utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg
 *
 *
 * This is a general iterator based on the already existing Java Iterator interface.
 * The class will accept any type of List.
 *
 * Be aware! Only call next() when hasNext() has returned true
 * @param <T> The type parameter of the List interface
 */

public class ListIterator<T> implements Iterator<T> {

    private List<T> list = new ArrayList<>();

    private int position = -1;

    public ListIterator(List<T> list) {
        this.list.addAll(list);
    }

    @Override
    public boolean hasNext() {
        return ++position < list.size();
    }

    @Override
    public T next() {
        return list.get(position);
    }
}
