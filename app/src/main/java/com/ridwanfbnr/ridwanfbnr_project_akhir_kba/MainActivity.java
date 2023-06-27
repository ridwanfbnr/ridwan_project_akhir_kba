package com.ridwanfbnr.ridwanfbnr_project_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        Bundle data = getIntent().getExtras();
        String logoutAkun = data.getString("email") + ", Anda berhasil logout";
        String successLogin = "Hai " + data.getString("email") + ", Anda berhasil login";
        String username = data.getString("username").substring(0,1).toUpperCase() + data.getString("username").substring(1);

        activityMainBinding.tvNamaProfile.setText(username);
        Toast.makeText(MainActivity.this, successLogin, Toast.LENGTH_LONG).show();

        activityMainBinding.btnLogoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logout = new Intent(MainActivity.this, LoginActivity.class);

                data.remove("email");
                data.remove("username");

                startActivity(logout);
                finishAffinity();
                Toast.makeText(MainActivity.this, logoutAkun, Toast.LENGTH_LONG).show();
            }
        });

        activityMainBinding.cvListFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listFilm = new Intent(MainActivity.this, ListFilmActivity.class);
                startActivity(listFilm);
            }
        });
    }
}