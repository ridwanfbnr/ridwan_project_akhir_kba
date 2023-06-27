package com.ridwanfbnr.ridwanfbnr_project_akhir_kba;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.LineBreaker;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ActivityDetailFilmBinding;

public class DetailFilmActivity extends AppCompatActivity {

    ActivityDetailFilmBinding activityDetailFilmBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailFilmBinding = ActivityDetailFilmBinding.inflate(getLayoutInflater());
        setContentView(activityDetailFilmBinding.getRoot());

        Bundle getDataFilm = getIntent().getExtras();

        if(getDataFilm != null) {
            String judulFilm = getDataFilm.getString("judul");
            String tahunFilm = getDataFilm.getString("tahun");
            String ratingFilm = getDataFilm.getString("rating");
            String posterFilm = getDataFilm.getString("poster");

            activityDetailFilmBinding.tvJudulFilmDetail.setText(judulFilm);
            activityDetailFilmBinding.tvTahunFilmDetail.setText(tahunFilm);
            activityDetailFilmBinding.tvRatingFilmDetail.setText(ratingFilm);
            activityDetailFilmBinding.tvIsiDeskripsiDetail.setText(R.string.desc_film_detail);

            Glide.with(activityDetailFilmBinding.ivDetailImgFilm)
                    .load(posterFilm)
                    .into(activityDetailFilmBinding.ivDetailImgFilm);
        }

        activityDetailFilmBinding.ivArrowBackDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}