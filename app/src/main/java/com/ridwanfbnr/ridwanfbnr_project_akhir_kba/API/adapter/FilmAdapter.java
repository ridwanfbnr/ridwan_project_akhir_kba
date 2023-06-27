package com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.film.DataFilmItem;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.DetailFilmActivity;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.R;
import com.ridwanfbnr.ridwanfbnr_project_akhir_kba.databinding.ItemListFilmBinding;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.AdapterViewHolder> {

    List<DataFilmItem> dataFilms;
    Context context;

    public FilmAdapter(List<DataFilmItem> dataFilms, Context context) {
        this.dataFilms = dataFilms;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmAdapter.AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterViewHolder(ItemListFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmAdapter.AdapterViewHolder holder, int position) {
        DataFilmItem responseDataFilms = dataFilms.get(position);

        String tahunFilm = responseDataFilms.getTahunRilis();
        String ratingFilm = responseDataFilms.getRating();
        String judulFilm = responseDataFilms.getNamaFilm();

        if(judulFilm.length() > 21) {
            String subStringJudul = judulFilm.substring(0,21);
            holder.itemListFilmBinding.tvJudulFilm.setText(subStringJudul.concat(" ..."));
        } else {
            holder.itemListFilmBinding.tvJudulFilm.setText(judulFilm);
        }

        holder.itemListFilmBinding.tvTahunFilm.setText(tahunFilm);
        holder.itemListFilmBinding.tvRatingFilm.setText(ratingFilm);
        holder.itemListFilmBinding.tvDeskripsiFilm.setText(R.string.desc_film);

        Glide.with(holder.itemListFilmBinding.ivImgFilm)
                .load(responseDataFilms.getImage())
                .into(holder.itemListFilmBinding.ivImgFilm);

        holder.itemListFilmBinding.cvItemListFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailFilm = new Intent(context, DetailFilmActivity.class);
                Bundle dataFilm = new Bundle();

                dataFilm.putString("judul", responseDataFilms.getNamaFilm());
                dataFilm.putString("tahun", responseDataFilms.getTahunRilis());
                dataFilm.putString("rating", responseDataFilms.getRating());
                dataFilm.putString("poster", responseDataFilms.getImage());

                detailFilm.putExtras(dataFilm);
                context.startActivity(detailFilm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataFilms.size();
    }

    public static class AdapterViewHolder extends RecyclerView.ViewHolder {

        ItemListFilmBinding itemListFilmBinding;

        public AdapterViewHolder(ItemListFilmBinding itemListFilmBinding) {
            super(itemListFilmBinding.getRoot());
            this.itemListFilmBinding = itemListFilmBinding;
        }
    }
}
