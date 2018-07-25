package bean;


import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import model.Anuncio;


@Named("anuncioBean")
@ViewScoped
public class AnuncioBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 372562415933083083L;

	@Inject
	ControlAnuncio anuncioControl;
    
	
	
	// classes criada para o search bar  
	private Collection<Anuncio> filteredAnuncio;
	
	public Collection<Anuncio> getFilteredAnuncio() {
		return filteredAnuncio;
	}

	public void setFilteredAnuncio(Collection<Anuncio> filteredAnuncio) {
		this.filteredAnuncio = filteredAnuncio;
	}

	private Anuncio selected;
	
	public Collection<Anuncio> getAnuncios() {
		return anuncioControl.Anuncios();
	}

	public void removeAnuncio(Anuncio anuncio) {
		anuncioControl.removeAnuncio(anuncio);
	}

	
	
	//class para a tabela editar vindo do primefaces
	public void onRowEdit(RowEditEvent event) {
		Anuncio anuncio = (Anuncio) event.getObject();
		anuncioControl.updateAnuncio(anuncio);
	}

	public void updateList() {
		anuncioControl.updateList();
	}

	public Anuncio getSelected() {
		return selected;
	}

	public void setSelected(Anuncio selected) {
		this.selected = selected;
	}

}
