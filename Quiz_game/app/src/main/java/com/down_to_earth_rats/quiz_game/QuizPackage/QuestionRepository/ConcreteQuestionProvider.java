package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.QuestionFactory;
import com.down_to_earth_rats.quiz_game.Utility.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Carl Bergman, Louise Tranborg.
 * Modified by Henrik Johansson and Louise Tranborg.
 *
 * This class is responsible for supplying questions.
 * At this moment just methods and hardcoded data.
 * But later on this will be a path to access questions from a database/file.
 *
 */

public class ConcreteQuestionProvider implements IQuestionProvider {

    /**
     * Method used to access a list of question based on subcategory and number of questions wanted
     *
     * @param subcategory questions from this subcategory is wanted.
     * @param numberOfQuestions how many questions you want to get.
     * @return a list of questons from the wanted subcategory
     */
    @Override
    public Iterator<IQuestion> getQuestions(String subcategory, int numberOfQuestions) {
        List<IQuestion> qs = new ArrayList<>();

        if(subcategory.equals("Sveriges Historia")){
            qs = swedishHistoryQuestions(numberOfQuestions);
        }
        if(subcategory.equals("Europas Historia")){
            qs = europeHistoryQuestions(numberOfQuestions);
        }

        for (int i=0; i<numberOfQuestions; ++i) {

            switch (subcategory){
                case "Addition":
                    qs.add(randomAdditionQuestion());
                    break;
                case "Subtraktion":
                    qs.add(randomSubtractionQuestion());
                    break;
                case "Multiplikation":
                    qs.add(randomMultiplicationQuestion());
                    break;
                case "Division":
                    qs.add(randomDivisionQuestion());
                    break;
                case "Matteprov":
                    qs.add(matteProvQuestion());

            }
        }

        return new ListIterator<>(qs);
    }

    private IQuestion matteProvQuestion(){
        Random random = new Random();
        int value = random.nextInt(4);
        switch (value){
            case 0:
                return randomAdditionQuestion();
            case 1:
                return randomSubtractionQuestion();
            case 2:
                return randomMultiplicationQuestion();
            case 3:
                return randomDivisionQuestion();
        } return randomAdditionQuestion();
    }

    private List<IQuestion> swedishHistoryQuestions(int numberOfQuestions){
        List<IQuestion> questions = new ArrayList<>();
        for(int i = 0; i<numberOfQuestions; i++){
            questions.add(QuestionFactory.createStandardFourAltQuestion("Vilket år sköts Olof Palme?", "1986","1987", "1985","2005"));
        }
        return questions;
    }

    private List<IQuestion> europeHistoryQuestions(int numberOfQuestions){
        List<IQuestion> questions = new ArrayList<>();
        for(int i = 0; i<numberOfQuestions; i++){
            questions.add(QuestionFactory.createStandardFourAltQuestion("Vilket år upphörde Berlinmuren?", "1989","1987", "1990","2005"));
        }
        return questions;
    }

    private IQuestion randomAdditionQuestion() {
        Random r = new Random();
        int qBound = 40;
        int aBound = 10;

        int x = r.nextInt(qBound) + 10;
        int y = r.nextInt(qBound) + 10;
        int correct = x+y;
        int wrong1, wrong2, wrong3;

        do{
            wrong1 = x + y + (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong1 == correct);

        do{
            wrong2 = x + y + (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong2 == correct || wrong2 == wrong1);

        do{
            wrong3 = x + y + (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong3 == correct || wrong3 == wrong2 || wrong3 == wrong1);

        String q = "Vad är: " + x + " + " + y + " ?";
        String a1 = "" + correct;
        String a2 = "" + wrong1;
        String a3 = "" + wrong2;
        String a4 = "" + wrong3;

        return QuestionFactory.createStandardFourAltQuestion(q, a1, a2, a3, a4);
    }

    private IQuestion randomSubtractionQuestion(){
        Random r = new Random();
        int qBound = 40;
        int aBound = 10;

        int x = r.nextInt(qBound) + 10;
        int y = r.nextInt(qBound) + 10;
        int correct = x-y;
        int wrong1, wrong2, wrong3;

        do{
            wrong1 = x - y - (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong1 == correct);

        do{
            wrong2 = x - y - (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong2 == correct || wrong2 == wrong1);

        do{
            wrong3 = x - y - (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong3 == correct || wrong3 == wrong2 || wrong3 == wrong1);

        String q = "Vad är: " + x + " - " + y + " ?";
        String a1 = "" + correct;
        String a2 = "" + wrong1;
        String a3 = "" + wrong2;
        String a4 = "" + wrong3;

        return QuestionFactory.createStandardFourAltQuestion(q, a1, a2, a3, a4);
    }

    private IQuestion randomMultiplicationQuestion() {
        Random r = new Random();
        int bound = 10;

        int x = r.nextInt(bound);
        int y = r.nextInt(bound);
        int correct = x*y;
        int wrong1, wrong2, wrong3;

        do{
            wrong1 = x * y + (r.nextBoolean() ? - r.nextInt(bound) : + r.nextInt(bound));
        } while(wrong1 == correct);

        do{
            wrong2 = x * y + (r.nextBoolean() ? - r.nextInt(bound) : + r.nextInt(bound));
        } while(wrong2 == correct || wrong2 == wrong1);

        do{
            wrong3 = x * y + (r.nextBoolean() ? - r.nextInt(bound) : + r.nextInt(bound));
        } while(wrong3 == correct || wrong3 == wrong2 || wrong3 == wrong1);

        String q = "Vad är: " + x + " x " + y + " ?";
        String a1 = "" + correct;
        String a2 = "" + wrong1;
        String a3 = "" + wrong2;
        String a4 = "" + wrong3;

        return QuestionFactory.createStandardFourAltQuestion(q, a1, a2, a3, a4);
    }

    private IQuestion randomDivisionQuestion() {
        Random r = new Random();
        int aBound = 10;

        int correct = r.nextInt(10);
        int lower;
        do {
            lower = r.nextInt(10);
        } while (lower == 0);
        int upper = lower*correct;
        int wrong1, wrong2, wrong3;

        do{
            wrong1 = correct + (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong1 == correct);

        do{
            wrong2 = correct + (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong2 == correct || wrong2 == wrong1);

        do{
            wrong3 = correct + (r.nextBoolean() ? - r.nextInt(aBound) : + r.nextInt(aBound));
        } while(wrong3 == correct || wrong3 == wrong2 || wrong3 == wrong1);

        String q = "Vad är: " + upper + " / " + lower + " ?";
        String a1 = "" + correct;
        String a2 = "" + wrong1;
        String a3 = "" + wrong2;
        String a4 = "" + wrong3;

        return QuestionFactory.createStandardFourAltQuestion(q, a1, a2, a3, a4);
    }

    /**
     * This method is not viable at the moment.
     * Can be implemented to access hybride-quizzes.
     *
     * @param listOfSubjects a list of all the subcategories you want questions from.
     * @param numberOfQuestions how many questions you want to get.
     * @return a list of questons.
     */
    @Override
    public Iterator<IQuestion> getQuestions(List<String> listOfSubjects, int numberOfQuestions) {
        return null;
    }
}
