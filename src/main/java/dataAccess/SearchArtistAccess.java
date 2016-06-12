package dataAccess;

import java.util.List;

import myfan.models.ArtistaDao;
import myfan.models.FanaticoDao;
import myfan.models.UserDao;

public class SearchArtistAccess implements IDataAcess{
	private ArtistaDao daoArtist;
	private UserDao daoUser;
	
	public SearchArtistAccess(UserDao pDaoUser,ArtistaDao pDaoArtista ){
		daoArtist=pDaoArtista;
		daoUser=pDaoUser;
	}
	
	
	public  List<Object> searchArtist(String pName,String pCountry,String pGenre ){
		boolean toSearchCountry=validateCountry(pCountry);
		boolean toSearchGenre=validateGenre(pGenre);
		String typeOfSearch=chooseSearch(toSearchCountry,toSearchGenre);
		
		switch (typeOfSearch) {
	        case "onlyByName":  return searchByName(pName);
	        case "onlyByGenre":  
	                 break;
	        case "onlyByCountry":   
	                 break;
	        
	        case "ByGenreAndCountry":   
	            break;
		}
		return null;
	}
	
	
	private  List<Object> searchByName(String pName){
		return daoUser.getByName(pName);
	}
	
	
	private boolean validateCountry(String pCountry){
		if(pCountry.equals("noCountry")){
			return false; 
		}
		return true;
	}
	
	private boolean validateGenre(String pGender){
		if(pGender.equals("noGenre")){
			return false; 
		}
		return true;
	}
	
	private String chooseSearch(boolean toSearchCountry,boolean toSearchGenre){
		String result;
		if(toSearchCountry==true && toSearchGenre==false){
			return result="onlyByCountry";
		}
		else if(toSearchCountry==false && toSearchGenre==false){
			return result="onlyByName";
		}
		else if(toSearchCountry==false && toSearchGenre==true){
			return result="onlyByGenre";
		}
		else{
			return result="ByGenreAndCountry";
		}
		
		
	}

	@Override
	public void setDaoUser(UserDao pDaoUser) {
		daoUser=pDaoUser;
		
	}

	@Override
	public void setDaoFan(FanaticoDao pDaoFan) {
	}

	@Override
	public void setDaoArtista(ArtistaDao pdaoArtista) {
		daoArtist=pdaoArtista;
		
	}
	
}
