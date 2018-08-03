package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlRequerimento;
import model.Requerimento;

@Named("requerimentoBean")
@ViewScoped
public class RequerimentoBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5893776681538897923L;



	@Inject
	ControlRequerimento requerimentoControl;
	


	private Requerimento selected;
	
	// isto serve para o primefaces poder filtrar
	private Collection<Requerimento> filteredRequerientos;
	
	public Collection<Requerimento> getFilteredRequerientos() {
		return filteredRequerientos;
	}

	public void setFilteredRequerientos(Collection<Requerimento> filteredRequerientos) {
		this.filteredRequerientos = filteredRequerientos;
	}

	public Collection<Requerimento> getRequerimentos() {
		return requerimentoControl.Requerimentos();
	}
	
	public Collection<Requerimento> porProcessar() {
		return requerimentoControl.porProcessar();
	}

	public void removerequerimento(Requerimento requerimento) {
		requerimentoControl.removeRequerimento(requerimento);
	}

	public void onRowEdit(RowEditEvent event) {
	Requerimento requerimento = (Requerimento) event.getObject();
		requerimentoControl.updateRequerimento(requerimento);
	}

	public void updateList() {
		requerimentoControl.updateList();
	}

	
	
	public void deleteSelected() { //mudar para arquivar
		System.out.println("OK");
		System.out.println(selected);
		requerimentoControl.removeRequerimento(selected);
	}

	public Requerimento getSelected() {
		return selected;
	}

	public void setSelected(Requerimento selected) {
		this.selected = selected;
	}


	public String novoAnuncio() {
		return "criarAnuncio?faces-redirect=true&idRequerimento=" + selected.getId();
	}
	

}
