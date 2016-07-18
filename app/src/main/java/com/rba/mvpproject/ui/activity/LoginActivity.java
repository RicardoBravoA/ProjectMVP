package com.rba.mvpproject.ui.activity;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.rba.mvpproject.R;
import com.rba.mvpproject.model.response.UserResponse;
import com.rba.mvpproject.ui.view.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextInputEditText tieEmail, tiePassword;
    private TextInputLayout tilEmail, tilPassword;
    private AppCompatButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        initUI();
    }

    private void initUI(){
        tieEmail = (TextInputEditText) findViewById(R.id.tieEmail);
        tiePassword = (TextInputEditText) findViewById(R.id.tiePassword);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        btnLogin = (AppCompatButton) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:

                break;
            default:
                break;
        }
    }

    private void validate(){

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void next(UserResponse userResponse) {

    }
}
