package negocios.bean;

import dados.RepoAlunoMatriculado;

public class Aluno extends Pessoa {
	private RepoAlunoMatriculado matriculas;

	public Aluno (String nome, String senha, String codigo) {
		super(nome, senha, codigo);
		matriculas = new RepoAlunoMatriculado();
	}
	
	public boolean adicionarMatricula(Disciplina disciplina,double semestre) {
		AlunoMatriculado matricula = new AlunoMatriculado(this, disciplina, semestre);
		if(!matriculas.getMatriculas().contains(matricula)) {
			return this.matriculas.adicionarMatricula(matricula);
		}
		else return false;
	}
	public boolean removerMatricula(Disciplina disciplina) {
		return matriculas.getMatriculas().remove(matriculas.disciplinaCursando(disciplina));
		
	}
	
	public String getNome () {
		return super.getNome();
	}
	public RepoAlunoMatriculado getMatriculas() {
		return matriculas;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s","Aluno", super.toString());
	}
}
