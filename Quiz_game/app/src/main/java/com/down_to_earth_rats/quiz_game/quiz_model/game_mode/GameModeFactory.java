package com.down_to_earth_rats.quiz_game.quiz_model.game_mode;

import com.down_to_earth_rats.quiz_game.gui.game_mode_fragments.LivesGameModeFragment;
import com.down_to_earth_rats.quiz_game.gui.game_mode_fragments.StandardGameModeFragment;
import com.down_to_earth_rats.quiz_game.gui.game_mode_fragments.TimeGameModeFragment;

/**
 * Created by Carl Bergman
 * Return instances of each specific GameMode.
 */
public abstract class GameModeFactory {

    /**
     * Return selected GameMode.
     * @param gameMode string name of the selected GameMode
     * @return instance of IGameModeFragment
     */
    public static IGameModeFragment getGameMode(String gameMode) {
        switch (gameMode) {
            // TODO: replace strings with enum
            case "Tidspress":
                return TimeGameModeFragment.newInstance();
            case "Max tre fel":
                return LivesGameModeFragment.newInstance();
            default:
                return StandardGameModeFragment.newInstance();
        }
    }
}
