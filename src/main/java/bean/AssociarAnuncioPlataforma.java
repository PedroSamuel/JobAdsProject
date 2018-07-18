

	package bean;

	import javax.enterprise.context.RequestScoped;
	import javax.inject.Inject;
	import javax.inject.Named;

	import control.ControlAnuncioPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;



	@Named("anuncioPlataformaCreate")
	@RequestScoped

	public class AssociarAnuncioPlataforma {

		@Inject
		private ControlAnuncioPlataforma controlAnuncioPlataforma;
		
		public Anuncio getAnuncio() {
			return anuncio;
		}

		public void setAnuncio(Anuncio anuncio) {
			this.anuncio = anuncio;
		}

		private Anuncio anuncio;

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

