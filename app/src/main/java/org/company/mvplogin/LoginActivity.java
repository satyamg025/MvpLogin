package org.company.mvplogin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoginInterfaces.loginView {

    EditText email,password;
    Button btn;

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter=new LoginPresenter(this);

    }

    @Override
    public void initView() {
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onClick(email.getText().toString(),password.getText().toString());
            }
        });
    }

    @Override
    public void loginValidation() {
        Toast.makeText(this,"Please Fill all fields",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
    }
}

