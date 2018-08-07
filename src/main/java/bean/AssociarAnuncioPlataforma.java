

	package bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.time.*;
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
		
		private String link;
		
		private String estado;
		
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


		private AnuncioPlataforma anuncioPlataforma = new AnuncioPlataforma();

		public AnuncioPlataforma getAnuncioPlataforma() {
			return anuncioPlataforma;
		}

		public void setAnuncioPlataforma(AnuncioPlataforma ap) {
			anuncioPlataforma = ap;
		}

		public String salvarAnunPlat() {

			System.out.println("Check if online");
			if (anuncioPlataforma.getEstado().equals("Online")){
				System.out.println("online ok");
				anuncioPlataforma.setDatacriacao(LocalDateTime.now());
				System.out.println("set dateTime to " + LocalDateTime.now());
			}		
			anuncioPlataforma.setAnuncio(anuncio);
			System.out.println("ok set anuncio " + anuncio);
			anuncioPlataforma.setPlataforma(plataforma); //fazer merge do anuncio e da plataforma, obter objectos merged, fazer set dos objectos merged e gravar anuncioPlataforma
			System.out.println(" ok set plataforma " + plataforma);
			controlAnuncioPlataforma.criarAnuncioPlataforma(anuncioPlataforma);
			System.out.println("anunplat criada. a returnar para listarAnunPlat");
		;
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
			setLink("teste");
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
		
		public  void onOnline(){
			anuncioPlataforma.setDatacriacao(LocalDateTime.now());
		}


	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

