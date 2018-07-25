

	package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
	import javax.inject.Named;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import control.ControlPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;
import model.AnuncioPlataformaId;
import model.Plataforma;



	@Named("newAnunPlat")
	@ViewScoped

	public class AssociarAnuncioPlataforma implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1869695453848976058L;

		private Anuncio anuncio;
		
		private Plataforma plataforma;
		
		private String idAnuncio; 
		

		
		@Inject
		private ControlAnuncioPlataforma controlAnuncioPlataforma;
		
		@Inject
		private ControlPlataforma controlPlataforma;
		
		@Inject
		private ControlAnuncio controlAnuncio;
		
		public Anuncio getAnuncio() {
			return anuncio;
		}

		public void setAnuncio(Anuncio anuncio) {
			this.anuncio = anuncio;
		}


		private AnuncioPlataforma anuncioPlataforma	= new AnuncioPlataforma();

		public AnuncioPlataforma getAnuncioPlataforma() {
			return anuncioPlataforma;
		}

		public void setAnuncioPlataforma(AnuncioPlataforma ap) {
			anuncioPlataforma = ap;
		}

		public String salvarAnunPlat() {
			// vai buscar o parametro id, converte para Long e declara o anuncio com base no mesmo.
//			if (idAnuncio == (null)) {
//				System.out.println("Não Funcionou!!!!");
//			} else {
//				Long longID = Long.valueOf(idAnuncio);
//				setAnuncio(controlAnuncio.getAnuncio(longID));
//				System.out.println("Okok" + longID);
//				
//			}
			anuncioPlataforma.setId(new AnuncioPlataformaId(Long.valueOf(idAnuncio), plataforma.getId()));
			controlAnuncioPlataforma.criarAnuncioPlataforma(anuncioPlataforma);
			//anuncio.adicionarPlataforma(plataforma);
		
			//controlAnuncio.updateAnuncio(anuncio);
			
//			anuncio.getPlataformas().add(anuncioPlataforma);
//			controlAnuncio.updateAnuncio(anuncio);
//			anuncioPlataforma.getPlataforma().getAnuncios().add(anuncioPlataforma);
//			controlPlataforma.updatePlataforma(anuncioPlataforma.getPlataforma());
			//controlAnuncioPlataforma.criarAnuncioPlataforma(anuncioPlataforma);
//			System.out.println("Enviado!");
//			System.out.println(anuncio.getREF());
			return "listarAnunPlat?faces-redirect=true&idAnuncio=" + idAnuncio;
		}

		public void criarAnunPlat() {

			controlAnuncioPlataforma.criarAnuncioPlataforma(anuncioPlataforma);
			
		}
		
		public String getIdAnuncio() {
			return idAnuncio;
		}

		public void setIdAnuncio(String idx) {
			idAnuncio = idx;
		}
		
		// vai buscar o parametro id, converte para Long e declara o anuncio com base no mesmo.
		public void load(){ 
			if (idAnuncio == (null)) {
				System.out.println("Não Funcionou!");
			} else {
				long longID = Long.valueOf(idAnuncio);
				setAnuncio(controlAnuncio.getAnuncio(longID));
				System.out.println("Ok" + longID);
				
			}
		}

		public List<Plataforma> listaPlataformas(){
			return controlPlataforma.Plataformas();
		}
		


		public Plataforma getPlataforma() {
			return plataforma;
		}

		public void setPlataforma(Plataforma plataforma) {
			this.plataforma = plataforma;
		}
		
	
		public void teste() {
			for (Plataforma plataforma: listaPlataformas()) {
				System.out.println(plataforma.toString());
			}
		}

	}

