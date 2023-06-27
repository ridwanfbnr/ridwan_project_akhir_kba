package com.ridwanfbnr.ridwanfbnr_project_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.ApiConfig;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.adapter.FilmAdapter;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.film.DataFilmItem;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.film.ResponseFilm;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ActivityListFilmBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFilmActivity extends AppCompatActivity {

    FilmAdapter filmAdapter;
    ActivityListFilmBinding activityListFilmBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityListFilmBinding = ActivityListFilmBinding.inflate(getLayoutInflater());
        setContentView(activityListFilmBinding.getRoot());

        activityListFilmBinding.rvFilm.setHasFixedSize(true);
        activityListFilmBinding.rvFilm.setLayoutManager(new LinearLayoutManager(this));

        ApiConfig.service.getDataFilms().enqueue(new Callback<ResponseFilm>() {
            @Override
            public void onResponse(Call<ResponseFilm> call, Response<ResponseFilm> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        ResponseFilm responseFilm = response.body();
                        List<DataFilmItem> dataFilm = responseFilm.getDataFilm();

                        Toast.makeText(ListFilmActivity.this, responseFilm.getPesan(), Toast.LENGTH_SHORT).show();

                        filmAdapter = new FilmAdapter(dataFilm, ListFilmActivity.this);
                        activityListFilmBinding.rvFilm.setAdapter(filmAdapter);
                    } else {
                        Toast.makeText(ListFilmActivity.this, "Data Kosong", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(ListFilmActivity.this, "Response Gagal", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseFilm> call, Throwable t) {
                Toast.makeText(ListFilmActivity.this, "Harap Periksa Jaringan Anda!", Toast.LENGTH_LONG).show();
            }
        });

        activityListFilmBinding.ivArrowBackFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}