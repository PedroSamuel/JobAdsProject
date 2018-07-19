package bean;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import control.ControlRequerimento;

import model.Requerimento;


@Named("requerimentoCreate")
@RequestScoped
public class CriarRequerimento {
	
	@Inject
	ControlRequerimento controlRequerimento;

	private Requerimento requerimento = new Requerimento();

	public Requerimento getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(Requerimento r) {
		requerimento = r;
	}

	public String salvarRequerimento() {
		controlRequerimento.criarRequerimento(requerimento);
		return "pedirRequerimento?faces-redirect=true";
	}

	public void criarRequerimento() {
		controlRequerimento.criarRequerimento(new Requerimento());
	}
	
	

}
