package com.down_to_earth_rats.quiz_game.GUIPackage.Activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.down_to_earth_rats.quiz_game.GUIPackage.Modal.IRecyclerViewActivity;
import com.down_to_earth_rats.quiz_game.GUIPackage.Modal.RecyclerViewAdapter;
import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.UserPackage.ResultObject;
import com.down_to_earth_rats.quiz_game.UserPackage.UserSingleton;
import com.down_to_earth_rats.quiz_game.databinding.ActivityHighscoreBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Sara Persson
 * Modified by Henrik Johansson, Louise Tranborg, Sara Persson, Erik Blomberg
 *
 */

public class StatisticsActivity extends AppCompatActivity implements IRecyclerViewActivity {

    private ActivityHighscoreBinding viewBinding;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String[] subcategories = {" "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewBinding = ActivityHighscoreBinding.inflate(getLayoutInflater());


        Toolbar toolbar = viewBinding.toolbarHighscore;

        toolbar.setTitle(R.string.statistics_title);
        setSupportActionBar(toolbar);

        //Gives us the return to previous page /back arrow, in the top toolbar   (<-)
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
        setContentView(viewBinding.getRoot());

        viewStatistics();

        recyclerView = viewBinding.recyclerView;

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter≤
        mAdapter = new RecyclerViewAdapter(subcategories, this, R.layout.framelayout_result);
        recyclerView.setAdapter(mAdapter);

    }

    private void viewStatistics(){
        List<ResultObject> resultList = UserSingleton.getUser().getStatistics(); //Fetch the statistics from the user.

        if(resultList.isEmpty()){
            viewBinding.textViewNoStatistics.setText("Ingen historik! Spela ett quiz och kom tillbaka.");
        }

        if (!resultList.isEmpty()){
            viewBinding.textViewNoStatistics.setText(" ");
            String[] resultArray = new String[resultList.size()];

            for (int i = 0; i < resultList.size(); i++){

                resultArray[i] = ("" + resultList.get(i).getCorrectAnswers() + "/" + resultList.get(i).getTotalQuestions() + " - " + getSwedishDate(resultList.get(i).getDate()) + hintsUsedSymbol(resultList.get(i).usedHint()));
            }

            Collections.reverse(Arrays.asList(resultArray));

            this.subcategories = resultArray;
        }
    }

    private String hintsUsedSymbol(boolean hintsUsed) {
        String hintSymbol = ("");
        if (hintsUsed) {
            hintSymbol = (" *");
        }
        return hintSymbol;
    }

    private String getSwedishDate(Date date){

        String day = null;
        String month = null;
        String dateNumber = null;
        String time = null;

        int startIndex = 0;

        int spaces = 0;

        for (int i = 0; i < date.toString().length(); i++){

            if (date.toString().charAt(i) == ' '){

                String substring = date.toString().substring(startIndex + 1, i);

                switch (spaces){
                    case 0: day = date.toString().substring(0, i);
                        break;
                    case 1: month = substring;
                        break;
                    case 2: dateNumber = substring;
                        break;
                    case 3: time = date.toString().substring(startIndex + 1, i - 3);
                        break;
                }
                startIndex = i;
                spaces++;
            }
        }

        day = translateDay(day);
        month = monthNumber(month);

        return (day + " " + dateNumber + "/" + month + " kl: " + time);
    }

    private String translateDay(String day){

        switch (day){
            case "Mon": return "mån";
            case "Tue": return "tis";
            case "Wed": return "ons";
            case "Thu": return "tors";
            case "Fri": return "fre";
            case "Sat": return "lör";
            case "Sun": return "sön";
            default: return "blame Henrik";
        }
    }

    private String monthNumber(String month){

        switch (month){
            case "Jan": return "1";
            case "Feb": return "2";
            case "Mar": return "3";
            case "Apr": return "4";
            case "May": return "5";
            case "Jun": return "6";
            case "Jul": return "7";
            case "Aug": return "8";
            case "Sep": return "9";
            case "Oct": return "10";
            case "Nov": return "11";
            case "Dec": return "12";
            default: return "blame Henrik";
        }

        /*switch (month){
            case "Jan": return "januari";
            case "Feb": return "februari";
            case "Mar": return "mars";
            case "Apr": return "april";
            case "May": return "maj";
            case "Jun": return "juni";
            case "Jul": return "juli";
            case "Aug": return "augusti";
            case "Sep": return "september";
            case "Oct": return "october";
            case "Nov": return "november";
            case "Dec": return "december";
            default: return "blame Henrik";
        }*/
    }


    @Override
    public void onClickRecyclerViewItem(String subcategory) {
        //Do nothing, yet..
    }
}
