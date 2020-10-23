package com.down_to_earth_rats.quiz_game.quiz_model.question_repository;

import com.down_to_earth_rats.quiz_game.quiz_model.question_data.IQuestion;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg
 * <p>
 * This interface defines the behaviour of QuestionProviders.
 */

public interface IQuestionProvider {

    /**
     * Method used to access a list of question based on subcategory and number of questions wanted
     *
     * @param subcategory       questions from this subcategory is wanted.
     * @param numberOfQuestions how many questions you want to get.
     * @return a list of questons from the wanted subcategory
     */
    Iterator<IQuestion> getQuestions(String category, String subcategory, int numberOfQuestions);

    /**
     * This method is not viable at the moment.
     * Can be implemented to access hybride-quizzes.
     *
     * @param listOfSubcategory a list of all the subcategories you want questions from.
     * @param numberOfQuestions how many questions you want to get.
     * @return a list of questons.
     */
    Iterator<IQuestion> getQuestions(String category, List<String> listOfSubcategory, int numberOfQuestions);
}
