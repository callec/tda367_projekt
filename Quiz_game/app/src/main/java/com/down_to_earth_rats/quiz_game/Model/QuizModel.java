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
            shuffleList.add(shuffleAlternatives(questions.next()));
        }

        shuffleQuestions(shuffleList);

    }

    private IQuestion shuffleAlternatives(IQuestion question){
        ScrambledQuestion scrambledQuestion = new ScrambledQuestion();
        scrambledQuestion.setBaseQuestion(question);

        return scrambledQuestion;

    }

    private void shuffleQuestions(List<IQuestion> list){
        Collections.shuffle(list);
        questionStack.addAll(list);
    }

    @Override
    public IQuestion getQuestion() {
        return questionStack.pop();
    }
}
