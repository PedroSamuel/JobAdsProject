package control;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Anuncio;
import model.AnuncioPlataforma;
import model.AnuncioPlataformaId;
import model.Plataforma;
import repository.RepositorioAnuncioPlataforma;
import repository.RepositorioAnuncios;
import repository.RepositorioPlataformas;

@Transactional
@RequestScoped
public class ControlAnuncioPlataforma {
	
   @Inject
   RepositorioAnuncioPlataforma dbAP;
   @Inject
   RepositorioAnuncios dbA;
   @Inject
   RepositorioPlataformas dbP;
   
   @Transactional
   public void criarAnuncioPlataforma(AnuncioPlataforma anuncioPlataforma) {
	    dbA.updateEntity(anuncioPlataforma.getAnuncio());
	    System.out.println("ok1");
	    Anuncio anuncio = (dbA.getEntity(Anuncio.class, anuncioPlataforma.getAnuncio().getId()));
	    System.out.println("ok2");
	    dbP.updateEntity(anuncioPlataforma.getPlataforma());
	    System.out.println("ok3");
	    Plataforma plataforma = (dbP.getEntity(Plataforma.class, anuncioPlataforma.getPlataforma().getId()));
	    System.out.println("ok4");
	    anuncioPlataforma.setId(new AnuncioPlataformaId(anuncio.getId(), plataforma.getId()));
	    System.out.println("ok5");
	    dbAP.updateEntity(anuncioPlataforma);
		System.out.println("ok6");
	}
  
	
	public List<AnuncioPlataforma> AnunciosPlataforma(){
		List<AnuncioPlataforma> list = dbAP.listEntity(AnuncioPlataforma.class);
		return list;
	}
	
	public Collection<AnuncioPlataforma> SelectAnPlat(Anuncio anuncio) {
		ArrayList<AnuncioPlataforma> select = new ArrayList<AnuncioPlataforma>(); 
		for (AnuncioPlataforma AP : AnunciosPlataforma()){
			reverContagem(AP);
			if (AP.getAnuncio().equals(anuncio)){
				select.add(AP);
			}
		}
		//List<AnuncioPlataforma> select = dbAP.selectAnunPlat(anuncio.getId());  * Está a causar problemas.
		return select;
	}
	

	public void reverContagem(AnuncioPlataforma ap) {
			if ((ap.getPlataforma().getPeriodoRenovacao() != 0) && (daysToExpire(ap)== 0) && (ap.getDatacriacao()!= null)){
				ap.setEstado("Offline");
				dbAP.updateEntity(ap);
			}
		}
	
	@PostConstruct
	public void reverContagem() {
		for (AnuncioPlataforma ap: AnunciosPlataforma()) {
			reverContagem(ap);
		}
	}
	

	 public int daysToExpire(AnuncioPlataforma anuncioPlataforma){
	    	if (!(anuncioPlataforma.getDatacriacao() == null)){
	    	Duration duration = Duration.between( anuncioPlataforma.getDatacriacao(),LocalDateTime.now());
	    	int days  = anuncioPlataforma.getPlataforma().getPeriodoRenovacao() - (int) duration.toDays();
	    	
	    	
			return days;
	    	}
	    	return 0;
	  
	    }
	
	
	
	
	public AnuncioPlataforma getAnuncioPlataforma (Long id) {
		return dbAP.getEntity(AnuncioPlataforma.class,  id);
		
	}
	

	
	public AnuncioPlataforma updateAnuncioPlataforma(AnuncioPlataforma anuncioPlataforma) {
		    dbAP.updateEntity(anuncioPlataforma);
		return anuncioPlataforma;
	}
	
	
	@Transactional
	public void removeAnuncioPlataforma(AnuncioPlataforma anuncioplataforma) {
		anuncioplataforma.getAnuncio().getPlataformas().remove(anuncioplataforma);
		dbA.updateEntity(anuncioplataforma.getAnuncio());
		anuncioplataforma.getPlataforma().getAnuncios().remove(anuncioplataforma);
		dbP.updateEntity(anuncioplataforma.getPlataforma());
		dbAP.removeEntity(anuncioplataforma);
		updateList();
	}
	
	public void updateList() {
		dbAP.updateLocalList();
	}
   
}
