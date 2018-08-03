package repository;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import model.Requerimento;


@ApplicationScoped
public class RepositorioRequerimentos extends EntityRepository <Requerimento>{
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void loadFromDB() {
		localList = em.createQuery("SELECT e FROM Requerimento e").getResultList();
	}
	

	@Override
	public void updateLocalList() {
		loadFromDB();
	}
	
	@SuppressWarnings("unchecked")
	protected List<Requerimento> porProcessar(){
		return  (em.createQuery("SELECT e FROM REQUERIMENTO e WHERE REQUERIMENTO.estado = 'Por Processar'").getResultList());
		
	}
	
	
	

}
