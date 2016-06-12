package dataAccess;

import myfan.models.ArtistaDao;
import myfan.models.ArtistaEntity;
import myfan.models.FanaticoDao;
import myfan.models.FanaticoEntity;
import myfan.models.UserDao;
import myfan.models.UserEntity;

public class ProfileDataAcess implements IDataAcess {
	private FanaticoDao daoFan;
	private UserDao daoUser;
	private ArtistaDao daoArtist;

	
	
	public UserEntity getDataUser(String pLogin){
		UserEntity result=daoUser.getByLogin(pLogin);
		
		return result;
	}
	
	public FanaticoEntity getDataFan(String pLogin){
		FanaticoEntity result=daoFan.getByLogin(pLogin);
		return result;
	}
	
	public ArtistaEntity getDataArtist(String pLogin){
		ArtistaEntity result=daoArtist.getByLogin(pLogin);
		return result;
	}
	
	
	@Override
	public void setDaoUser(UserDao pDaoUser) {
		daoUser=pDaoUser;
	}
	@Override
	public void setDaoFan(FanaticoDao pDaoFan) {
		daoFan=pDaoFan;
		
	}
	@Override
	public void setDaoArtista(ArtistaDao daoArtista) {
		daoArtist=daoArtista;
	}


	
	
	
	

	
	
	
}
