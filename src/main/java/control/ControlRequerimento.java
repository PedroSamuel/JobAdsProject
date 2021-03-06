package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Requerimento;
import repository.RepositorioRequerimentos;

@Transactional
@RequestScoped
public class ControlRequerimento {
	@Inject
	RepositorioRequerimentos dbR ;
	
	public void criarRequerimento(Requerimento requerimento) {
		dbR.createEntity(requerimento);
	}
	
	public List<Requerimento> Requerimentos(){
		return dbR.getAll();
	}
	
	public List<Requerimento> porProcessar(){
		return dbR.porProcessar();
	}
	

	public Requerimento getRequerimento (Long id) {
		return dbR.getEntity(Requerimento.class,  id);
		
	}
	
	public void updateRequerimento(Requerimento r) {
		dbR.updateEntity(r);
	}
	
	public void removeRequerimento(Requerimento requerimento) {
		dbR.removeEntity(requerimento);
	}

	public Long countRequerimentos() {
		return dbR.countAll();
		
	}
		


	
	
}
