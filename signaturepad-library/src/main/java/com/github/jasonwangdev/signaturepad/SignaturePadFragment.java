package com.github.jasonwangdev.signaturepad;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.gcacace.signaturepad.views.SignaturePad;

/**
 * Created by jason on 2017/7/3.
 */

public class SignaturePadFragment extends Fragment implements SignaturePad.OnSignedListener, View.OnClickListener {

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

        Log.d("TAG", "onCreateView");
//        view.findViewById(R.id.btn_clear).setOnClickListener(this);
//        view.findViewById(R.id.btn_cancel).setOnClickListener(this);
//        view.findViewById(R.id.btn_save).setOnClickListener(this);

        signaturePad = view.findViewById(R.id.signaturepad);
        signaturePad.setOnSignedListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
//        int i = view.getId();
//        if (i == R.id.btn_clear)
//            signaturePad.clear();
//        else if (i == R.id.btn_cancel)
//            this.dismiss();
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

}
