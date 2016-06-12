package myfan.models.JsonModels;

import java.util.List;

import myfan.models.MGenreEntity;
import myfan.models.UserEntity;

public class ArtistaJson extends UserEntity{
	
    private String Hashtag;
    private Integer CreateYear;
    private String Biography;
    private String Integrants;
    private int Followers;
    private List<MGenreEntity> genres;
    
	public String getHashtag() {
		return Hashtag;
	}
	public void setHashtag(String hashtag) {
		Hashtag = hashtag;
	}
	public Integer getCreateYear() {
		return CreateYear;
	}
	public void setCreateYear(Integer createYear) {
		CreateYear = createYear;
	}
	public String getBiography() {
		return Biography;
	}
	public void setBiography(String biography) {
		Biography = biography;
	}
	public String getIntegrants() {
		return Integrants;
	}
	public void setIntegrants(String integrants) {
		Integrants = integrants;
	}
	public int getFollowers() {
		return Followers;
	}
	public void setFollowers(int followers) {
		Followers = followers;
	}
	public List<MGenreEntity> getGenres() {
		return genres;
	}
	public void setGenres(List<MGenreEntity> genres) {
		this.genres = genres;
	}
	
	
}
