package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.FourAltQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * This class represents a whole quiz, with some questions.
 *
 */

public class StandardQuestionHandler implements IQuestionHandler {

    private final Deque<IQuestion> questions = new ArrayDeque<>();

    private final List<IModelObserver> observers = new ArrayList<>();

    public StandardQuestionHandler(Iterator<IQuestion> questions) {
        List<IQuestion> shuffleList = new ArrayList<>();

        //Shuffle alternatives for each question
        while(questions.hasNext()){
            shuffleList.add(new ScrambledQuestion(questions.next()));
        }

        shuffleQuestions(shuffleList);
    }

    private void shuffleQuestions(List<IQuestion> list){
        Collections.shuffle(list);
        questions.addAll(list);
    }

    @Override
    public IQuestion getQuestion() {

        if(questions.isEmpty()){
            quizIsFinished();
            return new FourAltQuestion("","", "", "", "");

        }

        return questions.peek();
    }

    @Override
    public void nextQuestion() {

        try{
            questions.pop();
        }catch (NoSuchElementException e){
            quizIsFinished();
        }

    }

    @Override
    public void registerObserver(IModelObserver observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IModelObserver observer) {
        observers.remove(observer);
    }

    @Override
    public boolean isLastQuestion() {
        return (questions.size() == 1);
    }

    private void quizIsFinished(){
        for (IModelObserver observer: observers) {
            observer.quizFinished();
        }
    }
}

