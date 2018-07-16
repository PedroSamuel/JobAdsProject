package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Plataforma;
import repository.RepositorioPlataformas;

@RequestScoped
public class ControlPlataforma {
	
	@Inject
	RepositorioPlataformas dbP ;
	
	public void criarPlataforma(Plataforma plataforma) {
		dbP.createEntity(plataforma);
	}
	
	public List<Plataforma> Plataformas(){
		return dbP.listEntity(Plataforma.class);
	}
	
	public Plataforma getPlataforma (Long id) {
		return dbP.getEntity(Plataforma.class,  id);
		
	}
	
	public void updatePlataforma(Plataforma p) {
		dbP.updateEntity(p);
	}
	
	public void removePlataforma(Plataforma plataforma) {
		dbP.removeEntity(plataforma);
		
		updateList();
	}
	
	public void updateList() {
		dbP.updateLocalList();
	}
	

}
