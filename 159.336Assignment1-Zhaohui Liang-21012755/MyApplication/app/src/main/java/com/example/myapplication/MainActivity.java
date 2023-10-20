package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button dial, a1,a2,a3,b1,b2,b3,c1,c2,c3,d1,d2,d3,delete;
    EditText phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent_tel = getIntent();

        dial = findViewById(R.id.dial);
        phone = findViewById(R.id.phone);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        delete = findViewById(R.id.delete);

        a1.setOnClickListener(new A1listener());
        a2.setOnClickListener(new A2listener());
        a3.setOnClickListener(new A3listener());
        b1.setOnClickListener(new B1listener());
        b2.setOnClickListener(new B2listener());
        b3.setOnClickListener(new B3listener());
        c1.setOnClickListener(new C1listener());
        c2.setOnClickListener(new C2listener());
        c3.setOnClickListener(new C3listener());
        d1.setOnClickListener(new D1listener());
        d2.setOnClickListener(new D2listener());
        d3.setOnClickListener(new D3listener());
        dial.setOnClickListener(new Diallistener());
        delete.setOnClickListener(new Deletelistener());

        if(shouldAskPermissions()){
            askPermissions();
        }

        if (intent_tel.getData() != null){
            String num = intent_tel.getData().toString();
            //correct the form of phone number
            num = num.substring(4);
            phone.setText(num);
        }

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);

    }

    //press the button and read the data of button
    private class A1listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = a1.getText().toString();
            phone.append(ch);
        }
    }

    private class A2listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = a2.getText().toString();
            phone.append(ch);
        }
    }

    private class A3listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = a3.getText().toString();
            phone.append(ch);
        }
    }

    private class B1listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = b1.getText().toString();
            phone.append(ch);
        }
    }

    private class B2listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = b2.getText().toString();
            phone.append(ch);
        }
    }

    private class B3listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = b3.getText().toString();
            phone.append(ch);
        }
    }

    private class C1listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = c1.getText().toString();
            phone.append(ch);
        }
    }

    private class C2listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = c2.getText().toString();
            phone.append(ch);
        }
    }

    private class C3listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = c3.getText().toString();
            phone.append(ch);
        }
    }

    private class D1listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = d1.getText().toString();
            phone.append(ch);
        }
    }

    private class D2listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = d2.getText().toString();
            phone.append(ch);
        }
    }

    private class D3listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String ch = d3.getText().toString();
            phone.append(ch);
        }
    }

    private class Diallistener implements View

            .OnClickListener{

        @Override
        public void onClick(View view) {
            String number = phone.getText().toString();
            Intent intent = new Intent();
            intent.setAction(intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
    }

    private class Deletelistener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int index=phone.getSelectionStart();   //get the position of Edittext
            String str=phone.getText().toString();
            if (!str.equals("")) {                 //if not null, delete the data
                phone.getText().delete(index-1,index);
            }
        }
    }



    protected boolean shouldAskPermissions(){       //Block soft keyboards
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    protected void askPermissions(){
        String[] permissions = {
                "android.permission.CALL_PHONE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }
}