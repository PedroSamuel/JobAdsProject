

	package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
	import javax.inject.Named;

	import control.ControlAnuncioPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;



	@Named("anuncioPlataformaCreate")
	@ViewScoped

	public class AssociarAnuncioPlataforma implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1869695453848976058L;

		private Anuncio anuncio;
		
		@Inject
		private ControlAnuncioPlataforma controlAnuncioPlataforma;
		
		public Anuncio getAnuncio() {
			return anuncio;
		}

		public void setAnuncio(Anuncio anuncio) {
			this.anuncio = anuncio;
		}



		private AnuncioPlataforma anuncioPlataforma = new AnuncioPlataforma();

		public AnuncioPlataforma getAnuncioPlataforma() {
			return anuncioPlataforma;
		}

		public void setAnuncioPlataforma(AnuncioPlataforma ap) {
			anuncioPlataforma = ap;
		}

		public String salvarAnunPlat() {
			anuncioPlataforma.setAnuncio(anuncio);
			controlAnuncioPlataforma.criarAnuncioPlataforma(anuncioPlataforma);
			return "plataformas?faces-redirect=true";
		}

		public void criarAnunPlat() {
			controlAnuncioPlataforma.criarAnuncioPlataforma(new AnuncioPlataforma());
			
		}

	}

