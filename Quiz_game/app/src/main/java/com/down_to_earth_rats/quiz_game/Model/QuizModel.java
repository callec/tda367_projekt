package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 */

class QuizModel implements IQuizModel {

    private Deque<IQuestion> questionStack = new ArrayDeque<>();

    @Override
    public void insertQuestions(Iterator<IQuestion> questions) {

        while(questions.hasNext()){
            questionStack.push(questions.next());
        }
    }

    @Override
    public IQuestion getQuestion() {
        return questionStack.pop();
    }
}
