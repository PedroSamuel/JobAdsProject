

	package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
	import javax.inject.Named;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;



	@Named("newAnunPlat")
	@ViewScoped

	public class AssociarAnuncioPlataforma implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1869695453848976058L;

		private Anuncio anuncio;
		
		private String idAnuncio; 
		
		@Inject
		private ControlAnuncioPlataforma controlAnuncioPlataforma;
		
		@Inject
		private ControlAnuncio controlAnuncio;
		
		public Anuncio getAnuncio() {
			return anuncio;
		}

		public void setAnuncio(Anuncio anuncio) {
			this.anuncio = anuncio;
		}



		private AnuncioPlataforma anuncioPlataforma;

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
		
		public String getIdAnuncio() {
			return idAnuncio;
		}

		public void setIdAnuncio(String idx) {
			idAnuncio = idx;
		}
		
		public void load(){
			anuncioPlataforma = new AnuncioPlataforma();
			if (idAnuncio == (null)) {
				System.out.println("Não Funcionou!");
			} else {
				long longID = Long.valueOf(idAnuncio);
				setAnuncio(controlAnuncio.getAnuncio(longID));
				anuncioPlataforma.setAnuncio(anuncio);
				System.out.println("Ok" + longID);
				
			}
		}

	}

