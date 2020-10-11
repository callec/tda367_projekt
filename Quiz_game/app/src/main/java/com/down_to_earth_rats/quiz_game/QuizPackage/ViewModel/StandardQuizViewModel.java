package com.down_to_earth_rats.quiz_game.QuizPackage.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionData.IQuestion;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.IModelObserver;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.IQuestionHandler;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionHandler.ModelFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.IQuestionProvider;
import com.down_to_earth_rats.quiz_game.QuizPackage.QuestionRepository.QuestionProviderFactory;
import com.down_to_earth_rats.quiz_game.QuizPackage.Utility.Tuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Carl Bergman, Louise Tranborg, Erik Blomberg, Henrik Johansson
 * Modified by Carl Bergman, Louise Tranborg
 *
 */

public class StandardQuizViewModel extends ViewModel implements IModelObserver, IViewModel{

    private IQuestionHandler questionHandler;
    private int totalQuestions;
    private int correctAnswers;
    private IQuestion currentQuestion;
    private MutableLiveData<List<String>> alternativeList = new MutableLiveData<>();
    private IQuestionProvider questionProvider;

    private MutableLiveData<Boolean> runningState = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLast = new MutableLiveData<>();

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

    public boolean answerQuestion(int alternativeID) {
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

    public boolean checkIfCorrect(int alternativeID) {
        List<Tuple<String, Boolean>> tupleList = new ArrayList<>();
        Iterator<Tuple<String, Boolean>> iterator = currentQuestion.getAlternatives();

        while (iterator.hasNext()) {
            tupleList.add(iterator.next());
        }

        boolean condition = tupleList.get(alternativeID-1).getValue2();
        return condition;
    }

    public int getHintIndex() {
        int amountOfQuestions = 4;
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(amountOfQuestions);

        while (this.checkIfCorrect(random+1)) {
            random = randomGenerator.nextInt(amountOfQuestions);
        }

        return random;

      /*  for (int i = 0; i<amountOfQuestions; i++){
            int n = i+1;
            if (!this.checkIfCorrect(n)){
                return i;
            }
        }
        return 3; //error
*/
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
        runningState.setValue(false);
    }

    @Override
    public MutableLiveData<Boolean> getIsLast() {
        return isLast;
    }
}
