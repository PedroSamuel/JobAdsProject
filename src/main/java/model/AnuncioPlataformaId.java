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
	

	private String isbn; //Id composto para usar 


	@Column(name = "ANUNCIO_ID")
	private long anuncio;
	
	@Column(name = "PLATAFORMA_ID")
	private long plataforma;
	
	
	
	
	@Override
	public int hashCode() {
		return (isbn != null) ? (this.getClass().hashCode() + isbn.hashCode()) : super.hashCode();
	}

	

	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnuncioPlataformaId)) return false;
        AnuncioPlataformaId anuncioPlataformaId = (AnuncioPlataformaId) o;
        return Objects.equals(getIsbn(), anuncioPlataformaId.getIsbn());
    }

    @PostConstruct
	private String getIsbn() {
    	isbn = ("A" + anuncio + "P" + plataforma);
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public long getAnuncio_id() {
		return anuncio;
	}

	public void setAnuncio_id(long anuncio) {
		this.anuncio = anuncio;
	}

	public long getPlataforma_id() {
		return plataforma;
	}

	public void setPlataforma_id(long plataforma) {
		this.plataforma = plataforma;
	
	}
}
