package com.beightlyouch.yamaguchi;


import android.content.Intent;
import android.net.InetAddresses;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    //市町村データ取得
    String [][] poolcity = QuizDataCity.getPoolcity();
    //正解市町村配列
    ArrayList<Integer> answer_cities = new ArrayList<Integer>();
    //正誤用配列
    int [] answercheck = new int[10];

    //ビュー要素
    ImageView yamanashi_city;
    ImageView yamanashi_result;
    TextView result;
    TextView yamanashi_score;
    TextView problem_num;
    Button choice_one;
    Button choice_two;
    Button choice_three;
    Button choice_four;
    Button nextBtn;
    Button resultBtn;

    static int correct;
    static int wrong;
    static int problem;
    int isFinished;

    public MainActivity() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        problem = 1;

        //ビュー要素
        yamanashi_city = findViewById(R.id.yamanashi_city);
        yamanashi_result = findViewById(R.id.yamanashi_result);
        yamanashi_score = findViewById(R.id.yamanashi_score);
        problem_num = findViewById(R.id.problem_num);
        nextBtn = findViewById(R.id.nextBtn);
        result = findViewById(R.id.result);
        choice_one = findViewById(R.id.choice_one);
        choice_two = findViewById(R.id.choice_two);
        choice_three = findViewById(R.id.choice_three);
        choice_four = findViewById(R.id.choice_four);

        //初期化
        if(problem == 1){
            wrong = 0;
            correct = 0;
            isFinished = 0;

            scoreQuiz();
            QuizMaker qm = new QuizMaker();
            qm.createQuiz();

            final ArrayList<Integer> choices = qm.getChoices();
            final int answer_num = qm.getAnswer_num();
            final int answer_city = qm.getAnswer_City();
            answer_cities.add(answer_city);
            problem_num.setText("第 "+problem+" 問");
            startQuiz(choices, answer_num);
        }


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(problem < 10) {
                    problem++;
                    scoreQuiz();
                    QuizMaker qm = new QuizMaker();
                    qm.createQuiz();
                    final ArrayList<Integer> choices = qm.getChoices();
                    final int answer_num = qm.getAnswer_num();
                    final int answer_city = qm.getAnswer_City();
                    answer_cities.add(answer_city);
                    startQuiz(choices, answer_num);
                    problem_num.setText("第 "+problem+" 問");
                }else{
                    choice_one.setEnabled(false);
                    choice_two.setEnabled(false);
                    choice_three.setEnabled(false);
                    choice_four.setEnabled(false);
                    nextBtn.setEnabled(false);
                    nextBtn.setEnabled(false);


                    Intent intent = new Intent(getApplication(), ResultActivity.class);
                    intent.putExtra("type",1);
                    intent.putExtra("city", answer_cities);
                    intent.putExtra("check", answercheck);
                    intent.putExtra("score", correct);
                    finish();
                    startActivity(intent);

                }
            }
        });
    }

    //毎問スタートごとに呼び出される
    //選択肢とどの選択肢が回答か？を受け取る
    public void startQuiz(ArrayList<Integer> choices,int answer_num){
        choice_one.setEnabled(true);
        choice_two.setEnabled(true);
        choice_three.setEnabled(true);
        choice_four.setEnabled(true);
        nextBtn.setEnabled(false);

        yamanashi_result.setImageResource(android.R.color.transparent);
        result.setText("");
        int answer_city = choices.get(answer_num);

        yamanashi_city.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + poolcity[0][answer_city]));
        choice_one.setText("①  " + poolcity[1][choices.get(0)]);
        choice_two.setText("②  " + poolcity[1][choices.get(1)]);
        choice_three.setText("③  " + poolcity[1][choices.get(2)]);
        choice_four.setText("④  " + poolcity[1][choices.get(3)]);

        checkAnswer(answer_city, answer_num);
    }


    //ここなんとかしたい
    public void checkAnswer(final int answer_city, final int answer_num){
        choice_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice_one.setEnabled(false);
                choice_two.setEnabled(false);
                choice_three.setEnabled(false);
                choice_four.setEnabled(false);
                nextBtn.setEnabled(false);
                nextBtn.setEnabled(true);

                if (answer_num == 0) {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "correct"));
                    correct++;
                    answercheck[problem-1] = 1;
                } else {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "wrong"));
                    result.setText("正解は  " + poolcity[1][answer_city]+ " です。");
                    wrong++;
                    answercheck[problem-1] = 0;
                }
            }
        });
        choice_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice_one.setEnabled(false);
                choice_two.setEnabled(false);
                choice_three.setEnabled(false);
                choice_four.setEnabled(false);
                nextBtn.setEnabled(false);
                nextBtn.setEnabled(true);

                if (answer_num == 1) {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "correct"));
                    correct++;
                    answercheck[problem-1] = 1;
                } else {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "wrong"));
                    result.setText("正解は  " + poolcity[1][answer_city]+ " です。");
                    wrong++;
                    answercheck[problem-1] = 0;
                }
            }
        });
        choice_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice_one.setEnabled(false);
                choice_two.setEnabled(false);
                choice_three.setEnabled(false);
                choice_four.setEnabled(false);
                nextBtn.setEnabled(false);
                nextBtn.setEnabled(true);

                if (answer_num == 2) {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "correct"));
                    correct++;
                    answercheck[problem-1] = 1;
                } else {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "wrong"));
                    result.setText("正解は  " + poolcity[1][answer_city]+ " です。");
                    wrong++;
                    answercheck[problem-1] = 0;
                }
            }
        });
        choice_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice_one.setEnabled(false);
                choice_two.setEnabled(false);
                choice_three.setEnabled(false);
                choice_four.setEnabled(false);
                nextBtn.setEnabled(false);
                nextBtn.setEnabled(true);

                if (answer_num == 3) {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "correct"));
                    correct++;
                    answercheck[problem-1] = 1;
                } else {
                    yamanashi_result.setImageURI(Uri.parse("android.resource://com.beightlyouch.yamaguchi/drawable/" + "wrong"));
                    result.setText("正解は  " + poolcity[1][answer_city]+ " です。");
                    wrong++;
                    answercheck[problem-1] = 0;
                }
            }
        });
    }

    public void scoreQuiz(){
        yamanashi_score.setText("正解:  "+correct+"問    不正解:  "+wrong+"問");
    }


    @Override
    public void onBackPressed() {
    }

    public ArrayList<Integer> getAnswer_cities() {
        return answer_cities;
    }
}
