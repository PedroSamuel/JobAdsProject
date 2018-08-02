package bean;


import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;



@Named("nav")
@ApplicationScoped
public class Navigator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5158381528968071445L;
	/**
	 * 
	 */
	
	
	
	private long requerimentoId;
	private long anuncioId;
	private String lastPage;
	
	
	public long getRequerimentoId() {
		return requerimentoId;
	}
	public void setRequerimentoId(long requerimentoId) {
		this.requerimentoId = requerimentoId;
	}
	public long getAnuncioId() {
		return anuncioId;
	}
	public void setAnuncioId(long anuncioId) {
		this.anuncioId = anuncioId;
	}
	public  String getLastPage() {
		return lastPage;
	}
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}
	
	public String goTo(String pagActual, String goTo){
		lastPage = pagActual;
		System.out.println("From:");
		System.out.println(pagActual);
		System.out.println("To");
		System.out.println(goTo);
		return goTo + "?faces-redirect=true";
	}
	
	
	
}
