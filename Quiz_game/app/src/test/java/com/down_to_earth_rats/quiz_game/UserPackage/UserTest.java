package com.down_to_earth_rats.quiz_game.UserPackage;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    ResultObject testresultObject;

    @Before
    public void setUp(){
        testresultObject = new ResultObject(4,2,"Addition");
    }

    @Test
    public void testGetSubcategory(){
        assertEquals("Addition", testresultObject.getSubcategory());
    }

    @Test
    public void testGetCorrectAnswers(){
        assertEquals(2, testresultObject.getCorrectAnswers());
    }

    @Test
    public void testGetTotalQuestions(){
        assertEquals(4, testresultObject.getTotalQuestions());
    }


    @Test
    public void testAddResultGetStatistics(){
        /*User.getInstance().addResult(testresultObject);
        ArrayList<ResultObject> testlist = User.getInstance().getStatistics("Addition"); //TODO
        assertTrue(!testlist.isEmpty());*/
    }
}
