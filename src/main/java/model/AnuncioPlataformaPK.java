package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AnuncioPlataformaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6442153079578196041L;

	@Column(name = "ANUNCIO_ID")
	private Long anuncio_id;
	
	@Column(name = "PLATAFORMA_ID")
	private Long plataforma_id;
}
