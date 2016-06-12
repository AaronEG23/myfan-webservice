package myfan.controllers;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dataAccess.EditDataAccess;
import myfan.models.ArtistaDao;
import myfan.models.FanaticoDao;
import myfan.models.UserDao;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;
import myfan.models.Responses.ResultResponse;

//import static sqlConstants.ConstantsQueries.sqlEditInfoFan;

@Controller
public class editInfoController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private FanaticoDao fanDao;
	@Autowired
	private ArtistaDao artistDao;
	
	
	@RequestMapping(value = "/editInfoFan", method = RequestMethod.POST)
	public @ResponseBody ResultResponse editInfoFan(@RequestBody FanaticoJson pFan) throws IllegalAccessException, InvocationTargetException{	
		ResultResponse responseUpdate= new ResultResponse();
		EditDataAccess newDataAccess= new EditDataAccess();
		newDataAccess.setDaoUser(userDao);
		newDataAccess.setDaoFan(fanDao);
		String result= newDataAccess.updateFan(pFan);
		
		responseUpdate.setStatus(result);
		
		return responseUpdate;
	}
	
	@RequestMapping(value = "/editInfoArtist", method = RequestMethod.POST)
	public @ResponseBody ResultResponse editInfoArtist(@RequestBody ArtistaJson pArtist) throws IllegalAccessException, InvocationTargetException{	
		ResultResponse responseUpdate= new ResultResponse();
		EditDataAccess newDataAccess= new EditDataAccess();
		newDataAccess.setDaoUser(userDao);
		newDataAccess.setDaoArtista(artistDao);
		
		String result= newDataAccess.updateArtist(pArtist);
		
		responseUpdate.setStatus(result);
		
		return responseUpdate;
	}
	
	

}
