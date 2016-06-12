package myfan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Artist")
public class ArtistaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int userID;
    private String Login;
	private String Hashtag;
	
    private Integer CreateYear;
    private String Biography;
    private String Integrants;
    private int Followers;
    
    public ArtistaEntity(){}
    
    public ArtistaEntity(int pUserID, String pLogin, String pHashtag, Integer pCreateYear, 
    		String pBiography,
    		String pIntegrants, int pFollowers)
    {
    	setUserID(pUserID);
    	Login=pLogin;
    	Hashtag=pHashtag;
    	CreateYear=	pCreateYear;
    	Biography=pBiography;
    	Integrants=pIntegrants;
    	Followers=pFollowers;
    }
    
    
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
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}





	  
	  
	  //private ArrayList<String> generosF;
	  //    private Image foto;


	


	  


	  // ------------------------
	  // PUBLIC METHODS
	  // ------------------------
	  
	  

	 
	  
	  
	} // class User
