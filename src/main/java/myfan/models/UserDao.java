package myfan.models;


import javax.persistence.EntityManager;
import static sqlConstants.ConstantsQueries.sqlSearchByName;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import static sqlConstants.ConstantsQueries.*;

import java.util.List;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
	
  public void create(UserEntity user) {
    entityManager.persist(user);
  }
  
  /**
   * Delete the user from the database.
   */
  public void delete(UserEntity user) {
    if (entityManager.contains(user))
      entityManager.remove(user);
   // else
    //  entityManager.remove(entityManager.merge(user));
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<UserEntity> getAll() {
    return entityManager.createQuery("from User").getResultList();
    //entityManager.createQ
  }
  
  /**
   * Return the user having the passed email.
   */
  /*public FanaticoEntity getByEmail(String email) {
    return (FanaticoEntity) entityManager.createQuery(
        "from User where email = :email")
        .setParameter("email", email)
        .getSingleResult();
  }*.
  
  

  /**
   * Return the user having the passed login.
   */
  public UserEntity getByLogin(String login) {
	  UserEntity result;
	  Query tmpQuery=entityManager.createQuery(sqlprofileUser,UserEntity.class);
	  tmpQuery.setParameter(1, login);
	  result= (UserEntity) tmpQuery.getSingleResult();
	  return result;
  }
  
  public List<UserEntity> getbyLoginPass(String login,String password) {
	  List<UserEntity> result;
	  Query tmpQuery=entityManager.createQuery(sqlLogin,UserEntity.class);
	  
	  tmpQuery.setParameter(1, login);
	  tmpQuery.setParameter(2, password);
	  result= tmpQuery.getResultList();
	  return result ;
	    	
	  }
  
  public boolean userExists(UserEntity pUser) {
	  try {
		  UserEntity userResult=getByLogin(pUser.getLogin());
		  return true;

	} catch (Exception e) {
		return false;
	}
	 
	      	
  }

  /**
   * Update the passed user in the database.
   */
  
  
  
  public void update(UserEntity user) {
    entityManager.merge(user);

    return;
  }
  // AND nameG.MGenreID=genders.MGenreID
  //AND usuarios.Name='"+pName+"'
  //AND usuarios.Name='"+pName+"'
  @SuppressWarnings("unchecked")
  public List<Object> getByName(String pName){
	  Query tmpQuery=entityManager.createQuery(sqlSearchByName);
	  tmpQuery.setParameter(1, pName);
	  return tmpQuery.getResultList();
	 
  }
  
  

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} // class UserDao
