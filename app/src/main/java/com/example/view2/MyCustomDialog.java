package com.example.view2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.NonNull;

public class MyCustomDialog extends Dialog {
    ImageButton btnOk, btnCancel;
    Activity activity;

    public MyCustomDialog(@NonNull Context context){
        super(context);
        this.activity=(Activity) context;
        setContentView(R.layout.custom_dialg);
        linkViews();
        setCanceledOnTouchOutside(false);
        addEvents();
    }
    private void linkViews() {
        btnOk=findViewById(R.id.btnOk);
        btnCancel=findViewById(R.id.btnCancel);
    }
    private void addEvents() {
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
