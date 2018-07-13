package bean;


import java.util.Collection;


import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import model.Anuncio;


@Named("anuncioBean")
@ViewScoped
public class AnuncioBean {

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
