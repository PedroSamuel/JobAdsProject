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

	private static final long serialVersionUID = 1L;
	@Inject
	ControlAnuncio anuncioControl;

	public Collection<Anuncio> getAnuncios() {
		return anuncioControl.Anuncios();
	}

	public void removeAnuncio(Anuncio anuncio) {
		anuncioControl.removeAnuncio(anuncio);
	}

	public void onRowEdit(RowEditEvent event) {
		Anuncio anuncio = (Anuncio) event.getObject();
		anuncioControl.updateAnuncio(anuncio);
	}

	public void updateList() {
		anuncioControl.updateList();
	}

}
