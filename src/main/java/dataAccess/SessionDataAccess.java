package dataAccess;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import myfan.controllers.UsersFactory;
import myfan.models.ArtistaDao;
import myfan.models.ArtistaEntity;
import myfan.models.FanaticoDao;
import myfan.models.FanaticoEntity;
import myfan.models.MGenreEntity;
import myfan.models.UserEntity;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;
import myfan.models.UserDao;

import org.apache.catalina.mbeans.UserMBean;
import org.apache.commons.beanutils.BeanUtils;


public class SessionDataAccess implements IDataAcess {
	private UserDao daoUser;
	private FanaticoDao daoFan;
	private ArtistaDao daoArtista;
	public SessionDataAccess(){
		
	}
	
	public String registerUserFan(FanaticoJson pUser){
		String result;
		try {
			UserEntity userToStore= new UserEntity();
			BeanUtils.copyProperties(userToStore, pUser);
			userToStore.setUserType("F");
			userToStore.setAccountStatus("A");	
			userToStore.setSessionStatus("C");
			daoUser.create(userToStore);
			registerFan(pUser);
			
			
			result="1";
		} 
		catch (Exception e) {
			result="0";
		}
		
		return result;
		
	}
	
	
	public String registerUserArtist(ArtistaJson pUser){
		String result;
		try {
			UserEntity userToStore= new UserEntity();
			BeanUtils.copyProperties(userToStore, pUser);
			userToStore.setUserType("A");
			userToStore.setAccountStatus("A");
			//registerFan()
			daoUser.create(userToStore);
			registerArtist(pUser);
			addGenresbyArtist(pUser);
			
			result="1";
		} 
		catch (Exception e) {
			result="0";
		}
		
		return result;
		
	}
	
	public void registerFan(FanaticoJson pFan){
		FanaticoEntity tmpFanEntity = new FanaticoEntity();
		tmpFanEntity.setLogin(pFan.getLogin());
		tmpFanEntity.setGenre(pFan.getGenre());
		daoFan.create(tmpFanEntity);
	}
	
	public void registerArtist(ArtistaJson pArtist) throws IllegalAccessException, InvocationTargetException{
			ArtistaEntity tmpArtistEntity = new ArtistaEntity();
			BeanUtils.copyProperties(tmpArtistEntity, pArtist);
	
			daoArtista.create(tmpArtistEntity);
		}
	
	public void addGenresbyArtist(ArtistaJson pArtist) throws IllegalAccessException, InvocationTargetException{
		List<MGenreEntity> genreEntity = pArtist.getGenres();
		
		
		
	}
	
	
	
	public void setDaoUser(UserDao pDaoUser){
		daoUser=pDaoUser;
	}
	
	public void setDaoFan(FanaticoDao pDaoFan){
		daoFan=pDaoFan;
	}

	public ArtistaDao getDaoArtista() {
		return daoArtista;
	}

	public void setDaoArtista(ArtistaDao daoArtista) {
		this.daoArtista = daoArtista;
	}
	
	public String loginUser(String pLogin,String pPassword) {
		List<UserEntity> userFound= (List<UserEntity>) daoUser.getbyLoginPass(pLogin,pPassword);
		String result;
		if(userFound.size()==0){
			return result="0";
		}
		UserEntity toUpdateUser=userFound.get(0);
		toUpdateUser.setSessionStatus("C");
		daoUser.update(toUpdateUser);
		return result=userFound.get(0).getUserType();
		
	}
	
	public String disableAccount(UserEntity pUser) {
		String result;
		UserEntity userTochange;
		try {
			userTochange=daoUser.getByLogin(pUser.getLogin());
			userTochange.setAccountStatus("U");
			daoUser.update(userTochange);
			result="1";
		} catch (Exception e) {
			result="0";
		}
		return result;
	}
	
	public String activateAccount(UserEntity pUser) {
		String result;
		UserEntity userTochange;
		try {
			userTochange=daoUser.getByLogin(pUser.getLogin());
			userTochange.setAccountStatus("A");
			daoUser.update(userTochange);
			result="1";
		} catch (Exception e) {
			result="0";
		}
		return result;
	}
	
	public String logout(UserEntity pUser) {
		String result;
		UserEntity userTochange;
		try {
			userTochange=daoUser.getByLogin(pUser.getLogin());
			
			userTochange.setSessionStatus("D");
			daoUser.update(userTochange);
			result="1";
		} catch (Exception e) {
			result="0";
		}
		return result;
	}
	
	
	
	
	

}
