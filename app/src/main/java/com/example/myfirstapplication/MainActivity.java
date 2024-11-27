package com.example.myfirstapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    TextView result;
    int num1 = 0, num2 = 0;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        result = findViewById(R.id.resultOfCalculation);
        result.setText("");

    }

    public void numFunc(View view)
    {

        Button b = (Button) view;
        String buttonText = b.getText().toString();

        result.setText(result.getText() + buttonText);

        if(num1 != 0)
        {
            num2 = Integer.parseInt(buttonText) + num2*10;
        }

    }


    public void operatorFunction(View view)
    {
        Button b = (Button) view;
        String buttonText = b.getText().toString();

        num1 = Integer.parseInt(result.getText().toString());

        result.setText(result.getText() + buttonText);

        operator = buttonText.charAt(0);

    }

    public void equalsFunction(View view)
    {
        try {

            switch (operator) {
                case '+':
                    result.setText(result.getText() + "=" + (num1 + num2));
                    break;
                case '-':
                    result.setText(result.getText() + "=" + (num1 - num2));
                    break;
                case '*':
                    result.setText(result.getText() + "=" + (num1 * num2));
                    break;
                case '/':
                    result.setText(result.getText() + "=" + (num1 / num2));
                    break;
            }
        }
        catch(ArithmeticException e)
        {
            result.setText("Cannot Divide By Zero!");
        }
    }

    public void clearFunction(View view)
    {
        result.setText("");
        num1 = 0;
        num2 = 0;
    }
}