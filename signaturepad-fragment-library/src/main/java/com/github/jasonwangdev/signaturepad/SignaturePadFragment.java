package com.github.jasonwangdev.signaturepad;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.gcacace.signaturepad.views.SignaturePad;

/**
 * Created by jason on 2017/7/3.
 */

public class SignaturePadFragment extends Fragment implements SignaturePad.OnSignedListener, View.OnClickListener {

    private OnSignaturePadListener onSignaturePadListener;

    private SignaturePad signaturePad;


    public static SignaturePadFragment getInstance() {
        Bundle bundle = new Bundle();

        SignaturePadFragment dialogFragment = new SignaturePadFragment();
        dialogFragment.setArguments(bundle);

        return dialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment_signaturepad, container, false);

        signaturePad = view.findViewById(R.id.signaturepad);
        signaturePad.setOnSignedListener(this);

        Button btnClear = view.findViewById(R.id.btn_clear);
        Button btnSave = view.findViewById(R.id.btn_save);

        btnClear.setEnabled(false);
        btnSave.setEnabled(false);

        btnClear.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.btn_clear)
            signaturePad.clear();
        else if (i == R.id.btn_save)
        {
            if (null != onSignaturePadListener)
            {
                Bitmap sign = signaturePad.getTransparentSignatureBitmap();
                onSignaturePadListener.onSaved(sign);
            }
        }
    }


    @Override
    public void onStartSigning() { }

    @Override
    public void onSigned() {
        getView().findViewById(R.id.btn_clear).setEnabled(true);
        getView().findViewById(R.id.btn_save).setEnabled(true);
    }

    @Override
    public void onClear() {
        getView().findViewById(R.id.btn_clear).setEnabled(false);
        getView().findViewById(R.id.btn_save).setEnabled(false);
    }


    public void setOnSignaturePadListener(OnSignaturePadListener onSignaturePadListener) {
        this.onSignaturePadListener = onSignaturePadListener;
    }

}
