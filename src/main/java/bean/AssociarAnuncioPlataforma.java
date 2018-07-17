

	package bean;

	import javax.enterprise.context.RequestScoped;
	import javax.inject.Inject;
	import javax.inject.Named;

	import control.ControlAnuncioPlataforma;

	
import model.AnuncioPlataforma;



	@Named("anuncioPlataformaCreate")
	@RequestScoped

	public class AssociarAnuncioPlataforma {

		@Inject
		ControlAnuncioPlataforma controlAnuncioPlataforma;

		private AnuncioPlataforma anuncioPlataforma = new AnuncioPlataforma();

		public AnuncioPlataforma getAnuncioPlataforma() {
			return anuncioPlataforma;
		}

		public void setAnuncioPlataforma(AnuncioPlataforma ap) {
			anuncioPlataforma = ap;
		}

		public String salvarAnuncio() {
			controlAnuncioPlataforma.criarAnuncioPlataforma(anuncioPlataforma);
			return "plataformas?faces-redirect=true";
		}

		public void criarAnuncio() {
			controlAnuncioPlataforma.criarAnuncioPlataforma(new AnuncioPlataforma());
		}

	}

