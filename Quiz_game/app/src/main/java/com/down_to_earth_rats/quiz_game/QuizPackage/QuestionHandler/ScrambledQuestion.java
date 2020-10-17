package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.ListIterator;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 *
 * This class implements IQuestion and is responsible for
 * shuffling around the alternatives within a question.
 *
 */

class ScrambledQuestion implements IQuestion {

    private IQuestion baseQuestion;
    private final List<Tuple<String, Boolean>> alternatives = new ArrayList<>();

    public ScrambledQuestion(IQuestion baseQuestion) {
        this.baseQuestion = baseQuestion;

        Iterator<Tuple<String, Boolean>> iterator = baseQuestion.getAlternatives();

        while(iterator.hasNext()){
            alternatives.add(iterator.next());
        }

        shuffleAlternatives();

    }

    private void shuffleAlternatives(){
        Collections.shuffle(alternatives);
    }

    @Override
    public String getQuestionText() {
        return baseQuestion.getQuestionText();

    }

    @Override
    public Iterator<Tuple<String, Boolean>> getAlternatives(){
        return new ListIterator<>(alternatives);
    }
}
