package myfan.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dataAccess.SessionDataAccess;
import myfan.models.Artista;
import myfan.models.ArtistaDao;
import myfan.models.ArtistaEntity;
import myfan.models.FanaticoDao;
import myfan.models.FanaticoEntity;
import myfan.models.GenerosMusicales;
import myfan.models.UserEntity;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;
import myfan.models.Responses.ResultLogin;
import myfan.models.Responses.ResultResponse;
import myfan.models.UserDao;
import responseAdministrator.SessionRespBuilder;
import updateManager.SyncDataArtist;
import static sqlConstants.ConstantsQueries.*;

@Controller
public class SessionController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private UserDao userDao;
	@Autowired
	  private FanaticoDao fanDao;
	@Autowired
	  private ArtistaDao artistDao;
	
	ResultResponse resultResponse;
	
	@RequestMapping(value = "/registerFan", method = RequestMethod.POST)
	public @ResponseBody ResultResponse registerFan(@RequestBody FanaticoJson pFan){
		
		SessionRespBuilder builderResponse= new SessionRespBuilder();
		
		SessionDataAccess newDataAcess= new SessionDataAccess();
		
		newDataAcess.setDaoFan(fanDao);
		newDataAcess.setDaoUser(userDao);
		
		String result=newDataAcess.registerUserFan(pFan);
			
		resultResponse = builderResponse.createRespRegister(result);
		
		if (result.equals("0")){ return resultResponse;}


		return resultResponse;
	}
	
	
	@RequestMapping(value = "/registerArtist", method = RequestMethod.POST)
	public @ResponseBody ResultResponse registerArtist(@RequestBody ArtistaJson pArtist) throws Exception {	
		SessionRespBuilder builderResponse= new SessionRespBuilder();
		
		SessionDataAccess newDataAcess= new SessionDataAccess();
		newDataAcess.setDaoArtista(artistDao);
		newDataAcess.setDaoUser(userDao);
		
		String result=newDataAcess.registerUserArtist(pArtist);
		
		
		resultResponse = builderResponse.createRespRegister(result);
		
		if (result.equals("0")) {  return resultResponse;}
		
				
		return resultResponse;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResultLogin loginUser(@RequestBody UserEntity pUser) throws Exception {	
		ResultLogin resultResponse = new ResultLogin();
		SessionRespBuilder builderResponse= new SessionRespBuilder();
		
		SessionDataAccess newDataAcess= new SessionDataAccess();
		newDataAcess.setDaoUser(userDao);
		
		String result=newDataAcess.loginUser(pUser.getLogin(),pUser.getPass() );
		
		resultResponse= builderResponse.createRespLogin(result);
		return resultResponse;
	}
	
	
	@RequestMapping(value = "/disableAccount", method = RequestMethod.POST)
	public @ResponseBody ResultResponse disableAccount(@RequestBody UserEntity pUser) throws Exception {	
		ResultResponse resultResponse= new ResultResponse();
		SessionDataAccess newDataAcess= new SessionDataAccess();
		newDataAcess.setDaoUser(userDao);
		String result=newDataAcess.disableAccount(pUser);
		
		resultResponse.setStatus(result);

		return resultResponse;
	}
	@RequestMapping(value = "/activateAccount", method = RequestMethod.POST)
	public @ResponseBody ResultResponse activateAccount(@RequestBody UserEntity pUser) throws Exception {	
		ResultResponse resultResponse= new ResultResponse();
		SessionDataAccess newDataAcess= new SessionDataAccess();
		newDataAcess.setDaoUser(userDao);
		String result=newDataAcess.activateAccount(pUser);
		resultResponse.setStatus(result);
		
		return resultResponse;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody ResultResponse logoutUser(@RequestBody UserEntity pUser) throws Exception {	
		ResultResponse resultResponse ;
		SessionRespBuilder builderResponse= new SessionRespBuilder();
		
		SessionDataAccess newDataAcess= new SessionDataAccess();
		newDataAcess.setDaoUser(userDao);
		
		String result=newDataAcess.logout(pUser);
		
		resultResponse=builderResponse.createRespLogout(result);
		return resultResponse;
	}

	
	
	
	
	

	
}