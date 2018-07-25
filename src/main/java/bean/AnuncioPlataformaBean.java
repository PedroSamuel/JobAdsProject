package bean;



import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;


@Named("anuncioplataformaBean")
@ViewScoped
public class AnuncioPlataformaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1425549335664619123L;
	
	@Inject
	private ControlAnuncioPlataforma anuncioControlPlataforma;
	@Inject 
	private ControlAnuncio anuncioControl;
	

	private Anuncio anuncio;
	
	
	
	
	
	//codigo do id
	private String idAnuncio;
	
	private Collection<AnuncioPlataforma> filteredAnuncioPlataforma;
	
	
	
	
	
	
	
	
	public Collection<AnuncioPlataforma> getFilteredAnuncioPlataforma() {
		return filteredAnuncioPlataforma;
	}

	public void setFilteredAnuncioPlataforma(Collection<AnuncioPlataforma> filteredAnuncioPlataforma) {
		this.filteredAnuncioPlataforma = filteredAnuncioPlataforma;
	}

	public Collection<AnuncioPlataforma> getAnuncioPlataforma() {
		return anuncioControlPlataforma.AnunciosPlataforma();
	}
	
	
	
	public Collection<AnuncioPlataforma> SelectAnPlat() {
		return anuncioControlPlataforma.SelectAnPlat(getAnuncioById());
	}
	

	public void removeAnunPlat(AnuncioPlataforma anuncioplataforma) {
		anuncioControlPlataforma.removeAnuncioPlataforma(anuncioplataforma);
	}

	public void onRowEdit(RowEditEvent event) {
		AnuncioPlataforma anuncioplataforma = (AnuncioPlataforma) event.getObject();
		anuncioControlPlataforma.criarAnuncioPlataforma(anuncioplataforma);
	}

	public void updateList() {
		anuncioControlPlataforma.updateList();
	}


	public Anuncio getAnuncio() {
		
		return anuncio;
	}
	
	public Anuncio getAnuncioById() {
		return anuncioControl.getAnuncio(Long.valueOf(idAnuncio));
	}

	public void setAnuncio(Anuncio anuncio) {
		
		this.anuncio = anuncio;
	}


	public String getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(String idx) {
		idAnuncio = idx;
	}
	
	
	
	
	//codigo do ID chama a funcao load vinda f param do listar anun platf
	public void load(){
		if (idAnuncio == (null)) {
			System.out.println("Não Funcionou!");
		} else {
			long longID = Long.valueOf(idAnuncio);
			setAnuncio(anuncioControl.getAnuncio(longID));
			System.out.println("Ok" + longID);
		}
		
	}

	
	
	
	
	
	
	
}
