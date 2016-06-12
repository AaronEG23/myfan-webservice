package myfan.controllers;


import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dataAccess.EditDataAccess;
import myfan.models.ArtistaDao;
import myfan.models.GenerosMusicales;
import myfan.models.GenreDao;
import myfan.models.MGenreEntity;
import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;
import myfan.models.Responses.ResultGenres;
import myfan.models.Responses.ResultResponse;
import scala.annotation.meta.setter;

import static sqlConstants.ConstantsQueries.*;

@Controller
public class GenresController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private GenreDao genreDao;

	
	@RequestMapping(value = "/allGenres", method = RequestMethod.GET)
	public @ResponseBody ResultGenres editInfoFan(){	
		ResultGenres responseGenres= new ResultGenres();
		
		List<MGenreEntity> listaGeneros  = genreDao.getAll();
		responseGenres.setStatus("1");
		responseGenres.setContent(listaGeneros);
		return responseGenres;
	}
	
	@RequestMapping(value = "/prueba", method = RequestMethod.POST)
	public @ResponseBody FanaticoJson editInfoFan(@RequestBody FanaticoJson pJson) throws IllegalAccessException, InvocationTargetException{	
		ResultResponse responseUpdate= new ResultResponse();
		EditDataAccess newDataAccess= new EditDataAccess();
	
		
		return pJson;
	}
	

}
