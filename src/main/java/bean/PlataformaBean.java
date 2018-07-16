package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlPlataforma;
import model.Plataforma;

@Named("plataformaBean")
@ViewScoped
public class PlataformaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Inject
	ControlPlataforma plataformaControl;

	
	public Collection<Plataforma> getPlataformas() {
		return plataformaControl.Plataformas();
	}

	public void removePlataforma(Plataforma plataforma) {
		plataformaControl.removePlataforma(plataforma);
	}

	public void onRowEdit(RowEditEvent event) {
		Plataforma plataforma = (Plataforma) event.getObject();
		plataformaControl.updatePlataforma(plataforma);
	}

	public void updateList() {
		plataformaControl.updateList();
	}
}
