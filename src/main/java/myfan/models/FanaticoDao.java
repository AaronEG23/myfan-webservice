package myfan.models;

import static sqlConstants.ConstantsQueries.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class FanaticoDao {

	  /**
	   * Save the user in the database.
	   */
		
	  public void create(FanaticoEntity pFan) {
	    entityManager.persist(pFan);
	  }
	  
	  public void update(FanaticoEntity pFan) {
		    entityManager.merge(pFan);
		    return;
		  }
	  
	  public FanaticoEntity getByLogin(String login) {
		  FanaticoEntity result;
		  
		  Query tmpQuery=entityManager.createQuery(sqlprofileFan,FanaticoEntity.class);
		  tmpQuery.setParameter(1, login);
		  result=  (FanaticoEntity) tmpQuery.getSingleResult();
		  return result;
		  

	  }
	  
	
	  @PersistenceContext
	  private EntityManager entityManager;
	  
	} // class UserDao
