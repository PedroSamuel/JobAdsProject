package bean;


import java.util.concurrent.TimeUnit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.*;

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
	
		requerimento.setData(LocalDateTime.now());
		controlRequerimento.criarRequerimento(requerimento);
		return "pedirRequerimento?faces-redirect=true";
	}

	public void criarRequerimento() {
		controlRequerimento.criarRequerimento(new Requerimento());
	}
	

}
