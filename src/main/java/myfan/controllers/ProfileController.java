package myfan.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dataAccess.ProfileDataAcess;
import myfan.models.ArtistaDao;
import myfan.models.ArtistaEntity;
import myfan.models.FanaticoDao;
import myfan.models.FanaticoEntity;
import myfan.models.UserDao;
import myfan.models.UserEntity;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;
import myfan.models.Responses.ResponseProfileArtist;
import myfan.models.Responses.ResponseProfileFan;
import myfan.models.Responses.ResultResponse;

import static sqlConstants.ConstantsQueries.*;

@Controller
public class ProfileController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private FanaticoDao fanDao;
	
	@Autowired
	private ArtistaDao artistDao;
	
	
	
	

	@RequestMapping(value = "/profileFan/{login}", method = RequestMethod.GET)
	public @ResponseBody ResponseProfileFan registerFan(@PathVariable(value="login") String login) throws IllegalAccessException, InvocationTargetException{		
		ProfileDataAcess newAccess = new ProfileDataAcess();
		ResponseProfileFan response = new ResponseProfileFan();
		FanaticoJson result;
		newAccess.setDaoUser(userDao);
		newAccess.setDaoFan(fanDao);	
		UserEntity dataUser= newAccess.getDataUser(login);
		FanaticoEntity dataFan = newAccess.getDataFan(login);
		result= prepareResultFan(dataUser,dataFan);
		response.setStatus("1");
		response.setContent(result);
		
		
		return response;
	}
	
	private FanaticoJson prepareResultFan(UserEntity pUser,FanaticoEntity pFan ) throws IllegalAccessException, InvocationTargetException{
		FanaticoJson result= new FanaticoJson();	
		BeanUtils.copyProperties(result, pUser);
		
		result.setGenre(pFan.getGenre());
		
		result.setBirthDate(pFan.getBirthDate());
			
		return result;
		
	}
	
	
	@RequestMapping(value = "/profileArtist/{login}", method = RequestMethod.GET)
	public @ResponseBody ResponseProfileArtist registerArtist(@PathVariable(value="login") String login) throws IllegalAccessException, InvocationTargetException{		
		ProfileDataAcess newAccess = new ProfileDataAcess();
		ResponseProfileArtist response = new ResponseProfileArtist();
		ArtistaJson result;
		newAccess.setDaoUser(userDao);
		newAccess.setDaoArtista(artistDao);
		UserEntity dataUser= newAccess.getDataUser(login);
		ArtistaEntity dataArtist = newAccess.getDataArtist(login);
		result= prepareResultArtist(dataUser,dataArtist);	
		response.setContent(result);
		response.setStatus("1");
		return response;
	}
	
	private ArtistaJson prepareResultArtist(UserEntity pUser,ArtistaEntity pArtista ) throws IllegalAccessException, InvocationTargetException{
		ArtistaJson result= new ArtistaJson();	
		BeanUtils.copyProperties(result, pUser);
		
		result.setHashtag(pArtista.getHashtag());
		
		result.setCreateYear(pArtista.getCreateYear());
		result.setBiography(pArtista.getBiography());
		result.setIntegrants(pArtista.getIntegrants());
		result.setFollowers(pArtista.getFollowers());

		
		return result;
		
	}
	
	
	
	
}
