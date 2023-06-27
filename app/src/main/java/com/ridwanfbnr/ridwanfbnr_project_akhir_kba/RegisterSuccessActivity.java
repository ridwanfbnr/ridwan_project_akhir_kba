package com.ridwanfbnr.ridwanfbnr_project_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ActivityRegisterSuccessBinding;

public class RegisterSuccessActivity extends AppCompatActivity {

    ActivityRegisterSuccessBinding activityRegisterSuccessBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterSuccessBinding = ActivityRegisterSuccessBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterSuccessBinding.getRoot());

        activityRegisterSuccessBinding.btnLoginRegisterSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(RegisterSuccessActivity.this, LoginActivity.class);
                startActivity(login);
                finishAffinity();
            }
        });
    }
}