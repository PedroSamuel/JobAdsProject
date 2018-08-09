package bean;

import java.awt.List;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import control.ControlPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;

@Named("anuncioBean")
@ViewScoped
public class AnuncioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372562415933083083L;

	@Inject
	ControlAnuncio anuncioControl;

	@Inject
	ControlPlataforma controlPlataformas;
	
	private Collection<Anuncio> anuncioList;
	
	// classes criada para o search bar
	private Collection<Anuncio> filteredAnuncio;
	

		
	public Collection<Anuncio> getFilteredAnuncio() {
		return filteredAnuncio;
	}

	public void setFilteredAnuncio(Collection<Anuncio> filteredAnuncio) {
		this.filteredAnuncio = filteredAnuncio;
	}
	

	public void removeAnuncio(Anuncio anuncio) {
		anuncioControl.removeAnuncio(anuncio);
		loadAnuncios();
	}

	// class para a tabela editar vindo do primefaces
	public void onRowEdit(RowEditEvent event) {
		Anuncio anuncio = (Anuncio) event.getObject();
		anuncioControl.updateAnuncio(anuncio);
	
	}

	

	public int numberAnunPlats(Anuncio anuncio) {
		return anuncio.getPlataformas().size();
	}

	public long numberOnlinePlats(Anuncio anuncio) {
		return anuncio.countPlataformasOnline();
	}


	
	
	public String listAnunPlat(Anuncio anuncio) {
		return "DetalhesAnunPlat?faces-redirect=true&idAnuncio=" + anuncio.getId(); 

	}

	public Long countPlataformas() {
		return controlPlataformas.countPlataformas();
	}
	
	@PostConstruct
	public void load() {
		System.out.println("load");
		loadAnuncios();		
	}
	
	
	public void loadAnuncios() {
		System.out.println("load Anuncios");
		anuncioList = anuncioControl.Anuncios();
//		tarefas(anuncioList);
//		setComTarefa(anuncioControl.comTarefa());
	}


	
	public Collection<Anuncio> getAnuncioList() {
		return anuncioList;
	}

		

}
