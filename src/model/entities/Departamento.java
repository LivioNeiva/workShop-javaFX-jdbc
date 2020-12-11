package model.entities;

public class Departamento {

	private Integer id;
	private String nome;
	
	public Departamento() {
		
	}
	public Departamento(Integer id, String nome) {
		this.id=id;
		this.nome=nome;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	public Integer getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + "]";
	}
	
}
