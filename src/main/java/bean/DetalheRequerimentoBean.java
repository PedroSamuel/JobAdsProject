package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import control.ControlRequerimento;

import model.Requerimento;

@Named("DRequerimento")
@ViewScoped
public class DetalheRequerimentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5364338616802353799L;

	@Inject
	ControlRequerimento controlRequerimento;

	private String IdRequerimento;

	private Requerimento requerimento;

	public String getIdRequerimento() {
		return IdRequerimento;
	}

	public void setIdRequerimento(String idRequerimento) {
		IdRequerimento = idRequerimento;
	}

	public Requerimento getRequerimento() {
		return requerimento;
	}

	public void setRequerimento(Requerimento r) {
		requerimento = r;
	}

	
	public void load() {
		if (IdRequerimento == (null)) {
			System.out.println("Não Funcionou!");
		} else {
			long longID = Long.valueOf(IdRequerimento);
			setRequerimento(controlRequerimento.getRequerimento(longID));
			System.out.println("Ok" + longID);
		}

	}
}