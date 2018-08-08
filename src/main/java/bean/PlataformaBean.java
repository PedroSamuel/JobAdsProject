package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import control.ControlPlataforma;
import model.Plataforma;

@Named("plataformaBean")
@ViewScoped
public class PlataformaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ControlPlataforma plataformaControl;
	@Inject
	private ControlAnuncioPlataforma anuncioPlataformaControl;
	@Inject
	private ControlAnuncio anuncioControl;
	
	private long countAnunPlats;



	// isto serve para o primefaces poder filtrar
	private Collection<Plataforma> filteredPlataformas;
	private Collection<Plataforma> plataformaList;
	
	public Collection<Plataforma> getPlataformaList() {
		return plataformaList;
	}

	public void setPlataformaList(Collection<Plataforma> plataformaList) {
		this.plataformaList = plataformaList;
	}

	public Collection<Plataforma> getFilteredPlataformas() {
		return filteredPlataformas;
	}

	public void setFilteredPlataformas(Collection<Plataforma> filteredPlataformas) {
		this.filteredPlataformas = filteredPlataformas;
	}

	public void removePlataforma(Plataforma plataforma) {
		plataformaControl.removePlataforma(plataforma);
		anuncioControl.verificarTarefaAplicar();
		plataformasLoad();
	}

	public void onRowEdit(RowEditEvent event) {
		Plataforma plataforma = (Plataforma) event.getObject();
		plataformaControl.updatePlataforma(plataforma);
	}
	
	public Long registosEmPlataformas() {
		return anuncioPlataformaControl.countAnunciosPlataforma();
		
	}
	
	public long getCountAnunPlats() {
		return countAnunPlats;
	}
	
	@PostConstruct
	public void plataformasLoad() {
		plataformaList = plataformaControl.Plataformas();
		countAnunPlats = anuncioPlataformaControl.countAnunciosPlataforma();
	}

}
