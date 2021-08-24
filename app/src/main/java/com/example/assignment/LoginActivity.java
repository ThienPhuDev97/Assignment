package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        Button btnLogin =findViewById(R.id.btnLogin);
        EditText email = findViewById(R.id.lgEmail);
        EditText pass = findViewById(R.id.lgPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtEmail = email.getText().toString();
                String txtPass = pass.getText().toString();
               // Toast.makeText(LoginActivity.this,txtPass+txtEmail,Toast.LENGTH_SHORT).show();
                loginUser(txtEmail,txtPass);

            }
        });
    }

//    private void loginUser(String email, String pass) {
//        Toast.makeText(LoginActivity.this,email+pass,Toast.LENGTH_SHORT).show();
//        auth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(
//                new OnSuccessListener<AuthResult>() {
//            @Override
//            public void onSuccess(AuthResult authResult) {
//                Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                finish();
//            }
//        });

        private void loginUser(String email, String pass){
        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this,"Email or password Invalid",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }


}