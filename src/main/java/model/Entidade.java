package model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public abstract class Entidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
		
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof Entidade) && (id != null) ? id.equals(((Entidade) other).id) : (other == this);
	}

	@Override
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}

	@Override
	public String toString() {
		return String.format("ExampleEntity[%d]", id);
	}

}
