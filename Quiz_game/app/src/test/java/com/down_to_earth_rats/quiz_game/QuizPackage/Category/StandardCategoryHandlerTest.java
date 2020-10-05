package com.down_to_earth_rats.quiz_game.QuizPackage.Category;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class StandardCategoryHandlerTest {

    ICategoryHandler categoryHandler;

    @Before
    public void setUp() {
        categoryHandler = new StandardCategoryHandler();
    }


    @Test
    public void checkSize() {
        Iterator<ICategory> categoryIterator = categoryHandler.getAllCategories();
        int counter = 0;
        while(categoryIterator.hasNext()){
            counter++;
        }
        assertNotEquals(0, counter);

    }

    @Test
    public void getFirstCategory() {
        Iterator<ICategory> categoryIterator = categoryHandler.getAllCategories();
        categoryIterator.hasNext();

        ICategory category = categoryIterator.next();

        assertNotNull(category);
    }

    @Test
    public void checkSubCategories() {
        Iterator<ICategory> categoryIterator = categoryHandler.getAllCategories();
        if(categoryIterator.hasNext()){
            ICategory category = categoryIterator.next();
            Iterator<String> subCategoryIterator = category.getSubCategories();
            assertTrue(subCategoryIterator.hasNext());
        }else{
            fail();
        }


    }
}