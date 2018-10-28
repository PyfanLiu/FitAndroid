package com.wjz.www.dialogfragmentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

    }

    private void initView() {
        mButton= (Button) this.findViewById(R.id.btn_pay);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PayDetailFragment payDetailFragment=new PayDetailFragment();
                payDetailFragment.show(getSupportFragmentManager(),"payDetailFragment");
            }
        });
    }

}
