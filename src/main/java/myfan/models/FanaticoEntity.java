package myfan.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "Fan")
public class FanaticoEntity {
	@Id
	private String Login ;
	
    private String Genre;
	
    @DateTimeFormat 
    private String BirthDate;
    
    
	public FanaticoEntity(String pLogin,String pGenre,String pBirthday){
		Login=pLogin;
		Genre=pGenre;
		BirthDate=pBirthday;
	}
	
	
	
	public FanaticoEntity(){}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
  
  
  
  //private ArrayList<String> generosF;
  //    private Image foto;




  


  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  

 
  
  
} // class User
