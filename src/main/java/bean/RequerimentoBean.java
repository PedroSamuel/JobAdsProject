package bean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
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
	private Collection<Requerimento> reqList;
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

	public void onRowEdit(RowEditEvent event) {
	Requerimento requerimento = (Requerimento) event.getObject();
		requerimentoControl.updateRequerimento(requerimento);
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

	public Collection<Requerimento> getReqList() {
		return reqList;
	}

	public void setReqList(Collection<Requerimento> reqList) {
		this.reqList = reqList;
	}

	public Collection<Requerimento> getPorProcessar() {
		return porProcessar;
	}

	public void setPorProcessar(Collection<Requerimento> porProcessar) {
		this.porProcessar = porProcessar;
	}
	
	@PostConstruct
	private void loadRequerimentos() {
		reqList = requerimentoControl.Requerimentos();
		porProcessar = requerimentoControl.porProcessar();
				
	}
	

}
