package com.down_to_earth_rats.quiz_game.Model;

import java.util.Iterator;

/**
 * Created by Erik Blomberg, Louise Tranborg
 *
 *
 */

public class ModelFactory {

    private ModelFactory(){}

    public static IQuizModel createStandardModel(Iterator<IQuestion> questions){
        QuizModel model = new QuizModel();
        model.insertQuestions(questions);
        return model;
    }

}
