package myfan.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GenreDao {
	@PersistenceContext
	  private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	  public List<MGenreEntity> getAll() {
	    return entityManager.createQuery("from MGenreEntity").getResultList();
	  
	  }
	
	
	
	
	
}
