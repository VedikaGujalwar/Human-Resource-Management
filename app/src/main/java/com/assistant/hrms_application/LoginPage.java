package com.assistant.hrms_application;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;

import java.util.concurrent.Executor;

public class LoginPage extends AppCompatActivity {

    TextView forgotpass;
    MaterialButton login;
    EditText username,password;
    Toolbar toolbar;
    RelativeLayout layout;

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = findViewById(R.id.toolbar);
        forgotpass = findViewById(R.id.forgotpass);
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        layout = findViewById(R.id.layout);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("ADMIN") && password.getText().toString().equals("admin"))
                {
                    //Profilepage from sanskruti
                    Intent intent = new Intent(LoginPage.this, ProfilePage.class);
                    startActivity(intent);
                    Toast.makeText(LoginPage.this, "Logged-In Successful", Toast.LENGTH_SHORT).show();
                }
                else              //login-in denied
                {
                    Toast.makeText(LoginPage.this, "Login Invalid.. Please enter valid Details", Toast.LENGTH_SHORT).show();
                }

            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //direct to new page with email details to retrieve the password.
            }
        });

        //Biometric code
        BiometricManager biometricManager = BiometricManager.from(this);
        switch(biometricManager.canAuthenticate())          //cases for biometric detection
        {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(),"Device doesn't have fingerprint",Toast.LENGTH_SHORT).show();
                break;

            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(),"Device not working",Toast.LENGTH_SHORT).show();
                break;

            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getApplicationContext(),"No fingerprint assigned",Toast.LENGTH_SHORT).show();
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(LoginPage.this, executor,
                new BiometricPrompt.AuthenticationCallback() {
                    //3 error classes
                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                    }

                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        Toast.makeText(getApplicationContext(),"Logged in Secussfully",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                    }
                });

        promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Hello").
                setDescription("Use fingerprint to login").setDeviceCredentialAllowed(true).build();
        biometricPrompt.authenticate(promptInfo);
    }
}
