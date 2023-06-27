package com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.film;

import com.google.gson.annotations.SerializedName;

public class DataFilmItem{

	@SerializedName("image")
	private String image;

	@SerializedName("rating")
	private String rating;

	@SerializedName("tahun_rilis")
	private String tahunRilis;

	@SerializedName("id")
	private String id;

	@SerializedName("nama_film")
	private String namaFilm;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setTahunRilis(String tahunRilis){
		this.tahunRilis = tahunRilis;
	}

	public String getTahunRilis(){
		return tahunRilis;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNamaFilm(String namaFilm){
		this.namaFilm = namaFilm;
	}

	public String getNamaFilm(){
		return namaFilm;
	}

	@Override
 	public String toString(){
		return 
			"DataFilmItem{" + 
			"image = '" + image + '\'' + 
			",rating = '" + rating + '\'' + 
			",tahun_rilis = '" + tahunRilis + '\'' + 
			",id = '" + id + '\'' + 
			",nama_film = '" + namaFilm + '\'' + 
			"}";
		}
}