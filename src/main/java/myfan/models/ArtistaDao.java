package myfan.models;

import static sqlConstants.ConstantsQueries.sqlprofileFan;
import static sqlConstants.ConstantsQueries.sqlprofileArtist;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class ArtistaDao {
	
	 public void update(ArtistaEntity pArtist) {
		    entityManager.merge(pArtist);
		    return;
		  }
	
	  public void create(ArtistaEntity pArtist) {
	    entityManager.persist(pArtist);
	  }
	  
	  
	  public ArtistaEntity getByLogin(String login) {
		  ArtistaEntity result;
		  Query tmpQuery=entityManager.createQuery(sqlprofileArtist,ArtistaEntity.class);
		  tmpQuery.setParameter(1, login);
		  result=  (ArtistaEntity) tmpQuery.getSingleResult();
		  return result;
		  

	  }
	  
	  @PersistenceContext
	  private EntityManager entityManager;
	  
	} 
