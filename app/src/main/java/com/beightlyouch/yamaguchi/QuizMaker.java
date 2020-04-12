package com.beightlyouch.yamaguchi;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.beightlyouch.yamaguchi.QuizDataCity.getCityNum;

public class QuizMaker {

    private int answer_num;
    private ArrayList<Integer> choices;
    private int question_num;
    private ArrayList<Integer> answers = new ArrayList<Integer>();

    //引数なしコンストラクタ
    public QuizMaker() {
    }

    //答えを決める
    public int getAnswer_City() {
        Random rand = new Random();
        int answer = rand.nextInt(19);
        while(!goodAnswer(answers, answer)) {
            answer = rand.nextInt(19);
        }
        answers.add(answer);
        return answer;
    }

    public ArrayList<Integer> getWrongs() {
        ArrayList<Integer> wrongs = new ArrayList<Integer>();

        while(wrongs.size() < 3){
            Random rand = new Random();
            int randomNumber = rand.nextInt(19);
            if(goodWrongs(wrongs, randomNumber)){
                wrongs.add(randomNumber);
            }
        }
        return wrongs;
    }

    //4択を重複させない
    public boolean goodWrongs(ArrayList<Integer> wrongs, int randomNumber){
        for(int i=0; i<wrongs.size(); i++){
            if(wrongs.get(i)==randomNumber && getAnswer_City()==randomNumber){
                Log.d("よろ", wrongs.toString());
                return false;
            }
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
        int answer = getAnswer_City();
        choices.add(answer);
        Collections.shuffle(choices);

        for(int i=0; i<4; i++) {
            if(choices.get(i) == answer) {
                setAnswer_num(i);
            }
        }
        this.setChoices(choices);
    }

    //回答の選択肢の番号
    public int getAnswer_num() { return answer_num; }

    public void setAnswer_num(int answer_num) { this.answer_num = answer_num; }

    public ArrayList<Integer> getChoices() { return choices; }

    public void setChoices(ArrayList<Integer> choices) { this.choices = choices; }

    public int getQuestion_num() { return question_num; }

    public void setQuestion_num(int question_num) { this.question_num = question_num; }
}
