package bean;



import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;


@Named("anuncioplataformaBean")
@RequestScoped
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
	private String id;
	
	
	public Collection<AnuncioPlataforma> getAnuncioPlataforma() {
		return anuncioControlPlataforma.AnunciosPlataforma();
	}
	
	public Collection<AnuncioPlataforma> SelectAnPlat() {

		return anuncioControlPlataforma.SelectAnPlat(anuncio);
	}
	
	public long idParam(FacesContext fc){
		
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		return Long.valueOf(params.get("ID"));
	}

	public void removeAnuncio(AnuncioPlataforma anuncioplataforma) {
		anuncioControlPlataforma.removeAnuncioPlataforma(anuncioplataforma);
	}

	public void onRowEdit(RowEditEvent event) {
		AnuncioPlataforma anuncioplataforma = (AnuncioPlataforma) event.getObject();
		anuncioControlPlataforma.updateAnuncioPlataforma(anuncioplataforma);
	}

	public void updateList() {
		anuncioControlPlataforma.updateList();
	}


	public Anuncio getAnuncio() {
		
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		
		this.anuncio = anuncio;
	}

	public Anuncio setAnuncioFromContext() {
		FacesContext fc = FacesContext.getCurrentInstance();
		long id = idParam(fc);
		Anuncio anuncio = anuncioControl.getAnuncio(id); 
		return anuncio;
	}

	public String getId() {
		return id;
	}

	public void setId(String idx) {
		id = idx;
	}
	
	public void load(){
		if (id == (null)) {
			System.out.println("Fodasse!");
		} else {
			long longID = Long.valueOf(id);
			setAnuncio(anuncioControl.getAnuncio(longID));
			System.out.println("Ok" + longID);
		}
		
	}

}
