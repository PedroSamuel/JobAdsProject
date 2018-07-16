package bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import control.ControlAnuncio;
import model.Anuncio;



@Named("anuncioCreate")
@RequestScoped
public class CriarAnuncio {

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
