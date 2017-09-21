package com.example.jomosque.facebooklogin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



public class MainActivity extends AppCompatActivity {


    LoginButton loginButton;
    TextView textView;

    CallbackManager callbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        loginButton = (LoginButton)findViewById(R.id.fb_login_bn);
        textView = (TextView)findViewById(R.id.textView);

        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show();


            }

            @Override
            public void onError(FacebookException error) {                  textView.setText("Login Error");
                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_LONG).show();

            }
        });

    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
}
