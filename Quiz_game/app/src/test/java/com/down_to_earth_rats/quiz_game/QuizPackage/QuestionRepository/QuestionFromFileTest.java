package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;
import com.down_to_earth_rats.quiz_game.Subcategory;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Carl Bergman
 */
public class QuestionFromFileTest {

    private IQuestionProvider provider;

    @Before
    public void setup() {
        this.provider = QuestionProviderFactory.getStandardQuestionProvider();
    }

    @Test
    public void testGetQuestions() {
        // TODO: this class isn't implemented in QuestionFromFile
        //  - to test: that questions are of the subjects specified
        List<String> subjects = new ArrayList<>();
        subjects.add("addition");
        subjects.add("subtraktion");

        assertNull(provider.getQuestions(subjects, 5));
    }

    @Test
    public void testRandomAdditionQuestion() {
        Iterator<IQuestion> qs = provider.getQuestions(Subcategory.Addition, 1);

        qs.hasNext();
        IQuestion q = qs.next();
        Iterator<Tuple<String, Boolean>> as = q.getAlternatives();

        Tuple<String, Boolean> a;
        Set<String> alternativeStrings = new HashSet<>();
        while (as.hasNext()) {
            a = as.next();
            alternativeStrings.add(a.getValue1());
        }

        // if set size is smaller than what was added then there exists duplicates
        assertEquals(4, alternativeStrings.size());
    }
}
