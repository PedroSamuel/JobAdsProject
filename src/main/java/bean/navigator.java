package bean;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


public abstract class navigator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5158381528968071445L;
	/**
	 * 
	 */
	
	
	
	private static long requerimentoId;
	private static long anuncioId;
	private static String lastPage;
	
	
	public static long getRequerimentoId() {
		return requerimentoId;
	}
	public static void setRequerimentoId(long requerimentoId) {
		navigator.requerimentoId = requerimentoId;
	}
	public static long getAnuncioId() {
		return anuncioId;
	}
	public static void setAnuncioId(long anuncioId) {
		navigator.anuncioId = anuncioId;
	}
	public static String getLastPage() {
		return lastPage;
	}
	public static void setLastPage(String lastPage) {
		navigator.lastPage = lastPage;
	}
	
	
}
