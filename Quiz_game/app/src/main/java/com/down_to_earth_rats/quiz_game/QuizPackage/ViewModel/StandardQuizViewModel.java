package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.IModelObserver;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.IQuestionHandler;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.ModelFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.IQuestionProvider;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.QuestionProviderFactory;
import com.down_to_earth_rats.quiz_game.UserPackage.ResultObject;
import com.down_to_earth_rats.quiz_game.UserPackage.User;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Carl Bergman, Louise Tranborg, Erik Blomberg, Henrik Johansson
 * Modified by Carl Bergman, Louise Tranborg
 *
 */

public class StandardQuizViewModel extends androidx.lifecycle.ViewModel implements IModelObserver, IViewModel {

    private IQuestionHandler questionHandler;
    private int totalQuestions;
    private int correctAnswers;
    private IQuestion currentQuestion;
    private MutableLiveData<List<String>> alternativeList = new MutableLiveData<>();
    private IQuestionProvider questionProvider;

    private MutableLiveData<Boolean> runningState = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLast = new MutableLiveData<>();

    //User user = User.getInstance();

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
        questionProvider = QuestionProviderFactory.getStandardQuestionProvider();
        questionHandler = ModelFactory.createStandardModel(questionProvider.getQuestions("Addition", totalQuestions));
        questionHandler.registerObserver(this);

        currentQuestion = questionHandler.getQuestion();
        createAlternativeList(currentQuestion);

        isLast.setValue(questionHandler.isLastQuestion());
        runningState.setValue(true);
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

        return condition;
    }

    public void changeQuestion() {
        questionHandler.nextQuestion();
        currentQuestion = questionHandler.getQuestion();
        createAlternativeList(questionHandler.getQuestion());
        isLast.setValue(questionHandler.isLastQuestion());
    }

    public MutableLiveData<Boolean> getRunningState() {
        return runningState;
    }

    @Override
    public void quizFinished() {

        // TODO: Added by Louise to try create statistics, not beautiful with the user!
        ResultObject resultObject = new ResultObject(totalQuestions, correctAnswers, "Addition");
        //user.addResult(resultObject);

        runningState.setValue(false);
    }

    @Override
    public MutableLiveData<Boolean> getIsLast() {
        return isLast;
    }
}
