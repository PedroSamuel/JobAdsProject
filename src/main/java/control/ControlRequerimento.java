package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


import model.Requerimento;
import repository.RepositorioRequerimentos;


@RequestScoped
public class ControlRequerimento {
	@Inject
	RepositorioRequerimentos dbR ;
	
	public void criarRequerimento(Requerimento requerimento) {
		dbR.createEntity(requerimento);
	}
	
	public List<Requerimento> Requerimentos(){
		return dbR.listEntity(Requerimento.class);
	}
	
	public Requerimento getRequerimento (Long id) {
		return dbR.getEntity(Requerimento.class,  id);
		
	}
	
	public void updateRequerimento(Requerimento r) {
		dbR.updateEntity(r);
	}
	
	public void removeRequerimento(Requerimento requerimento) {
		dbR.removeEntity(requerimento);
		
		updateList();
	}
	
	public void updateList() {
		dbR.updateLocalList();
	}
}
