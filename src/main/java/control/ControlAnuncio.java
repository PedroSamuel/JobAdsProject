package control;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Anuncio;
import model.AnuncioPlataforma;
import repository.RepositorioAnuncios;
import repository.RepositorioPlataformas;

@Transactional
@RequestScoped
public class ControlAnuncio {
	@Inject
	private RepositorioAnuncios dbA ;
	
	@Inject
	private RepositorioPlataformas dbP;
	
	@Inject
	private ControlAnuncioPlataforma APControl;
	
	public void criarAnuncio(Anuncio anuncio) {
		dbA.createEntity(anuncio);
	}
	
	public List<Anuncio> Anuncios(){
		return dbA.getAllWithPlataformas();
	}
	
	public Anuncio getAnuncio(long id){
		for (Anuncio anuncio: Anuncios()){
			if (anuncio.getId() == id) {
				return anuncio;
			}
		}
		return null;
	}
	
	public Anuncio getAnuncio (Long id) {
		return dbA.getEntity(Anuncio.class,  id);
		
	}
	
	public void updateAnuncio(Anuncio a) {
		a = verificarTarefa(a);
		dbA.updateEntity(a);
	}
	
	
	public void removeAnuncio(Anuncio anuncio) {
		for (AnuncioPlataforma ap : anuncio.getPlataformas()){
			APControl.removeAnuncioPlataforma(ap);
		}
		dbA.removeEntity(anuncio);
	}
	


	public Collection<Anuncio> comTarefa() {
		return dbA.comTarefa();
		
	}

	public Long countAnuncios() {
		return dbA.countAnuncios();
	}
	
	
	
	public Anuncio verificarTarefa(Anuncio anuncio) {
		anuncio = getAnuncioWithPlataformasById(anuncio.getId());
		System.out.println("verificar tarefa");
		boolean alterado = false;
		long numPlataformas = anuncio.countPlataformas();
		System.out.println("count plataformas associadas" + numPlataformas);
		long numPlataformasOnline = anuncio.countPlataformasOnline();
		System.out.println("count Plats Online " + numPlataformasOnline);
		long countPlataformas = dbP.countPlataformas();
		System.out.println("count todas Plataformas " + countPlataformas);
		switch (anuncio.getEstado()) {
			case "Aplicar":

			if ((countPlataformas > 0) && (numPlataformas == countPlataformas)) {
				anuncio.setEstado("Manter");
				anuncio.feito();
				System.out.println("Totalmente Aplicado o Anuncio, mudado para manter:" + anuncio.getREF());
				alterado = true;
				break;
			} else {
				if (!anuncio.getTarefas().equals("!!!!"))
					;
				anuncio.temTarefa();
				System.out.println("tem plataformas por aplicar o anuncio " + anuncio.getREF());
				alterado = true;
				break;
			}
		case "Manter":
			if (numPlataformasOnline == numPlataformas) {
				if (anuncio.getTarefas().equals("!!!!")) {
					anuncio.feito();
					alterado = true;
					System.out.println(
							"Todas as plataformas registadas estao online para o anuncio que tem estado manter: "
									+ anuncio.getREF());
					break;
				}
			} else if (anuncio.getTarefas().equals("Feito")) {
				anuncio.temTarefa();
				System.out.println("plataformas offline no anuncio que tem estado manter: " + anuncio.getREF());
				alterado = true;
				break;
			}
		case "Retirar":
			if ((numPlataformas == 0) && (anuncio.getTarefas() == "!!!!")) {
				anuncio.feito();
				System.out.println("Anuncio completamente retirado " + anuncio.getREF());
				alterado = true;
				break;
			} else if (anuncio.getTarefas() == "Feito") {
				System.out.println("anuncio tem plataformas por retirar " + anuncio.getREF());
				anuncio.temTarefa();
				alterado = true;
				break;
			}
		default:
			System.out.println("Erro no anuncio " + anuncio.getREF());
			break;
		}
		//if (alterado == true) {
			//dbA.updateEntity(anuncio);
		//}
		return anuncio;
	}

	private Anuncio getAnuncioWithPlataformasById(Long id) {
		return dbA.getAnuncioWithPlataformasById(id);
		
		
	}

	
	
	
	
	
}
