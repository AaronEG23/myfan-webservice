package dataAccess;

import myfan.models.ArtistaDao;
import myfan.models.FanaticoDao;
import myfan.models.UserDao;

public interface IDataAcess {
	
	public void setDaoUser(UserDao pDaoUser);
	
	public void setDaoFan(FanaticoDao pDaoFan);
	
	public void setDaoArtista(ArtistaDao pdaoArtista);
}
