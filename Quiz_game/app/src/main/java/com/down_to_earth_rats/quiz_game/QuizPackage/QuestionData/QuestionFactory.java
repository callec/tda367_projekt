package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 * This class is responsible for instantiating an IQuestion-object.
 */

public class QuestionFactory {

    private QuestionFactory() {}

    public static IQuestion getFourAltQuestion(String text, String a1, String a2, String a3, String a4){
         return new FourAltQuestion(text, a1, a2, a3, a4);
    }

}
