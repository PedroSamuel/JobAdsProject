package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Anuncio;
import repository.RepositorioAnuncios;

@Transactional
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
	
	public Anuncio getAnuncio(long id){
		for (Anuncio anuncio: Anuncios()){
			if (anuncio.getId() == id) {
				return anuncio;
			}
		}
		return null;
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
