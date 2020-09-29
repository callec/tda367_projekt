package com.down_to_earth_rats.quiz_game.Model.QuestionRepository;

import com.down_to_earth_rats.quiz_game.Model.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.Model.QuestionData.QuestionFactory;
import com.down_to_earth_rats.quiz_game.Model.Utility.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 * This class is responsible for reading questions from a file.
 *
 */

public class QuestionsFromFile implements IQuestionProvider {

    @Override
    public Iterator<IQuestion> getQuestions(String subject, int numberOfQuestions) {
        List<IQuestion> list = new ArrayList<>();
        for( int i = 0; i < 10; i++) {
            list.add(QuestionFactory.getFourAltQuestion("fråga" + i, "1" + i, "2" + i, "3" + i, "4" + i));
        }
        Iterator<IQuestion> questions = new ListIterator<IQuestion>(list);
        return questions;
    }

    @Override
    public Iterator<IQuestion> getQuestions(List<String> listOfSubjects, int numberOfQuestions) {
        return null;
    }
}
