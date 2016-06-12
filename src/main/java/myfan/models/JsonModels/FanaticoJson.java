package myfan.models.JsonModels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import myfan.models.MGenreEntity;
import myfan.models.UserEntity;



public class FanaticoJson extends UserEntity{
	
	private String Genre;
	private String BirthDate;
    private List<MGenreEntity> genres;

	
    //private ArrayList<String> generosF;
	

	public String getGenre() {
		return Genre;
	}



	public void setGenre(String genre) {
		Genre = genre;
	}



	public String getBirthDate() {
		return BirthDate;
	}



	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}



	public List<MGenreEntity> getGenres() {
		return genres;
	}



	public void setGenres(List<MGenreEntity> genres) {
		this.genres = genres;
	}



	





	

	

	


  

}