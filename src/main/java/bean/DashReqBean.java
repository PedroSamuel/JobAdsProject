package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


import control.ControlRequerimento;
import model.Requerimento;

@Named("dashReqBean")
@ViewScoped
public class DashReqBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2133142098555964372L;









	@Inject
	ControlRequerimento requerimentoControl;
	


	private Requerimento selected;

	private Collection<Requerimento> filteredRequerientos;
	private Collection<Requerimento> porProcessar;

	
	public Collection<Requerimento> getFilteredRequerientos() {
		return filteredRequerientos;
	}

	public void setFilteredRequerientos(Collection<Requerimento> filteredRequerientos) {
		this.filteredRequerientos = filteredRequerientos;
	}



	public void removerequerimento(Requerimento requerimento) {
		requerimentoControl.removeRequerimento(requerimento);
		loadRequerimentos();
	}


	
	
	
	public void deleteSelected() { //mudar para arquivar
		System.out.println("OK");
		System.out.println(selected);
		requerimentoControl.removeRequerimento(selected);
		loadRequerimentos();
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


	public Collection<Requerimento> getPorProcessar() {
		return porProcessar;
	}

	public void setPorProcessar(Collection<Requerimento> porProcessar) {
		this.porProcessar = porProcessar;
	}
	
	@PostConstruct
	private void loadRequerimentos() {
		porProcessar = requerimentoControl.porProcessar();
				
	}
	
	
	
	
	
}
