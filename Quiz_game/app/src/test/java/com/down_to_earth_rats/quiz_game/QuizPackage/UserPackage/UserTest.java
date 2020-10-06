package com.down_to_earth_rats.quiz_game.QuizPackage.UserPackage;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void testAddResult(){
        ResultObject testresultObject = new ResultObject(4,2,"Addition");
        assertEquals("Addition", testresultObject.getSubcategory());

        User.getInstance().addResult(testresultObject);
        ArrayList<ResultObject> testlist = User.getInstance().getStatistics("Addition");
        assertTrue(!testlist.isEmpty());
    }
}
