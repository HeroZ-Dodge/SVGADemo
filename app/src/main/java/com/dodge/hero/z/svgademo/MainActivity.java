package com.dodge.hero.z.svgademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ViewGroup mParent;
    private EditText mEtDelay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mParent = (ViewGroup) findViewById(R.id.layout_parent);
        mEtDelay = (EditText) findViewById(R.id.et_delay);
        Button btnAddView = (Button) findViewById(R.id.btn_add);
        btnAddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSVAGView();
            }
        });
    }

    private void addSVAGView() {
        LayoutInflater inflater  = LayoutInflater.from(this);
        final View view = inflater.inflate(R.layout.demo_include_svag_view, mParent, false);
        long delay = Long.valueOf(mEtDelay.getText().toString());
        mParent.addView(view);
        mParent.postDelayed(new Runnable() {
            @Override
            public void run() {
                mParent.removeView(view);
            }
        }, delay);
    }

}
