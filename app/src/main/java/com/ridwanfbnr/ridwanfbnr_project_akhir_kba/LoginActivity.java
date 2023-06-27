package com.ridwanfbnr.ridwanfbnr_project_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.ApiConfig;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.login.ResponseLogin;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(activityLoginBinding.getRoot());

        activityLoginBinding.btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

        activityLoginBinding.btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = activityLoginBinding.edtEmailLogin.getText().toString().trim();
                String password = activityLoginBinding.edtPasswordLogin.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    activityLoginBinding.edtEmailLogin.setError("Email harus diisi!");
                } else if(TextUtils.isEmpty(password)) {
                    activityLoginBinding.edtPasswordLogin.setError("Password harus diisi!");
                } else {
                    login(email, password);
                }
            }
        });
    }

    private void login(String email, String password) {
        ApiConfig.service.requestLogin(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful()) {
                    ResponseLogin responseLogin = response.body();

                    if(responseLogin.isSukses()) {
                        Bundle data = new Bundle();
                        data.putString("email", responseLogin.getDataLogin().getEmail());
                        data.putString("username", responseLogin.getDataLogin().getUsername());

                        Intent login = new Intent(LoginActivity.this, MainActivity.class);
                        login.putExtras(data);
                        startActivity(login);
                        finishAffinity();
                    } else {
                        Toast.makeText(LoginActivity.this, responseLogin.getPesan(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Response Gagal!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Harap periksa internet anda!", Toast.LENGTH_LONG).show();
            }
        });
    }
}