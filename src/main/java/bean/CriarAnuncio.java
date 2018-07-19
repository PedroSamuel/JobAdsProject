package bean;


import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import control.ControlAnuncio;
import model.Anuncio;



@Named("anuncioCreate")
@ViewScoped
public class CriarAnuncio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5001183263825186972L;

	@Inject
	ControlAnuncio controlAnuncio;

	private Anuncio anuncio = new Anuncio();

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio p) {
		anuncio = p;
	}

	public String salvarAnuncio() {
		controlAnuncio.criarAnuncio(anuncio);
		return "listaAnuncios?faces-redirect=true";
	}

	public void criarAnuncio() {
		controlAnuncio.criarAnuncio(new Anuncio());
	}

}
