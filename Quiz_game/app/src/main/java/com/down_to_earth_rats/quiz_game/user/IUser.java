package com.down_to_earth_rats.quiz_game.user;

import com.down_to_earth_rats.quiz_game.category.ICategory;

import java.util.List;

public interface IUser {

    List<ResultObject> getStatistics();
    void addResult(ResultObject resultObject);
    boolean checkCredentials(String username, String password);
    String getUsername();
    ICategory getUserCategory();


}
