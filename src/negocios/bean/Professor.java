package negocios.bean;

public class Professor extends Pessoa {
	private Disciplina disciplina;

	public Professor(String nome, String senha, String codigo, Disciplina disciplina) {
		super(nome, senha, codigo);
		this.disciplina = disciplina;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s  ","Professor", super.toString());
	}
	
	

}
