package myfan.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dataAccess.ProfileDataAcess;
import dataAccess.SessionDataAccess;
import myfan.models.ArtistaDao;
import myfan.models.ArtistaEntity;
import myfan.models.UserDao;
import myfan.models.UserEntity;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.Responses.ResponseProfileArtist;
import myfan.models.Responses.ResponseSearchArtist;
import myfan.models.Responses.ResultResponse;
import responseAdministrator.SessionRespBuilder;
import dataAccess.*;


@Controller
public class SearchController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ArtistaDao artistDao;
	
	
	@RequestMapping(value = "/searchArtists", params = { "name", "country","genre" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseSearchArtist searchArtist(@RequestParam(value="name",required=true) String name,
			@RequestParam(required=false,value="country", defaultValue = "noCountry")String country,
			@RequestParam(required=false, value="genre", defaultValue = "noGenre")String genre) {
		ResponseSearchArtist response = new ResponseSearchArtist();
		
		SearchArtistAccess newAccess= new SearchArtistAccess(userDao,artistDao);
		List<Object> dataResult= newAccess.searchArtist(name, country, genre);
		response.setStatus("1");
		response.setContent(dataResult);
		return response;
	
	}
	
	
	
}
