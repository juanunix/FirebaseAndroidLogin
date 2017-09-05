package com.example.naman.firebaselogin.activity.login;

/**
 * Created by Ant on 23-06-2017.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.naman.firebaselogin.R;

public class VerifyEmailActivity extends AppCompatActivity {

    private Button btnVerify, btnBack;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyemail);

        btnVerify = (Button) findViewById(R.id.btn_verifyemail);
        btnBack = (Button) findViewById(R.id.btn_back);

        auth = FirebaseAuth.getInstance();

//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//                if (firebaseUser != null ) {
//                    Log.e("FirebaseAuth ", firebaseUser.isEmailVerified() ? "User is signed in and email is verified" : "Email is not verified");
//                    if(firebaseUser.isEmailVerified()) {
//                        startActivity(new Intent(VerifyEmailActivity.this, HomeScreenActivity.class));
//                        finish();
//                    }
//                } else {
//                    Log.e("FirebaseAuth ", "onAuthStateChanged:signed_out");
//                }
//            }
//        };
//        auth.addAuthStateListener(mAuthListener);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerificationEmail();
            }
        });
    }

    private void sendVerificationEmail(){
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            user.sendEmailVerification()
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(VerifyEmailActivity.this, "Verification email sent", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(VerifyEmailActivity.this, "Can't send verification email, try again later.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }

    }

}