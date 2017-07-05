package com.github.jasonwangdev.signaturepad;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.github.gcacace.signaturepad.views.SignaturePad;

/**
 * Created by jason on 2017/7/3.
 */

public class SignaturePadDialogFragment extends DialogFragment implements SignaturePad.OnSignedListener, View.OnClickListener {

    private OnSignaturePadListener onSignaturePadListener;

    private SignaturePad signaturePad;


    public static SignaturePadDialogFragment getInstance() {
        Bundle bundle = new Bundle();

        SignaturePadDialogFragment signaturePadDialogFragment = new SignaturePadDialogFragment();
        signaturePadDialogFragment.setArguments(bundle);

        return signaturePadDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setNoTitle();

        View view = inflater.inflate(R.layout.dialogfragment_signaturepad, container, false);

        signaturePad = (SignaturePad) view.findViewById(R.id.signaturepad);
        signaturePad.setOnSignedListener(this);

        Button btnClear = (Button) view.findViewById(R.id.btn_clear);
        Button btnSave = (Button) view.findViewById(R.id.btn_save);

        btnClear.setEnabled(false);
        btnSave.setEnabled(false);

        btnClear.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        setWindowSize();
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

            dismiss();
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


    private void setNoTitle() {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    }

    private void setWindowSize() {
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

}
