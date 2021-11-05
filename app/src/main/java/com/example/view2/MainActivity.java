package com.example.view2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnShowDialog,btnShowCustomDialog, btnShowCustomeDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinkViews();
        addEvents();
    }

    private void LinkViews() {
        btnShow=findViewById(R.id.btnShowToast);
        btnShowDialog=findViewById(R.id.btnShowDialog);
        btnShowCustomDialog=findViewById(R.id.btnShowCustomDialog);
        btnShowCustomeDialog2=findViewById(R.id.btnShowCustomDialog2);
    }

    private void addEvents() {
        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              Toast t = Toast.makeText(MainActivity.this,"Hello",Toast.LENGTH_SHORT);
              t.setGravity(Gravity.CENTER, 20,0);
              t.show();
            }
        });
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc muốn thoát app?");
                builder.setIcon(android.R.drawable.ic_dialog_info);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog=builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
            }
        });
        btnShowCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
                MyCustomDialog myCustomDialog=new MyCustomDialog(MainActivity.this);
                myCustomDialog.show();
            }
        });

        btnShowCustomeDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //createDialog();
               MyCustomDialog dialog=new MyCustomDialog(MainActivity.this);
               dialog.show();
            }
        });

    }
    public void createDialog() {
        Dialog dialog= new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialg);
        ImageButton btnOk=dialog.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ImageButton btnCancel=dialog.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}