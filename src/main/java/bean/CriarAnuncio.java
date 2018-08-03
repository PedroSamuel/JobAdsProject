package bean;


import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import control.ControlAnuncio;
import control.ControlRequerimento;
import model.Anuncio;
import model.Requerimento;



@Named("anuncioCreate")
@ViewScoped
public class CriarAnuncio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5001183263825186972L;

	@Inject
	ControlAnuncio controlAnuncio;
	@Inject
	ControlRequerimento controlReq;

	private Anuncio anuncio = new Anuncio();
	
	private String idRequerimento;

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio p) {
		anuncio = p;
	}

	public String salvarAnuncio() {
		controlAnuncio.criarAnuncio(anuncio);
		return "DashboardRH?faces-redirect=true";
	}

	public void criarAnuncio() {
		controlAnuncio.criarAnuncio(new Anuncio());
	}

	public String getIdRequerimento() {
		return idRequerimento;
	}

	public void setIdRequerimento(String idRequerimento) {
		this.idRequerimento = idRequerimento;
	}
	
	public void load() {
		if (idRequerimento != null) {
			System.out.println("correu " + idRequerimento);
			anuncio.setIdRequerimento(idRequerimento);
			Requerimento req = controlReq.getRequerimento(Long.valueOf(idRequerimento));
			anuncio.setManager(req.getRequerente());
			anuncio.setFuncao(req.getFuncao());
			anuncio.setRequisitos(req.getRequisitos());
			
		} else {
			System.out.println("Sem parametro");
		}
	}

}
