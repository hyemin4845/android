package org.techtown.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.result);
        Button button2 = (Button) findViewById(R.id.oneMore);
        height = (EditText) findViewById(R.id.heightText);
        weight = (EditText) findViewById(R.id.weightText);
        result = (EditText) findViewById(R.id.resultText);
    }

    public void result(View v){
        String h = height.getText().toString();
        String w = weight.getText().toString();

        if (h != null && !"".equals(h)
                && w != null && !"".equals(w)) {
            float heightValue = Float.parseFloat(h) / 100;
            float weightValue = Float.parseFloat(w);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }

    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (bmi < 18.5) {
            Toast.makeText(getApplicationContext(), "저체중입니다.", Toast.LENGTH_SHORT).show();
        }
        else if (bmi < 25.0) {
            Toast.makeText(getApplicationContext(), "정상입니다.", Toast.LENGTH_SHORT).show();
        }
        else if (bmi < 30.0) {
            Toast.makeText(getApplicationContext(), "과체중입니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "비만입니다.", Toast.LENGTH_SHORT).show();
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }

    public void oneMore(View v) {
        height.setText(null);
        weight.setText(null);
        result.setText(null);
        Toast.makeText(getApplicationContext(), "다른 값을 입력하세요!", Toast.LENGTH_SHORT).show();
    }

}
