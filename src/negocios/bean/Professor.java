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
		return String.format("%s%n%s | %s","Professor", super.toString(), this.getDisciplina());
	}
	
	public void darNota(AlunoMatriculado aluno, double nota, int numeroProva) {
		if(numeroProva >= 1 && numeroProva <= 4 &&nota>=0&&nota<=10) {
			aluno.adicionarNota(nota, numeroProva);
		}
	}
	
	public void darFalta(AlunoMatriculado aluno) {
		aluno.darFalta();
	}

	public void tirarFalta(AlunoMatriculado aluno) {
		aluno.tirarFalta();
	}

}
