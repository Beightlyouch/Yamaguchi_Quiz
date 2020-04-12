package com.beightlyouch.yamaguchi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private CustomRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private DividerItemDecoration itemDecoration;

    private Button menuBtn;
    private Button againBtn;
    private TextView scoreTxt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    public void onStart() {

        menuBtn = findViewById(R.id.menuBtn);
        againBtn = findViewById(R.id.againBtn);
        scoreTxt = findViewById(R.id.scoreTxt);

        super.onStart();
        itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);

        Intent intent = getIntent();
        int type = intent.getIntExtra("type",0);
        int score = intent.getIntExtra("score",0);
        int[] check = intent.getIntArrayExtra("check");

        if(type == 1){
            ArrayList<Integer> city = intent.getIntegerArrayListExtra("city");
            String [] cities = new String[10];
            for (int i = 0; i < 10; i++) {
                String [][] poolcity = QuizDataCity.getPoolcity();
                cities[i] = poolcity[1][city.get(i)];
            }

            adapter = new CustomRecyclerAdapter(cities, check);
        }else if(type == 2){
            String[] place = intent.getStringArrayExtra("place");
            adapter = new CustomRecyclerAdapter(place, check);
        }

        recyclerView.setAdapter(adapter);
        scoreTxt.setText(score+" /10　点");

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), StartActivity.class);
                finish();
                startActivity(intent);
            }
        });

        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
