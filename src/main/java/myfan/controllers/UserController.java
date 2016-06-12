package myfan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import myfan.models.FanaticoEntity;
import myfan.models.UserEntity;
import myfan.models.UserDao;

/**
 * Class UserController
 */
@Controller
public class UserController {
	 @Autowired
	  private UserDao userDao;
	 
	 @Autowired
	   JdbcTemplate jdbcTemplate;
	 
  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Create a new user with an auto-generated id and email and name as passed 
   * values.
   */
	 
  @RequestMapping(value="/create")
  @ResponseBody
  public String create(String login,String name, String password) {
    try {
    	jdbcTemplate.execute("CREATE TABLE customers(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
    	
    	//userDao.create(newFan);
    	
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created!";
  }
  
  /**
   * Delete the user with the passed id.
   */
  
  @RequestMapping(value="/delete")
  @ResponseBody
  public String delete(long id) {
    try {
    	//User user = new User();
      //userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user: " + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * Retrieve the id for the user with the passed email address.
   */
 
  
  /**
   * Update the email and the name for the user identified by the passed id.
   */
  @RequestMapping(value="/update")
  @ResponseBody
  public String updateName(long id, String email, String name) {
    try {
    //	FanaticoEntity user = userDao.getById(id);
     
      //userDao.update(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  } 

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // Wire the UserDao used inside this controller.
 
  
} // class UserController
