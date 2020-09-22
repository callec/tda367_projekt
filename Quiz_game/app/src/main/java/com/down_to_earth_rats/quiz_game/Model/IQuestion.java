package com.down_to_earth_rats.quiz_game.Model;

import java.util.List;

public interface IQuestion {

    String getCorrectAlternative();

    List<String> getFalseAlternatives();

}
