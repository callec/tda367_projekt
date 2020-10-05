package com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.QuestionFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Carl Bergman, Louise Tranborg
 *
 * This class is responsible for reading questions from a file.
 *
 */

public class QuestionsFromFile implements IQuestionProvider {

    @Override
    public Iterator<IQuestion> getQuestions(String subject, int numberOfQuestions) {

        List<IQuestion> qs = new ArrayList<>();
        for (int i=0; i<numberOfQuestions; ++i) {
            qs.add(randomAdditionQuestion());
        }

        return new ListIterator<>(qs);
        //return randomAdditionQuestions(numberOfQuestions);

        /*List<IQuestion> list = new ArrayList<>();
        for( int i = 0; i < 10; i++) {
            list.add(QuestionFactory.getFourAltQuestion("fråga" + i, "1" + i, "2" + i, "3" + i, "4" + i));
        }
        Iterator<IQuestion> questions = new ListIterator<IQuestion>(list);
        return questions;

         */
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

        return QuestionFactory.getFourAltQuestion(q, a1, a2, a3, a4);
    }

    /*
    private Iterator<IQuestion> randomAdditionQuestions(int numberOfQuestions){
        List<IQuestion> list = new ArrayList<>();
        int x;
        int y;
        int correct;
        int wrong1;
        int wrong2;
        int wrong3;
        Random r = new Random();
        for(int i = 0; i < numberOfQuestions; i++){
            x = r.nextInt(30) + 10;
            y = r.nextInt(30) + 10;
            correct = x + y;

            do{
                wrong1 = x + y + Math.abs(x-y) + 1;
            } while(wrong1 == correct);

            do{
                wrong2 = x + y + r.nextInt(10) - 1;
            } while(wrong2 == correct || wrong2 == wrong1);

            do{
                wrong3 = Math.abs(x + y - r.nextInt(10) + 1);
            } while(wrong3 == correct || wrong3 == wrong2 || wrong3 == wrong1);

            list.add(QuestionFactory.getFourAltQuestion("Vad är: " + x + " + " + y + " ?", "" + correct, "" + wrong1, "" + wrong2, "" + wrong3));
        }
        return new ListIterator<>(list);
    }*/

    @Override
    public Iterator<IQuestion> getQuestions(List<String> listOfSubjects, int numberOfQuestions) {
        return null;
    }
}
