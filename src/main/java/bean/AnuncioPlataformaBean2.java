package bean;

import java.io.IOException;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
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
import model.Anuncio;
import model.AnuncioPlataforma;

@Named("anuncioplataformaBean2")
@ViewScoped
public class AnuncioPlataformaBean2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1425549335664619123L;

	@Inject
	private ControlAnuncioPlataforma anuncioControlPlataforma;
	@Inject
	private ControlAnuncio anuncioControl;

	private Anuncio anuncio;
	private AnuncioPlataforma selected;

	// codigo do id
	private String idAnuncio;

	private Collection<AnuncioPlataforma> filteredAnuncioPlataforma;
	private Collection<AnuncioPlataforma> APList;

	public void updateAnuncio() {
		anuncioControl.updateAnuncio(anuncio);

		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage("null",
				new FacesMessage("Estado do Anúncio " + anuncio.getREF() + " alterado para ", anuncio.getEstado()));
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



	

	public AnuncioPlataforma getSelected() {
		return selected;
	}

	public void setSelected(AnuncioPlataforma selected) {
		this.selected = selected;
	}

	public void deleteSelected() {
		anuncioControlPlataforma.removeAnuncioPlataforma(selected);
		selected = null;
	}

	public String newAnunPlat() {
		return "criarAnunPlat?faces-redirect=true&idAnuncio=" + idAnuncio;
	}

	public void updateSelected() {
		anuncioControlPlataforma.updateAnuncioPlataforma(selected);

	}

	public void updateSelected(AnuncioPlataforma ap) {
		anuncioControlPlataforma.updateAnuncioPlataforma(ap);

	}

	public void onlineDate(AnuncioPlataforma ap) {
		
		System.out.println("iniciar evento online date");
		System.out.println(ap.getEstado());
		if (ap.getEstado().equals("Online")) {
			ap.setDatacriacao(LocalDateTime.now());
			ap.setDataModificacao(ap.getDatacriacao().plusDays(ap.getPlataforma().getPeriodoRenovacao()));
			System.out.println("online:" + ap.getDatacriacao());

		} else if (ap.getEstado().equals("Offline")) {
			ap.setDatacriacao(null);
			ap.setDataModificacao(null);
			System.out.println("data nula");
			System.out.println("Offline;" + ap.getDatacriacao());

		}
		anuncioControlPlataforma.updateAnuncioPlataforma(ap);
	}

	public void redirect() throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect(selected.getLink());
	}

	public int daysToExpire(AnuncioPlataforma anuncioPlataforma) {
		if (!(anuncioPlataforma.getDatacriacao() == null)) {
			Duration duration = Duration.between(anuncioPlataforma.getDatacriacao(), LocalDateTime.now());
			int days = anuncioPlataforma.getPlataforma().getPeriodoRenovacao() - (int) duration.toDays();

			return days;
		}
		return 0;

	}

	public LocalDateTime expirationDate(AnuncioPlataforma anuncioPlataforma) {

		if (!(anuncioPlataforma.getDatacriacao() == null)) {
			LocalDateTime date = anuncioPlataforma.getDatacriacao()
					.plusDays(anuncioPlataforma.getPlataforma().getPeriodoRenovacao());

			return date;
		}
		return null;
	}

	public Collection<AnuncioPlataforma> getAPList() {
		return APList;
	}

	public void setAPList(Collection<AnuncioPlataforma> aPList) {
		APList = aPList;
	}


	@PostConstruct
	public void load() {
		APList = anuncioControlPlataforma.AnunciosPlataforma();

	}

}
