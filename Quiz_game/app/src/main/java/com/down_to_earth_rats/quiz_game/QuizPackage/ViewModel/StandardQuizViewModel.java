package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.IModelObserver;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.IQuestionHandler;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.ModelFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.IQuestionProvider;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.QuestionProviderFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;
import com.down_to_earth_rats.quiz_game.UserPackage.ResultObject;
import com.down_to_earth_rats.quiz_game.UserPackage.UserSingleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg, Erik Blomberg, Henrik Johansson
 * Modified by Carl Bergman, Louise Tranborg, Erik Blomberg, Henrik Johansson
 *
 */

public class StandardQuizViewModel extends androidx.lifecycle.ViewModel implements IModelObserver, IViewModel {

    private IQuestionHandler questionHandler;
    private int totalQuestions;
    private int totalAnswers;
    private int correctAnswers;
    private IQuestion currentQuestion;
    private String category = "";
    private String subCategory = "";
    private MutableLiveData<List<String>> alternativeList = new MutableLiveData<>();
    private IQuestionProvider questionProvider;

    private MutableLiveData<Boolean> runningState = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLast = new MutableLiveData<>();

    /*public StandardQuizViewModel(@NonNull Application application) {
        super(application);

        runningState.setValue(true);

        questionProvider = QuestionProviderFactory.getStandardQuestionProvider();
        questionHandler = ModelFactory.createStandardModel(questionProvider.getQuestions("Addition", 10));
        questionHandler.registerObserver(this);

        currentQuestion = questionHandler.getQuestion();
        createAlternativeList(currentQuestion);
        totalQuestions = 1;
    }*/

    public StandardQuizViewModel() {

    }

    public void initQuiz() {
        runningState.setValue(true);
        questionProvider = QuestionProviderFactory.getStandardQuestionProvider();

        questionHandler = ModelFactory.createStandardModel(questionProvider.getQuestions(subCategory, totalQuestions));
        questionHandler.registerObserver(this);

        currentQuestion = questionHandler.getQuestion();
        createAlternativeList(currentQuestion);

        isLast.setValue(questionHandler.isLastQuestion());

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

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    @Override
    public void setCategoryAndSubCategory(String category, String subCategory) {
        this.category = category;
        this.subCategory = subCategory;
    }

    public boolean answerQuestion(int alternativeID){
        List<Tuple<String, Boolean>> tupleList = new ArrayList<>();
        Iterator<Tuple<String, Boolean>> iterator = currentQuestion.getAlternatives();

        while (iterator.hasNext()) {
            tupleList.add(iterator.next());
        }

        boolean condition = tupleList.get(alternativeID-1).getValue2();
        if (condition) {
            correctAnswers++;
        }

        ++totalAnswers;
        return condition;
    }

    public void changeQuestion() {
        questionHandler.nextQuestion();
        currentQuestion = questionHandler.getQuestion();
        createAlternativeList(currentQuestion);
        isLast.setValue(questionHandler.isLastQuestion());
    }

    public MutableLiveData<Boolean> getRunningState() {
        return runningState;
    }

    @Override
    public void quizFinished() {
        ResultObject resultObject = new ResultObject(totalQuestions, correctAnswers, category, subCategory,
                "Standard", false); //TODO hint and gamemode
        UserSingleton.getUser().addResult(resultObject);


        runningState.setValue(false);
    }

    @Override
    public MutableLiveData<Boolean> getIsLast() {
        return isLast;
    }

    @Override
    public void gameModeForceEnd(){
        totalQuestions = totalAnswers;
        quizFinished();
        isLast.setValue(true);
    }
}
