package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.Anuncio;
import repository.RepositorioAnuncios;

@RequestScoped
public class ControlAnuncio {
	@Inject
	RepositorioAnuncios dbA ;
	
	public void criarAnuncio(Anuncio anuncio) {
		dbA.createEntity(anuncio);
	}
	
	public List<Anuncio> Anuncios(){
		return dbA.listEntity(Anuncio.class);
	}
	
	public Anuncio getAnuncio (Long id) {
		return dbA.getEntity(Anuncio.class,  id);
		
	}
	
	public void updateAnuncio(Anuncio a) {
		dbA.updateEntity(a);
	}
	
	public void removeAnuncio(Anuncio anuncio) {
		dbA.removeEntity(anuncio);
		
		updateList();
	}
	
	public void updateList() {
		dbA.updateLocalList();
	}
	
}
