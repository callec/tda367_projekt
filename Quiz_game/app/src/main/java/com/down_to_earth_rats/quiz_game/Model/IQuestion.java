package com.down_to_earth_rats.quiz_game.Model;

import java.util.Iterator;
import java.util.List;

public interface IQuestion {

    String getCorrectAlternative();

    Iterator<String> getFalseAlternatives();

}
