package com.beightlyouch.yamaguchi;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.beightlyouch.yamaguchi.QuizDataCity.getCityNum;

public class QuizMaker {

    private int answer_city;
    private int answer_num;
    private ArrayList<Integer> choices;
    private int question_num;

    //引数なしコンストラクタ
    public QuizMaker() {
    }

    //答えを決める
    public void create_Answer_City() {
        Random rand = new Random();
        int answer = rand.nextInt(19);
        answer_city = answer;
    }

    public ArrayList<Integer> getWrongs() {
        create_Answer_City();
        ArrayList<Integer> wrongs = new ArrayList<Integer>();

        while(wrongs.size() < 3){
            Random rand = new Random();
            int randomNumber = rand.nextInt(19);
            if(goodWrongs(wrongs, answer_city, randomNumber)){
                wrongs.add(randomNumber);
            }
        }
        return wrongs;
    }

    //4択を重複させない
    public boolean goodWrongs(ArrayList<Integer> wrongs, int answer_city, int randomNumber){
        for(int i=0; i<wrongs.size(); i++){
            Log.d("よろ", String.valueOf("比較対象の数字: " + String.valueOf(wrongs.get(i)) + " " + "答え: " + String.valueOf(getAnswer_City()) + " " + "入れたい数字: " + String.valueOf(randomNumber)));
            if(wrongs.get(i)==randomNumber) {
                return false;
            }
        }
        if(answer_city==randomNumber) {
            return false;
        }
        return true;
    }

    //出題市町村を重複させない
    public boolean goodAnswer(ArrayList<Integer> answers, int answer){
        for(int i=0; i<answers.size(); i++){
            if(answers.get(i)==answer){
                return false;
            }
        }
        return true;
    }

    public void createQuiz(){
        ArrayList<Integer> choices = getWrongs();
        Log.d("答え市町村 ", String.valueOf(answer_city));
        choices.add(answer_city);
        Log.d("デバッグ", choices.toString());
        Collections.shuffle(choices);

        for(int i=0; i<4; i++) {
            if(choices.get(i) == answer_city) {
                setAnswer_num(i);
            }
        }
        this.setChoices(choices);
    }

    //回答の選択肢の番号
    public int getAnswer_num() { return answer_num; }

    public void setAnswer_num(int answer_num) { this.answer_num = answer_num; }

    public int getAnswer_City() { return answer_city; }

    public void setAnswer_city(int answer_city) { this.answer_city = answer_city; }

    public ArrayList<Integer> getChoices() { return choices; }

    public void setChoices(ArrayList<Integer> choices) { this.choices = choices; }

    public int getQuestion_num() { return question_num; }

    public void setQuestion_num(int question_num) { this.question_num = question_num; }
}
