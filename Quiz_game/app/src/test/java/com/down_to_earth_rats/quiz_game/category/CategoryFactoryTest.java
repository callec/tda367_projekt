package com.down_to_earth_rats.quiz_game.category;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Erik Blomberg
 *
 */

public class CategoryFactoryTest {

    @Test
    public void sameInstance() {
        ICategoryHandler handler1 = CategoryFactory.getDefaultHandler();
        ICategoryHandler handler2 = CategoryFactory.getDefaultHandler();

        assertEquals(handler1, handler2);
    }

    @Test
    public void handlerHasCategories() {

        ICategoryHandler handler = CategoryFactory.getDefaultHandler();
        Iterator<ICategory> iterator = handler.getAllCategories();
        assertTrue(iterator.hasNext());

    }
}