package negocios.bean;

public class Professor extends Pessoa {
	private Disciplina disciplina;

	public Professor(String nome, String senha,String codigo, Disciplina disciplina) {
		super(nome, senha,codigo);
		this.disciplina = disciplina;
	}
	
}
