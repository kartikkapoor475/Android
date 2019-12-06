package com.example.drum;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View .OnClickListener{//Listener lgana is lengthy to hm implement kr denege

    MediaPlayer one,two,three,four,five,six,seven,eight;// tp import media
    int[] colors={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six};
    int magic[]={R.drawable.tap,R.drawable.tap1,R.drawable.tap2,R.drawable.tap3,R.drawable.tap4,R.drawable.tap6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         one=MediaPlayer.create(MainActivity.this,R.raw.one);
        two=MediaPlayer.create(MainActivity.this,R.raw.two);
        three=MediaPlayer.create(MainActivity.this,R.raw.three);
        four=MediaPlayer.create(MainActivity.this,R.raw.four);
        five=MediaPlayer.create(MainActivity.this,R.raw.fv);
        six=MediaPlayer.create(MainActivity.this,R.raw.sixth);
        seven=MediaPlayer.create(MainActivity.this,R.raw.seventh);
        eight=MediaPlayer.create(MainActivity.this,R.raw.eighth);




    }

    @Override
    public void onClick(View view) {


        int id=view.getId();// id k andr hai R.v.one
int rand;
try {
    switch (id) {

        case R.id.one:
            one.start();
            rand = (int)Math.abs( Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.two:
            two.start();
            rand = (int) Math.abs( Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.three:
            three.start();
            rand = (int) Math.abs(Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.four:
            four.start();
            rand = (int) Math.abs( Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.five:
            five.start();
            rand = (int) Math.abs( Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.six:
            six.start();
            rand = (int) Math.abs( Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.seven:
            seven.start();
            rand = (int) Math.abs( Math.round(Math.random() * (magic.length - 1)));
            view.setBackgroundResource(magic[rand]);
            break;
        case R.id.eight:
            eight.start();
            rand = (int) Math.abs( Math.round(Math.random() * (magic.length - 1))) ;
            view.setBackgroundResource(magic[rand]);
            break;
        default:
            break;

    }


}
catch(Exception e){

        }



    }
}
