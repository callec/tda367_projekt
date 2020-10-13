package com.down_to_earth_rats.quiz_game.UserPackage;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 */

public class UserTest {

    ResultObject testresultObject;

    User user;

    String username = "asd";
    String password = "oooooo";

    @Before
    public void setUp(){
        testresultObject = new ResultObject(4,2,"Addition");

        user = new User(username, password);

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
        user.addResult(testresultObject);
        List<ResultObject> testlist = user.getStatistics(); //TODO
        assertFalse(testlist.isEmpty());
    }

    @Test
    public void testResultObjectGetDate(){
        user.addResult(testresultObject);

        List<ResultObject> testlist = user.getStatistics();
        assertEquals(0, testlist.get(0).getDate().compareTo(testresultObject.getDate()));
    }


    @Test
    public void testCheckUserCredentials(){

        assertTrue(user.checkCredentials(username, password));
    }

    @Test
    public void testWRONGCheckUserCredentials(){

        assertFalse(user.checkCredentials(username, "ASDASD"));
        assertFalse(user.checkCredentials("AKSDHKAD", password));
        assertFalse(user.checkCredentials("AJSBHDOJ", "ASDASD"));
    }

    @Test
    public void testGetUsername(){

        assertEquals(user.getUsername(), username);
    }
}
