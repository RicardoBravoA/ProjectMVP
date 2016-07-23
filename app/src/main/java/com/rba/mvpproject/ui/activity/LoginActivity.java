package com.rba.mvpproject.ui.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Toast;

import com.rba.mvpproject.R;
import com.rba.mvpproject.presenter.LoginPresenter;
import com.rba.mvpproject.storage.session.SessionManager;
import com.rba.mvpproject.ui.view.LoginView;
import com.rba.mvpproject.util.Constant;
import com.rba.mvpproject.util.Util;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private TextInputEditText tieEmail, tiePassword;
    private TextInputLayout tilEmail, tilPassword;
    private AppCompatButton btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        loginPresenter = new LoginPresenter(this);
        validSession();

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
                    validate();
                break;
            default:
                break;
        }
    }

    private void validate(){
        if(!validEmail()){
            return;
        }

        if(!validPassword()){
            return;
        }

        Map<String, String> data = new HashMap<>();
        data.put(Constant.KEY_EMAIL, tieEmail.getText().toString().trim());
        data.put(Constant.KEY_PASSWORD, tiePassword.getText().toString().trim());

        loginPresenter.login(data);
    }

    private boolean validEmail(){
        if(!tieEmail.getText().toString().isEmpty()){
            if(Util.validEmail(tieEmail.getText().toString().trim())){
                return true;
            }
        }
        tilEmail.requestFocus();
        Util.onErrorView(this, tilEmail);
        return false;
    }

    private boolean validPassword(){
        if(!tiePassword.getText().toString().trim().isEmpty()){
            if(tiePassword.getText().toString().trim().length()>5){
                return true;
            }
        }
        tilPassword.requestFocus();
        Util.onErrorView(this, tilPassword);
        return false;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void next() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void validSession() {
        if(SessionManager.isSession(this)){
            next();
        }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
