package com.github.jasonwangdev.signaturepad.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.jasonwangdev.signaturepad.OnSignaturePadListener;
import com.github.jasonwangdev.signaturepad.SignaturePadFragment;

/**
 * Created by Jason on 2017/7/4.
 */

public class MainFragment extends Fragment implements View.OnClickListener, OnSignaturePadListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        view.findViewById(R.id.btn).setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        SignaturePadFragment fragment = SignaturePadFragment.getInstance();
        fragment.setOnSignaturePadListener(this);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.layout, fragment, "SignaturePadFragment");
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onSaved(Bitmap sign) {
        ((ImageView) getView().findViewById(R.id.iv)).setImageBitmap(sign);
    }

}
