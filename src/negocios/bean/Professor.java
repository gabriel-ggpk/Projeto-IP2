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
	public String getMateria() {
		if(disciplina == null) {
			return "Disponivel ";
		}
		return this.disciplina.getNome();
	}

	@Override
	public String toString() {
		return String.format("Professor " + this.getMateria() + "\n" + super.toString());
	}
	
	

}
