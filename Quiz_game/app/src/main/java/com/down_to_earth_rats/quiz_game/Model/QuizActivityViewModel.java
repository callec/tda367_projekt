package com.down_to_earth_rats.quiz_game.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.down_to_earth_rats.quiz_game.Model.QuestionHandler.IModelObserver;
import com.down_to_earth_rats.quiz_game.Model.QuestionHandler.IQuestionHandler;
import com.down_to_earth_rats.quiz_game.Model.QuestionHandler.ModelFactory;
import com.down_to_earth_rats.quiz_game.Model.Utility.ListIterator;
import com.down_to_earth_rats.quiz_game.Model.Utility.Tuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuizActivityViewModel extends AndroidViewModel implements IModelObserver {

    private IQuestionHandler questionHandler;
    private int totalQuestions;
    private int correctAnswers;
    private IQuestion currentQuestion;
    private MutableLiveData<List<String>> alternativeList = new MutableLiveData<>();

    public QuizActivityViewModel(@NonNull Application application) {
        super(application);
        List<IQuestion> list = new ArrayList<>();
        list.add(new FourAltQuestion("FrågaText", "first", "second", "third", "fourth"));
        list.add(new FourAltQuestion("FrågaText1", "first1", "second1", "third1", "fourth1"));
        list.add(new FourAltQuestion("FrågaText2", "first2", "second2", "third2", "fourth2"));
        questionHandler = ModelFactory.createStandardModel(new ListIterator<IQuestion>(list));
        questionHandler.registerObserver(this);
        currentQuestion = questionHandler.getQuestion();
        createAlternativeList(currentQuestion);
        totalQuestions = 1;
    }

    private void createAlternativeList(IQuestion question){
        List<String> list = new ArrayList<>();
        list.add(question.getQuestionText());
        Iterator<Tuple<String, Boolean>> iterator = question.getAlternatives();
        while(iterator.hasNext()){
            list.add(iterator.next().getValue1());
        }
        alternativeList.setValue(list);
    }

    public LiveData<List<String>> getAlternativeList() {
        return alternativeList;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public boolean answerQuestion(int alternativeID){
        Boolean condition = false;
        List<Tuple<String, Boolean>> tupleList = new ArrayList<>();
        Iterator<Tuple<String, Boolean>> iterator = currentQuestion.getAlternatives();
        while(iterator.hasNext()){
            tupleList.add(iterator.next());
        }
        condition = tupleList.get(alternativeID-1).getValue2();
        if(condition){
            correctAnswers++;
        }
        return condition;
    }

    public void changeQuestion(){
        questionHandler.nextQuestion();
        createAlternativeList(questionHandler.getQuestion());
    }

    @Override
    public void quizFinished() {

    }
}
