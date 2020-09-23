package com.down_to_earth_rats.quiz_game.Model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
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

        List<IQuestion> shuffleList = new ArrayList<>();
        while(questions.hasNext()){
            shuffleList.add(questions.next());
            //questionStack.push(questions.next());
        }

        Collections.shuffle(shuffleList);
        questionStack.addAll(shuffleList);
    }

    @Override
    public IQuestion getQuestion() {
        return questionStack.pop();
    }
}
