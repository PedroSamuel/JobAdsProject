package bean;


import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import control.ControlPlataforma;
import model.Plataforma;

@Named("plataformaCreate")
@ViewScoped
public class CriarPlataforma implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ControlPlataforma controlPlataforma;

	private Plataforma plataforma = new Plataforma();

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma p) {
		plataforma = p;
	}

	public String salvarPlataforma() {
		controlPlataforma.criarPlataforma(plataforma);
		return "listaPlataformas?faces-redirect=true";
	}

	public void criarPlataforma() {
		controlPlataforma.criarPlataforma(new Plataforma());
	}
	
	
	

}
