package com.ilhanaksu.oddorevenday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.content.SharedPreferences;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    String daysArray[] = {"Sunday","Monday","Tuesday", "Wednesday","Thursday","Friday", "Saturday"};
    TextView myAwesomeTextView;
    String dayOfTheWeek;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();


    }
    @Override
    protected void onResume() {
        super.onResume();
        setData();

    }
    private void setData() {
        myAwesomeTextView = (TextView) findViewById(R.id.myAwesomeTextView);
        int dayOfTheWeeknumber =  Calendar.getInstance().get(Calendar.DAY_OF_WEEK) -1;
        dayOfTheWeek = daysArray[dayOfTheWeeknumber];



        SharedPreferences sharedPrefForDay = getPreferences(MODE_PRIVATE);
        SharedPreferences sharedPrefForVal = getPreferences(MODE_PRIVATE);

        String savedDay = sharedPrefForDay.getString("day","-1");
        String savedVal = sharedPrefForVal.getString("value","-1");
        // if(!savedDay.equals("-1"))
        //   myAwesomeTextView.setText("Çift");

        if(!dayOfTheWeek.equals(savedDay))
        {
            if(savedVal.equals("TEK"))
                savedVal="ÇİFT" ;

            else
                savedVal="TEK" ;


            SharedPreferences.Editor editor = sharedPrefForDay.edit();
            editor.putString("day",dayOfTheWeek);
            editor.commit();

            SharedPreferences.Editor editor2 = sharedPrefForVal.edit();
            editor2.putString("value",savedVal);
            editor2.commit();
        }
        myAwesomeTextView.setText(savedVal);
    }


}
