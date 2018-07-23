package model;

import java.io.Serializable;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnuncioPlataformaId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6442153079578196041L;
	


	
	@Column(name = "ANUNCIO_ID")
	private Long anuncio_id;
	
	@Column(name = "PLATAFORMA_ID")
	private Long plataforma_id;
	
	
	
	
	@Override
	public int hashCode() {
		//return (isbn != null) ? (this.getClass().hashCode() + isbn.hashCode()) : super.hashCode();
		return anuncio_id.hashCode() + plataforma_id.hashCode();
	}

	

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioPlataformaId)) return false;
        AnuncioPlataformaId that = (AnuncioPlataformaId) o;
        return Objects.equals(getAnuncio_id(), that.getAnuncio_id()) &&
                Objects.equals(getPlataforma_id(), that.getPlataforma_id());
	}
	
	@Override
	public String toString() {
		return String.format("a%d p%d", anuncio_id, plataforma_id );
	}
	
	
	public Long getAnuncio_id() {
		return anuncio_id;
	}

	public void setAnuncio_id(Long anuncio_id) {
		this.anuncio_id = anuncio_id;
	}

	public Long getPlataforma_id() {
		return plataforma_id;
	}

	public void setPlataforma(Long plataforma_id) {
		this.plataforma_id = plataforma_id;
	
	}
}
