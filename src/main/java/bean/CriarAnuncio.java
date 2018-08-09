package bean;


import java.io.Serializable;
import java.time.LocalDate;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import control.ControlAnuncio;
import control.ControlRequerimento;
import mail.SSLEmail;
import model.Anuncio;
import model.Requerimento;



@Named("anuncioCreate")
@ViewScoped
public class CriarAnuncio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5001183263825186972L;

	@Inject
	ControlAnuncio controlAnuncio;
	@Inject
	ControlRequerimento controlReq;
	
	private Requerimento req; 

	private Anuncio anuncio = new Anuncio();
	
	private String idRequerimento;
	
	private String mailReq;
	
	public String getMailReq() {
		return mailReq;
	}

	public void setMailReq(String mailReq) {
		this.mailReq = mailReq;
	}
	
	private String body;
	
	
	public String getBody() {
		return body;
	}

	
	public void setBody(String body) {
		this.body = body;
	}
	
	
	private LocalDate date = LocalDate.now();
	
	

	public LocalDate getDate() {
		return date;
	}

	
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}
	
	public void setAnuncio(Anuncio p) {
		anuncio = p;
	}

	public String salvarAnuncio() {
		System.out.println("Metodo Salvar Anuncio");
		controlAnuncio.criarAnuncio(anuncio);
		if (idRequerimento != null) {
			processarReq();
			} else {
				System.out.println("Não está ok!");
			}
		
		body = "O seu pedido foi processado pelos Recursos Humanos com a referência: " +anuncio.getREF()+"\n\n Requisitos do Candidato:\n "+ anuncio.getRequisitos()+ "\n" + "Data: " +  getDate();
		SSLEmail.SSlAdsCreate(mailReq, anuncio.getFuncao(), body);
		
		return "DashboardRH?faces-redirect=true";
	}

	public void criarAnuncio() {
		controlAnuncio.criarAnuncio(new Anuncio());
	}
	
	public void processarReq() {
		System.out.println("processando requerimento " + req.getId());
		req.processar();
		controlReq.updateRequerimento(req);
	}

	public String getIdRequerimento() {
		return idRequerimento;
	}

	public void setIdRequerimento(String idRequerimento) {
		this.idRequerimento = idRequerimento;
	}
	
	public void load() {
		if (idRequerimento != null) {
			System.out.println("correu " + idRequerimento);
			anuncio.setIdRequerimento(idRequerimento);
			req = controlReq.getRequerimento(Long.valueOf(idRequerimento));
			mailReq = req.getEmail();
			System.out.println(mailReq);
			anuncio.setManager(req.getRequerente());
			anuncio.setFuncao(req.getFuncao());
			anuncio.setRequisitos(req.getRequisitos());
			
			
		} else {
			System.out.println("Sem parametro");
		}
	}

}
