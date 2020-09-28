package com.down_to_earth_rats.quiz_game.Model.QuestionHandler;

import com.down_to_earth_rats.quiz_game.Model.FourAltQuestion;
import com.down_to_earth_rats.quiz_game.Model.IQuestion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * This class represents a whole quiz, with some questions.
 *
 */

public class QuizModel implements IQuizModel {

    private Deque<IQuestion> questionStack = new ArrayDeque<>();

    private List<IModelObserver> observerList = new ArrayList<>();

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

        if(questionStack.isEmpty()){
            return new FourAltQuestion("","", "", "", "");
        }

        return questionStack.peek();
    }

    @Override
    public void nextQuestion() {
        questionStack.pop();

        if(questionStack.isEmpty()){
            for (IModelObserver observer: observerList) {
                observer.quizFinished();
            }
        }
    }

    @Override
    public void registerObserver(IModelObserver observer) {
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    @Override
    public void removeObserver(IModelObserver observer) {
        observerList.remove(observer);
    }
}
