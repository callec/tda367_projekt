package com.down_to_earth_rats.quiz_game.Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ListIteratorTest {

    private List<String> list;

    ListIterator<String> iterator;

    private String first = "First";
    private String second = "Second";
    private String third = "Third";

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        iterator = new ListIterator<>(list);
    }

    @Test
    public void correctOrder() {

        iterator.hasNext();
        assertEquals(first, iterator.next());

        iterator.hasNext();
        assertEquals(second, iterator.next());

        iterator.hasNext();
        assertEquals(third, iterator.next());
    }

    @Test
    public void correctSize() {
        int counter = 0;

        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(list.size(), counter);
    }

    @Test
    public void exceedLimit() {


        for (int i = 0; i < list.size(); i++) {
            iterator.hasNext();
        }

        boolean condition = iterator.hasNext();

        assertFalse(condition);

    }

    @Test
    public void zeroElements() {
        List<String> list2 = new ArrayList<>();
        ListIterator<String> iterator2 = new ListIterator<>(list2);

        boolean condition = iterator2.hasNext();
        assertFalse(condition);
    }

    @Test
    public void listAlias() {
        int listSize = list.size();

        list.add("Test!");
        list.add("Again!");

        int counter = 0;

        while(iterator.hasNext()){
            counter++;
        }

        assertEquals(listSize, counter);


    }
}