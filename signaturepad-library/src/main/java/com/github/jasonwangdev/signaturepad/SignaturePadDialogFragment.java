package com.github.jasonwangdev.signaturepad;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.github.gcacace.signaturepad.views.SignaturePad;

/**
 * Created by jason on 2017/7/3.
 */

public class SignaturePadDialogFragment extends DialogFragment implements SignaturePad.OnSignedListener, View.OnClickListener {

    private SignaturePad signaturePad;


    public static SignaturePadDialogFragment getInstance() {
        Bundle bundle = new Bundle();

        SignaturePadDialogFragment dialogFragment = new SignaturePadDialogFragment();
        dialogFragment.setArguments(bundle);

        return dialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.dialogfragment_signaturepad, container, false);

        view.findViewById(R.id.btn_clear).setOnClickListener(this);
        view.findViewById(R.id.btn_cancel).setOnClickListener(this);
        view.findViewById(R.id.btn_save).setOnClickListener(this);

        signaturePad = view.findViewById(R.id.signaturepad);
        signaturePad.setOnSignedListener(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        resize();
    }


    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_clear)
            signaturePad.clear();
        else if (i == R.id.btn_cancel)
            this.dismiss();
//        else if (i == R.id.btn_save)

    }

    @Override
    public void onStartSigning() {

    }

    @Override
    public void onSigned() {

    }

    @Override
    public void onClear() {

    }


    private void resize() {
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        switch (screenSize)
        {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                setLargeSize();
                break;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                setXLargeSize();
                break;

            default:
                setNormalSize();
                break;
        }
    }

    private void setLargeSize() {
        int orientation = getResources().getConfiguration().orientation;
        switch (orientation)
        {
            case Configuration.ORIENTATION_LANDSCAPE:
                setSize((int) convertDpToPixel(700),
                        (int) convertDpToPixel(400));
                break;

            case Configuration.ORIENTATION_PORTRAIT:
                setSize((int) convertDpToPixel(550),
                        (int) convertDpToPixel(300));
                break;
        }
    }

    private void setXLargeSize() {
        int orientation = getResources().getConfiguration().orientation;
        switch (orientation)
        {
            case Configuration.ORIENTATION_LANDSCAPE:
                setSize((int) convertDpToPixel(700),
                        (int) convertDpToPixel(400));
                break;

            case Configuration.ORIENTATION_PORTRAIT:
                setSize((int) convertDpToPixel(550),
                        (int) convertDpToPixel(300));
                break;
        }
    }

    private void setNormalSize() {
        int orientation = getResources().getConfiguration().orientation;
        switch (orientation)
        {
            case Configuration.ORIENTATION_LANDSCAPE:
                setSize(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                break;

            case Configuration.ORIENTATION_PORTRAIT:
                setSize(ViewGroup.LayoutParams.MATCH_PARENT,
                        (int) convertDpToPixel(280));
                break;
        }
    }

    private void setSize(int width, int height) {
        Dialog dialog = getDialog();
        if (null != dialog)
            dialog.getWindow().setLayout(width, height);
    }

    private float convertDpToPixel(float dp){
        float px = dp * getDensity();

        return px;
    }

    private float getDensity(){
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();

        return metrics.density;
    }

}
