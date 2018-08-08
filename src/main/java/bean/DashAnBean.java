package bean;

import java.util.List;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import control.ControlPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;
import model.Plataforma;

@Named("dashAnBean")
@ViewScoped
public class DashAnBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372562415933083083L;

	@Inject
	private ControlAnuncio anuncioControl;

	@Inject
	private ControlPlataforma controlPlataforma;
	
	@Inject
	private ControlAnuncioPlataforma controlAnunPlats;

	

	private Collection<Anuncio> comTarefa;

	// classes criada para o search bar
	private Collection<Anuncio> filteredAnuncio;
	
	private Long countAnunPlats;
	private Long countAnuncios;

	private Long countPlataformas;
	


	private Anuncio selected;
	
	
	public Collection<Anuncio> getFilteredAnuncio() {
		return filteredAnuncio;
	}

	public void removeAnuncio(Anuncio anuncio) {
		anuncioControl.removeAnuncio(anuncio);
		load();
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



	public void countAllAnunPlats() {
		System.out.println("Count AnunPlats");
		countAnunPlats = controlAnunPlats.countAnunciosPlataforma();
	}
	
	public void countAllAnuncios() {
		System.out.println("count Anuncios");
		countAnuncios = anuncioControl.countAnuncios();
	}
	
	public void countPlataformas() {
		System.out.println("count Plataformas");
		countPlataformas = controlPlataforma.countPlataformas();
	}
	
	
	
	
//	public void tarefas(Collection<Anuncio> list) {
//		for (Anuncio anuncio : list) {
//			switch(anuncio.getEstado()) {
//				case "Aplicar":
//					if (anuncio.countPlataformas() == countListaPlataformas) {
//						anuncio.setEstado("Manter");
//						anuncio.setTarefas("Feito");
//						break;
//					} else {
//						anuncio.setTarefas("!!!!");
//						
//						break;
//					}
//				case "Manter":
//					if (numberOnlinePlats(anuncio) == numberAnunPlats(anuncio)) {
//						anuncio.setTarefas("Feito");
//						break;
//						
//					} else {
//						anuncio.setTarefas("!!!!");
//						break;
//					}
//				case "Retirar":
//					if (numberOnlinePlats(anuncio) == 0) {
//						anuncio.setTarefas("Feito");
//						break;
//					} else {
//						anuncio.setTarefas("!!!!");
//						break;
//					}
//				default:
//					anuncio.setTarefas("ERRO");
//					break;
//				}
//				anuncioControl.updateAnuncio(anuncio);
//		}
//		
//	}
	
	
	public String listAnunPlat(Anuncio anuncio) {
		System.out.println("redirect listar anunPlat");
		return "listarAnunPlat?faces-redirect=true&idAnuncio=" + anuncio.getId(); 

	}


	
	@PostConstruct
	public void load() {
		System.out.println("load");
		countAllAnuncios();
		countAllAnunPlats();
		countPlataformas();
//		tarefas(anuncioControl.Anuncios());
		comTarefa = anuncioControl.comTarefa();
		System.out.println("get comTarefa");
	}

	public Collection<Anuncio> getComTarefa() {
		
		return comTarefa;
	}
	
		
	public Long getCountAnunPlats() {
		return countAnunPlats;
	}

	public Long getCountAnuncios() {
		return countAnuncios;
	}

	public Long getCountPlataformas() {
		return countPlataformas;
	}


}
