package com.wjz.androidtransitionanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wjz.androidtransitionanimation.indicate.IndicateActActivity;
import com.wjz.androidtransitionanimation.textv.TextViewActActivity;
import com.wjz.androidtransitionanimation.transition.TransitionActivity;
import com.wjz.androidtransitionanimation.transition.TransitionExplodeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mBtnOne = (Button) findViewById(R.id.btn_one);
        mBtnOne.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,TransitionActivity.class)));

        Button mBtnExplode = (Button) findViewById(R.id.btn_explode);
        mBtnExplode.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, TransitionExplodeActivity.class)));

    }

    public void toVector(View view) {
        startActivity(new Intent(this, VectorActActivity.class));
    }

    public void toTextViewAct(View view) {
        startActivity(new Intent(this, TextViewActActivity.class));
    }

    public void toIndicator(View view) {
        startActivity(new Intent(this, IndicateActActivity.class));
    }
}
