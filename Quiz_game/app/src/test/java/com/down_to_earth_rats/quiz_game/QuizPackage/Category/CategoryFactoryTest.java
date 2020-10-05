package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CategoryFactoryTest {



    @Test
    public void sameInstance() {
        ICategoryHandler handler1 = CategoryFactory.getStandardHandler();
        ICategoryHandler handler2 = CategoryFactory.getStandardHandler();

        assertEquals(handler1, handler2);
    }

    @Test
    public void handlerHasCategories() {

        ICategoryHandler handler = CategoryFactory.getStandardHandler();
        Iterator<ICategory> iterator = handler.getAllCategories();
        assertTrue(iterator.hasNext());

    }
}