package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    public void generateTimesTable(int timeTablesController){

        ListView myListView = (ListView) findViewById(R.id.list_view);

        ArrayList<Integer> myTimeTableView = new ArrayList<Integer>();

        for ( int i = 1; i <= 20; i++){
            myTimeTableView.add(timeTablesController*i);
        }

        ArrayAdapter<Integer> myAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, myTimeTableView);

        myListView.setAdapter(myAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar mySeekBar = (SeekBar) findViewById(R.id.seekBar);
        mySeekBar.setProgress(10);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if(progress< min){
                    timesTable = min;
                    seekBar.setProgress(min);
                }else{
                    timesTable = progress;
                }
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}