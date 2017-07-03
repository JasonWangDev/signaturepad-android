package com.github.jasonwangdev.signaturepad.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.jasonwangdev.signaturepad.SignaturePadDialogFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        SignaturePadDialogFragment dialogFragment = SignaturePadDialogFragment.getInstance();
        dialogFragment.show(getSupportFragmentManager(), "SignaturePadDialogFragment");
    }

}
