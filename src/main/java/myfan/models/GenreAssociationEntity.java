package myfan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "MGenreAssociation")
public class GenreAssociationEntity {
	@Id
	private int AssocID ;
	
    private int UserID;
	
    private int MGenreID;
    

	public int getUserID() {
		return UserID;
	}



	public void setUserID(int userID) {
		UserID = userID;
	}



	public int getMGenreID() {
		return MGenreID;
	}



	public void setMGenreID(int mGenreID) {
		MGenreID = mGenreID;
	}
  
  
  
  //private ArrayList<String> generosF;
  //    private Image foto;




  


  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  

 
  
  
} // class User
