package bean;

import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import control.ControlAnuncio;
import control.ControlAnuncioPlataforma;
import control.ControlPlataforma;
import model.Anuncio;
import model.AnuncioPlataforma;

@Named("anuncioPlataformaBean")
@ViewScoped
public class AnuncioPlataformaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1425549335664619123L;

	@Inject
	private ControlAnuncioPlataforma anuncioControlPlataforma;
	@Inject
	private ControlAnuncio anuncioControl;

	@Inject
	private ControlPlataforma plataformaControl;

	private Anuncio anuncio;
	private AnuncioPlataforma selected;

	// codigo do id
	private String idAnuncio;

	private Collection<AnuncioPlataforma> filteredAnuncioPlataforma;
	private Collection<AnuncioPlataforma> APList;

	private Long countAnunPlats;
	private Long countAnuncios;
	private Long countPlataformas;

	public void updateAnuncio() {
		anuncioControl.updateAnuncio(anuncio);

		// FacesContext context = FacesContext.getCurrentInstance();

		// context.addMessage("null",
		// new FacesMessage("Estado do Anúncio " + anuncio.getREF() + " alterado para ",
		// anuncio.getEstado()));
	}

	public Collection<AnuncioPlataforma> getFilteredAnuncioPlataforma() {
		return filteredAnuncioPlataforma;
	}

	public void setFilteredAnuncioPlataforma(Collection<AnuncioPlataforma> filteredAnuncioPlataforma) {
		this.filteredAnuncioPlataforma = filteredAnuncioPlataforma;
	}



	public void removeAnunPlat(AnuncioPlataforma anuncioplataforma) {
		anuncioControlPlataforma.removeAnuncioPlataforma(anuncioplataforma);
		load();
	}

	public void onRowEdit(RowEditEvent event) {
		AnuncioPlataforma anuncioplataforma = (AnuncioPlataforma) event.getObject();
		anuncioControlPlataforma.updateAnuncioPlataforma(anuncioplataforma);
	}

	public Anuncio getAnuncio() {

		return anuncio;
	}

	public Anuncio getAnuncioById() {
		return anuncioControl.getAnuncio(Long.valueOf(idAnuncio));
	}

	public void setAnuncio(Anuncio anuncio) {

		this.anuncio = anuncio;
	}

	public String getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(String idx) {
		idAnuncio = idx;
	}

	public String newAnunPlat() {
		return "criarAnunPlat?faces-redirect=true&idAnuncio=" + idAnuncio;
	}

	public void onlineDate(AnuncioPlataforma ap) {

		System.out.println("iniciar evento online date");
		System.out.println(ap.getEstado());
		if (ap.getEstado().equals("Online")) {
			ap.setDatacriacao(LocalDateTime.now());
			System.out.println("online:" + ap.getDatacriacao());
		} else if (ap.getEstado().equals("Offline")) {
			ap.setDatacriacao(null);
			System.out.println("data nula");
			System.out.println("Offline;" + ap.getDatacriacao());
		}
		// anuncioControlPlataforma.updateAnuncioPlataforma(ap);
		ap.setDiasRestantes(daysToExpire(ap));
		ap.setDataExpiracao(expirationDate(ap));
		anuncioControlPlataforma.updateAnuncioPlataforma(ap);
	}

	public void redirect() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect(selected.getLink());
	}

	public int daysToExpire(AnuncioPlataforma anuncioPlataforma) {
		return anuncioControlPlataforma.daysToExpire(anuncioPlataforma);

	}

	public LocalDateTime expirationDate(AnuncioPlataforma anuncioPlataforma) {
		return anuncioControlPlataforma.expirationDate(anuncioPlataforma);
	}

	public Collection<AnuncioPlataforma> getAPList() {
		return APList;
	}

	public void setAPList(Collection<AnuncioPlataforma> aPList) {
		APList = aPList;
	}

	public Long getCountAnunPlats() {
		return countAnunPlats;
	}

	public Long getCountAnuncios() {
		return countAnuncios;
	}

	public Long getCountPlataformas() {
		return countPlataformas;
	}

	public void countAllAnunPlats() {
		System.out.println("Count AnunPlats");
		countAnunPlats = anuncioControlPlataforma.countAnunciosPlataforma();
	}

	public void countAllAnuncios() {
		System.out.println("count Anuncios");
		countAnuncios = anuncioControl.countAnuncios();
	}

	public void countPlataformas() {
		System.out.println("count Plataformas");
		countPlataformas = plataformaControl.countPlataformas();
	}

	public void load() {
		System.out.println("load");
		countAllAnuncios();
		countAllAnunPlats();
		countPlataformas();
		long longID = Long.valueOf(idAnuncio);
		System.out.println("Set Anuncio");
		setAnuncio(anuncioControl.getAnuncio(longID));
		System.out.println("A iniciar AnuncioPlataformaBean com anuncio " + longID);
		APList = anuncioControlPlataforma.SelectAnPlat(anuncio);
	}


}
