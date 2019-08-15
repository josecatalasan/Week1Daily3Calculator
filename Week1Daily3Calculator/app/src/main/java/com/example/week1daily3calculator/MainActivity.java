package com.example.week1daily3calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG_MAIN_ACT";
    private TextView tvDisplay;
    private TextView tvResult;
    private Button pi;
    private Button eConstant;
    private Button inverse;
    private Button absoluteValue;

    private String tvInput = "0";
    private Double previous = null;
    private Character onHandOperation = null;
    private String resultInput = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previous = null;
        onHandOperation = null;
        tvInput = "0";

        tvDisplay = findViewById(R.id.tvDisplay);
        tvResult = findViewById(R.id.tvResult);
        pi = findViewById(R.id.pi);
        eConstant = findViewById(R.id.eConstant);
        inverse = findViewById(R.id.inverse);
        absoluteValue = findViewById(R.id.absoluteValue);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            pi.setVisibility(View.VISIBLE);
            eConstant.setVisibility(View.VISIBLE);
            inverse.setVisibility(View.VISIBLE);
            absoluteValue.setVisibility(View.VISIBLE);
        } else {
            pi.setVisibility(View.GONE);
            eConstant.setVisibility(View.GONE);
            inverse.setVisibility(View.GONE);
            absoluteValue.setVisibility(View.GONE);
        }

        tvDisplay.setText(tvInput);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void buttonClicked(View view){
        switch(view.getId()){
            //add button presses and calculation
            case R.id.allClear:
                tvInput = "0";
                resultInput = null;
                previous = null;
                onHandOperation = null;
                tvDisplay.setText(tvInput);
                tvResult.setText(" ");
                break;
            case R.id.clearEntry:
                tvInput = "0";
                tvDisplay.setText(tvInput);
                break;
            case R.id.decimal:
                if(!tvInput.contains("."))
                    tvInput += ".";
                tvDisplay.setText(tvInput);
                break;
            case R.id.divide:
                if(tvInput.endsWith("."))
                    tvInput += "0";
                if(previous == null && onHandOperation == null){ //only after equals and clear
                    previous = Double.parseDouble(tvInput);
                    onHandOperation = '/';
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                }

                if(resultInput != null){
                    previous = Double.parseDouble(resultInput);
                    onHandOperation = '/';

                    resultInput = null; //clear
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                    tvResult.setText(Double.toString(previous));
                }
                break;
            case R.id.multiply:
                if(tvInput.endsWith("."))
                    tvInput += "0";
                if(previous == null && onHandOperation == null){ //only after equals and clear
                    previous = Double.parseDouble(tvInput);
                    onHandOperation = '*';
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                }

                if(resultInput != null){
                    previous = Double.parseDouble(resultInput);
                    onHandOperation = '*';

                    resultInput = null; //clear
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                    tvResult.setText(Double.toString(previous));
                }
                break;
            case R.id.add:
                if(tvInput.endsWith("."))
                    tvInput += "0";

                if(previous == null && onHandOperation == null){ //only after equals and clear
                    previous = Double.parseDouble(tvInput);
                    onHandOperation = '+';
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                }

                if(resultInput != null){
                    previous = Double.parseDouble(resultInput);
                    onHandOperation = '+';

                    resultInput = null; //clear
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                    tvResult.setText(Double.toString(previous));
                }
                break;
            case R.id.subtract:
                if(tvInput.endsWith("."))
                    tvInput += "0";

                if(previous == null && onHandOperation == null){ //only after equals and clear
                    previous = Double.parseDouble(tvInput);
                    onHandOperation = '-';
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                }

                if(resultInput != null){
                    previous = Double.parseDouble(resultInput);
                    onHandOperation = '-';

                    resultInput = null; //clear
                    tvInput = "0";
                    tvDisplay.setText(tvInput);
                    tvResult.setText(Double.toString(previous));
                }
                break;
            case R.id.equals:
                if(resultInput != null){
                    tvInput = resultInput;
                    resultInput = null;
                    onHandOperation = null;
                    tvResult.setText(" ");
                    tvDisplay.setText(tvInput);
                }
                break;
            case R.id.percentile:
                tvInput = Double.toString((Double.parseDouble(tvInput)/100));
                tvDisplay.setText(tvInput);
                break;
            case R.id.negative:
                tvInput = Double.toString((Double.parseDouble(tvInput)*-1));
                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }
                tvDisplay.setText(tvInput);
                break;
            case R.id.zero:
                if (!tvInput.equals("0")){
                    tvInput += "0";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.one:
                if (tvInput.equals("0")){
                    tvInput = "1";
                } else {
                    tvInput += "1";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.two:
                if (tvInput.equals("0")){
                    tvInput = "2";
                } else {
                    tvInput += "2";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.three:
                if (tvInput.equals("0")){
                    tvInput = "3";
                } else {
                    tvInput += "3";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.four:
                if (tvInput.equals("0")){
                    tvInput = "4";
                } else {
                    tvInput += "4";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.five:
                if (tvInput.equals("0")){
                    tvInput = "5";
                } else {
                    tvInput += "5";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.six:
                if (tvInput.equals("0")){
                    tvInput = "6";
                } else {
                    tvInput += "6";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.seven:
                if (tvInput.equals("0")){
                    tvInput = "7";
                } else {
                    tvInput += "7";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.eight:
                if (tvInput.equals("0")){
                    tvInput = "8";
                } else {
                    tvInput += "8";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.nine:
                if (tvInput.equals("0")){
                    tvInput = "9";
                } else {
                    tvInput += "9";
                }

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;

            case R.id.pi:
                tvInput = "3.1415926535";

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.eConstant:
                tvInput = "2.7182818284";

                if(previous != null && onHandOperation != null){
                    resultInput = compute(tvInput,previous,onHandOperation);
                    tvResult.setText(resultInput);
                }

                tvDisplay.setText(tvInput);
                break;
            case R.id.absoluteValue:
                if(Double.parseDouble(tvInput) < 0)
                    tvInput = Double.toString(Double.parseDouble(tvInput) * (-1));
                tvDisplay.setText(tvInput);
                break;
            case R.id.inverse:
                if(Double.parseDouble(tvInput) != 0){
                    tvInput = Double.toString(1 / Double.parseDouble(tvInput) );
                }
                tvDisplay.setText(tvInput);

        }
    }

    public String compute(String text, Double prev, Character operation) {
        switch(operation.charValue()){
            case '+':
                return Double.toString(Double.parseDouble(text) + prev);
            case '-':
                return Double.toString(prev - Double.parseDouble(text));
            case '*':
                return Double.toString(Double.parseDouble(text) * prev);
            case '/':
                return Double.toString(prev / Double.parseDouble(text));
        }
        return null; //should never get here
    }
}
