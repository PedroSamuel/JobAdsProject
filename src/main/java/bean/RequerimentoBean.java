package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlRequerimento;
import model.Anuncio;
import model.Requerimento;

@Named("requerimentoBean")
@ViewScoped
public class RequerimentoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	ControlRequerimento requerimentoControl;
	
	
	public Collection<Anuncio> getRequerimentos() {
		return requerimentoControl.Requerimentos();
	}

	public void removeAnuncio(Anuncio anuncio) {
		requerimentoControl.removeRequerimento(anuncio);
	}

	public void onRowEdit(RowEditEvent event) {
	Requerimento requerimento = (Requerimento) event.getObject();
		requerimentoControl.updateRequerimento(requerimento);
	}

	public void updateList() {
		requerimentoControl.updateList();
	}
	
	

}
