package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private List<String> list;
    private String first = "First";
    private String second = "Second";
    private String third = "Third";
    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
    }

    @Test
    public void correctOrder() {


        ListIterator<String> iterator = new ListIterator<>(list);

        iterator.hasNext();
        assertEquals(first, iterator.next());

        iterator.hasNext();
        assertEquals(second, iterator.next());

        iterator.hasNext();
        assertEquals(third, iterator.next());
    }

    @Test
    public void exceedLimit() {

        ListIterator<String> iterator = new ListIterator<>(list);

        for (int i = 0; i < list.size(); i++) {
            iterator.hasNext();
        }

        boolean condition = iterator.hasNext();

        assertFalse(condition);

    }

    @Test
    public void zeroElements() {
        List<String> list2 = new ArrayList<>();
        ListIterator<String> iterator = new ListIterator<>(list2);

        boolean condition = iterator.hasNext();
        assertFalse(condition);
    }
}