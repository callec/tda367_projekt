package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData;

/**
 * Created by Carl Bergman, Louise Tranborg
 * Modified by Erik Blomberg
 * 
 * This class is responsible for instantiating IQuestion-objects.
 */

public class QuestionFactory {

    private QuestionFactory() {}

    /**
     * Create a standard 1 correct 3 wrong alternative question.
     * @param text
     * @param correctAlt
     * @param secondAlt
     * @param thirdAlt
     * @param fourthAlt
     * @return A new question matching the parameters
     */
    public static IQuestion createStandardFourAltQuestion(String text,
                                                          String correctAlt, String secondAlt,
                                                          String thirdAlt, String fourthAlt){
         return new FourAltQuestion(text, correctAlt, secondAlt, thirdAlt, fourthAlt);
    }

}
