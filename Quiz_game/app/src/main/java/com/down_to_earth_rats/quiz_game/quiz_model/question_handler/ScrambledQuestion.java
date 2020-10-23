package com.down_to_earth_rats.quiz_game.quiz_model.question_handler;

import com.down_to_earth_rats.quiz_game.quiz_model.question_data.IQuestion;
import com.down_to_earth_rats.quiz_game.utility.ListIterator;
import com.down_to_earth_rats.quiz_game.utility.Tuple;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Erik Blomberg, Louise Tranborg
 * Modified by Erik Blomberg
 * <p>
 * This class is responsible to wrap another IQuestion and shuffle its alternatives.
 * Implements IQuestion
 */

class ScrambledQuestion implements IQuestion {

    private final IQuestion baseQuestion;
    private final List<Tuple<String, Boolean>> alternatives = new ArrayList<>();

    public ScrambledQuestion(@NotNull IQuestion baseQuestion) {
        this.baseQuestion = baseQuestion;

        Iterator<Tuple<String, Boolean>> iterator = baseQuestion.getAlternatives();

        while (iterator.hasNext()) {
            alternatives.add(iterator.next());
        }

        shuffleAlternatives();

    }

    private void shuffleAlternatives() {
        Collections.shuffle(alternatives);
    }

    @Override
    public String getQuestionText() {
        return baseQuestion.getQuestionText();

    }

    @Override
    public Iterator<Tuple<String, Boolean>> getAlternatives() {
        return new ListIterator<>(alternatives);
    }
}
