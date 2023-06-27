package com.ridwanfbnr.ridwanfbnr_project_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.ApiConfig;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.register.ResponseRegister;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRegisterBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(activityRegisterBinding.getRoot());

        activityRegisterBinding.tvPunyaAkunRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        activityRegisterBinding.btnRegisterRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = activityRegisterBinding.edtUsernameRegister.getText().toString().trim();
                String email = activityRegisterBinding.edtEmailRegister.getText().toString().trim();
                String password = activityRegisterBinding.edtPasswordRegister.getText().toString().trim();

                if(TextUtils.isEmpty(userName)) {
                    activityRegisterBinding.edtUsernameRegister.setError("username harus diisi!");
                } else if(TextUtils.isEmpty(email)) {
                    activityRegisterBinding.edtEmailRegister.setError("Email harus diisi!");
                } else if(TextUtils.isEmpty(password)) {
                    activityRegisterBinding.edtPasswordRegister.setError("Password harus diisi!");
                } else {
                    register(userName, email, password);
                }
            }
        });
    }

    private void register(String userName, String email, String password) {
        ApiConfig.service.requestRegister(userName, email, password).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if(response.isSuccessful()) {
                    ResponseRegister responseRegister = response.body();

                    if(responseRegister.isSukses()) {
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();

                        Intent registerSuccess = new Intent(RegisterActivity.this, RegisterSuccessActivity.class);
                        startActivity(registerSuccess);
                        finishAffinity();
                    } else {
                        Toast.makeText(RegisterActivity.this, responseRegister.getPesan(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Response Gagal", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Harap Periksa Jaringan Anda!", Toast.LENGTH_LONG).show();
            }
        });
    }
}