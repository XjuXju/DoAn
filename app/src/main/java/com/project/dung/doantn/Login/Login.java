package com.project.dung.doantn.Login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.dung.doantn.R;
import com.project.dung.doantn.socket.SendRequest;

public class Login extends AppCompatActivity {
    EditText etUser, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPass = (EditText) findViewById(R.id.etPass);
        etUser = (EditText) findViewById(R.id.etUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uer =  etUser.getText().toString();
                String pass = etPass.getText().toString();
                Log.i("user", uer+" "+pass);
                Toast.makeText(Login.this, "gia tri user :"+uer+pass, Toast.LENGTH_SHORT).show();
                new SendRequest(uer, pass).start();
            }
        });
    }
}
