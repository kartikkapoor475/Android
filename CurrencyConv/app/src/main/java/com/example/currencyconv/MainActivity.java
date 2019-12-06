package com.example.currencyconv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View .OnClickListener{


    EditText ed1;
    TextView ed2;
    Button usd,yen,euro;
    double ruppee;
    double result;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //finding id's
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        usd=findViewById(R.id.usd);
        yen=findViewById(R.id.yen);
        euro=findViewById(R.id.euro);

        // get krna hai edit vale se double mai convert kr dena then
        //set kr dena usse niche vale mai





    }

    @Override
    public void onClick(View view) {
        int id=view.getId();

        try {

            switch (id) {
                case R.id.euro:
                    ruppee = Double.valueOf("" + ed1.getText());
                    result = 0.013 * ruppee;
                    ed2.setText("" + result);
                    break;

                case R.id.yen:
                    ruppee = Double.valueOf("" + ed1.getText());
                    result = 1.56 * ruppee;
                    ed2.setText("" + result);
                    break;

                case R.id.usd:
                    ruppee = Double.valueOf("" + ed1.getText());
                    result = 0.014 * ruppee;
                    ed2.setText("" + result);
                    break;
            }
        }
        catch (Exception e){}
    }
}
