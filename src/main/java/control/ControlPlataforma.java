package control;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Plataforma;
import repository.RepositorioPlataformas;

@Transactional
@RequestScoped
public class ControlPlataforma {
	
	@Inject
	RepositorioPlataformas dbP ;
	
	@Inject
	ControlAnuncio anuncioControl;
	
	public void criarPlataforma(Plataforma plataforma) {
		dbP.createEntity(plataforma);
		System.out.println("Verificar Tarefa Aplicar");
		anuncioControl.verificarTarefaAplicar();
	}
	
	public List<Plataforma> Plataformas(){
		return dbP.getAllWithAnuncios();
	}
	
	public Plataforma getPlataforma (Long id) {
		return dbP.getEntity(Plataforma.class,  id);
		
	}
	
	public void updatePlataforma(Plataforma p) {
		dbP.updateEntity(p);
	}
	
	public void removePlataforma(Plataforma plataforma) {
		dbP.removeEntity(plataforma);
		System.out.println("Verificar Tarefa Aplicar");
		anuncioControl.verificarTarefaAplicar();
		
	}

	public Long countPlataformas() {
		return dbP.countPlataformas();
	}
	

	

}
