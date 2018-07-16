package bean;


import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;


import control.ControlAnuncioPlataforma;

import model.AnuncioPlataforma;


@Named("anuncioplataformaBean")
@ViewScoped
public class AnuncioPlataformaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	ControlAnuncioPlataforma anuncioControlPlataforma;
	
	
	public Collection<AnuncioPlataforma> getAnuncioPlataforma() {
		return anuncioControlPlataforma.AnunciosPlataforma();
	}

	public void removeAnuncio(AnuncioPlataforma anuncioplataforma) {
		anuncioControlPlataforma.removeAnuncioPlataforma(anuncioplataforma);
	}

	public void onRowEdit(RowEditEvent event) {
		AnuncioPlataforma anuncioplataforma = (AnuncioPlataforma) event.getObject();
		anuncioControlPlataforma.updateAnuncioPlataforma(anuncioplataforma);
	}

	public void updateList() {
		anuncioControlPlataforma.updateList();
	}


}
