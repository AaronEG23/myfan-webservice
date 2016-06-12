package dataAccess;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import myfan.models.ArtistaDao;
import myfan.models.ArtistaEntity;
import myfan.models.FanaticoDao;
import myfan.models.FanaticoEntity;
import myfan.models.UserDao;
import myfan.models.UserEntity;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;

public class EditDataAccess implements IDataAcess {
	private FanaticoDao daoFan;
	private UserDao daoUser;
	private ArtistaDao daoArtist;
	
	public String updateFan(FanaticoJson pFan)  {		
		String result;
		UserEntity userEntity = new UserEntity();
		try {
			UserEntity userFound = daoUser.getByLogin(pFan.getLogin());
			BeanUtils.copyProperties(userEntity, pFan);	
			userEntity.setUserID(userFound.getUserID());
			FanaticoEntity fanEntity = new FanaticoEntity();
			BeanUtils.copyProperties(fanEntity, pFan);
			daoFan.update(fanEntity);
			daoUser.update(userEntity);	
			result="1";
		
		} catch (Exception e) {
			result="0";
		}
		return result;
	}
	
	public String updateArtist(ArtistaJson pArtist)  {		
		String result;
		UserEntity userEntity = new UserEntity();
		try {
			UserEntity userFound = daoUser.getByLogin(pArtist.getLogin());
			ArtistaEntity artistFound = daoArtist.getByLogin(pArtist.getLogin());
			BeanUtils.copyProperties(userEntity, pArtist);	
			userEntity.setUserID(userFound.getUserID());
			ArtistaEntity artistEntity = new ArtistaEntity();
			BeanUtils.copyProperties(artistEntity, pArtist);
			artistEntity.setUserID(artistFound.getUserID());
			daoArtist.update(artistEntity);
			daoUser.update(userEntity);	
			result="1";
		
		} catch (Exception e) {
			result="0";
		}
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
	public void setDaoArtista(ArtistaDao pdaoArtista) {
		daoArtist=pdaoArtista;
	}
}
