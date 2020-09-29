package com.down_to_earth_rats.quiz_game.Model.QuestionHandler;

import com.down_to_earth_rats.quiz_game.Model.QuestionData.IQuestion;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 * This class is responsible for instantiating a QuizModel-object.
 *
 */

public class ModelFactory {

    private ModelFactory(){}

    public static IQuestionHandler createStandardModel(Iterator<IQuestion> questions){
        QuizModel model = new QuizModel();
        model.insertQuestions(questions);
        return model;
    }

}
