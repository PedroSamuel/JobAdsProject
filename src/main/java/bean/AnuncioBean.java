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
	ControlPlataforma plats;
	
	private Collection<Anuncio> anuncioList;
	


	private Collection<Anuncio> comTarefa;

	// classes criada para o search bar
	private Collection<Anuncio> filteredAnuncio;


	private Anuncio selected;
	
	
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

	

	public Anuncio getSelected() {
		return selected;
	}

	public void setSelected(Anuncio selected) {
		this.selected = selected;
	}

	public int numberAnunPlats(Anuncio anuncio) {
		return anuncio.getPlataformas().size();
	}

	public int numberOnlinePlats(Anuncio anuncio) {
		
		int count = 0;
		for (AnuncioPlataforma ap : anuncio.getPlataformas()) {
			if (ap.getEstado().equals("Online")) {
				count++;
			}
		}
		return count;
	}

	
	public void tarefas(Collection<Anuncio> list) {
		for (Anuncio anuncio : list) {
			switch(anuncio.getEstado()) {
				case "Aplicar":
					if (numberAnunPlats(anuncio) == plats.Plataformas().size()) {
						anuncio.setEstado("Manter");
						anuncio.setTarefas("Feito");
						break;
					} else {
						anuncio.setTarefas("!!!!");
						
						break;
					}
				case "Manter":
					if (numberOnlinePlats(anuncio) == numberAnunPlats(anuncio)) {
						anuncio.setTarefas("Feito");
						break;
						
					} else {
						anuncio.setTarefas("!!!!");
						break;
					}
				case "Retirar":
					if (numberOnlinePlats(anuncio) == 0) {
						anuncio.setTarefas("Feito");
						break;
					} else {
						anuncio.setTarefas("!!!!");
						break;
					}
				default:
					anuncio.setTarefas("ERRO");
					break;
				}
				anuncioControl.updateAnuncio(anuncio);		
		}
		
	}
	
	
	public String listAnunPlat(Anuncio anuncio) {
		return "DetalhesAnunPlat?faces-redirect=true&idAnuncio=" + anuncio.getId(); 

	}

	public int platsSize() {
		return plats.Plataformas().size();
	}
	
	@PostConstruct
	public void loadAnuncios() {
		setAnuncioList(anuncioControl.Anuncios());
		tarefas(anuncioList);
		setComTarefa(anuncioControl.comTarefa());
	}

	public Collection<Anuncio> getComTarefa() {
		return comTarefa;
	}

	public void setComTarefa(Collection<Anuncio> comTarefa) {
		this.comTarefa = comTarefa;
	}
	
	public Collection<Anuncio> getAnuncioList() {
		return anuncioList;
	}

	public void setAnuncioList(Collection<Anuncio> anuncioList) {
		this.anuncioList = anuncioList;
	}
		

}
