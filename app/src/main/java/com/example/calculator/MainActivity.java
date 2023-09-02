package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, sum, result,mresult,dresult;
    private String operation;
    private Boolean isOperationClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

    }

    public void oneNumberClick(View view) {
        String textButton = ((Button) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationClick = false;

    }


    public void oneOperationClick(View view) {
        String textButton = ((Button) view).getText().toString();
        switch (textButton) {
            case "+":
                first = Integer.valueOf(textView.getText().toString());
                operation = "+";
                break;
            case "-":
                first = Integer.valueOf(textView.getText().toString());
                operation = "-";
                break;
            case "x":

                first = Integer.valueOf(textView.getText().toString());
                operation = "x";
                break;
            case "/":

                first = Integer.valueOf(textView.getText().toString());
                operation = "/";
                break;
            case "=":


                second = Integer.valueOf(textView.getText().toString());
                switch (operation) {
                    case "+":
                        sum = first + second;
                        textView.setText(sum.toString());
                        break;
                    case "-":
                        result = first - second;
                        textView.setText(result.toString());
                        break;
                    case "x":
                        mresult = first * second;
                        textView.setText(mresult.toString());
                        break;
                    case "/":
                        if (second!=0){
                            dresult=first/second;
                            textView.setText(dresult.toString());
                        }else if (second==0) {
                            textView.setText("Ошибка");
                        }
                        break;
                }

                break;
        }
        isOperationClick = true;
    }

}