package control;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.AnuncioPlataforma;
import repository.RepositorioAnuncioPlataforma;


@RequestScoped
public class ControlAnuncioPlataforma {
   @Inject
   RepositorioAnuncioPlataforma dbAP;
   
   public void criarAnuncioPlataforma(AnuncioPlataforma anuncioplataforma) {
		dbAP.createEntity(anuncioplataforma);
	}
	
	public List<AnuncioPlataforma> AnunciosPlataforma(){
		return dbAP.listEntity(AnuncioPlataforma.class);
	}
	
	public AnuncioPlataforma getAnuncioPlataforma (Long id) {
		return dbAP.getEntity(AnuncioPlataforma.class,  id);
		
	}
	
	public void updateAnuncioPlataforma(AnuncioPlataforma ap) {
		dbAP.updateEntity(ap);
	}
	
	public void removeAnuncioPlataforma(AnuncioPlataforma anuncioplataforma) {
		dbAP.removeEntity(anuncioplataforma);
		
		updateList();
	}
	
	public void updateList() {
		dbAP.updateLocalList();
	}
   
}
