package negocios.bean;

public class Professor extends Pessoa {
	private Disciplina disciplina;

	public Professor(String nome, String senha, Disciplina disciplina) {
		super(nome, senha);
		this.disciplina = disciplina;
	}
	
}
