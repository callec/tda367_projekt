package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

import com.down_to_earth_rats.quiz_game.quiz_model.question_data.IQuestion;
import com.down_to_earth_rats.quiz_game.quiz_model.question_data.QuestionFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * <p>
 * This class is responsible for storing an randomizing question/alternatives
 * When no more questions are available all observers will be notified.
 * Implements IQuestionHandler
 */

class RandomizingQuestionHandler implements IQuestionHandler {

    private final Deque<IQuestion> questions = new ArrayDeque<>();

    private final List<IQuestionHandlerObserver> observers = new ArrayList<>();

    public RandomizingQuestionHandler(Iterator<IQuestion> questions) {
        List<IQuestion> shuffleList = new ArrayList<>();

        //Shuffle alternatives for each question
        while (questions.hasNext()) {
            shuffleList.add(new ScrambledQuestion(questions.next()));
        }

        shuffleQuestions(shuffleList);
    }

    private void shuffleQuestions(List<IQuestion> list) {
        Collections.shuffle(list);
        questions.addAll(list);
    }

    @Override
    public IQuestion getQuestion() {

        if (questions.isEmpty()) {
            quizIsFinished();
            return QuestionFactory.createStandardFourAltQuestion("", "", "", "", "");

        }

        return questions.peek();
    }

    @Override
    public void nextQuestion() {

        try {
            questions.pop();
        } catch (NoSuchElementException e) {
            quizIsFinished();
        }

    }

    @Override
    public void registerObserver(IQuestionHandlerObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(IQuestionHandlerObserver observer) {
        observers.remove(observer);
    }

    @Override
    public boolean isLastQuestion() {
        return (questions.size() == 1);
    }

    private void quizIsFinished() {
        for (IQuestionHandlerObserver observer : observers) {
            observer.quizFinished();
        }
    }
}

