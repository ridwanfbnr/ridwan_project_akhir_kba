package com.ridwanfbnr.ridwanfbnr_project_akhir_kba.API.models.film;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseFilm{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataFilm")
	private List<DataFilmItem> dataFilm;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataFilm(List<DataFilmItem> dataFilm){
		this.dataFilm = dataFilm;
	}

	public List<DataFilmItem> getDataFilm(){
		return dataFilm;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseFilm{" + 
			"pesan = '" + pesan + '\'' + 
			",dataFilm = '" + dataFilm + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}