package com.down_to_earth_rats.quiz_game.Category;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Erik Blomberg
 *
 */

public class ImmutableCategoryTest {


    private ICategory category;

    private String name = "TestTest";

    private String sub1 = "First";
    private String sub2 = "Second";
    private String sub3 = "Third";

    @Before
    public void setUp() {
        category = new ImmutableCategory(name, sub1, sub2, sub3);
    }

    @Test
    public void getCategoryName() {
        String returnName = category.getCategoryName();
        assertEquals(name, returnName);
    }

    @Test
    public void getFirstSubCategory() {
        Iterator<String> iterator = category.getSubCategories();
        if(iterator.hasNext()){
            assertEquals(sub1, iterator.next());
        }else{
            fail();
        }
    }

    @Test
    public void getLastSubCategory() {
        Iterator<String> iterator = category.getSubCategories();
        for (int i = 0; i < 2; i++) {
            iterator.hasNext();
        }

        if(iterator.hasNext()){
            assertEquals(sub3, iterator.next());
        }else{
            fail();
        }
    }
}