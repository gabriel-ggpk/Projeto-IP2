package negocios.bean;

import dados.RepoAlunoMatriculado;

public class Aluno extends Pessoa {
	private RepoAlunoMatriculado matriculas;

	public Aluno (String nome, String senha, String codigo) {
		super(nome, senha, codigo);
		matriculas = new RepoAlunoMatriculado();
	}
	
	public void adicionarMatricula(Disciplina disciplina,double semestre) {
		AlunoMatriculado matricula = new AlunoMatriculado(this, disciplina, semestre);
		if(!matriculas.getMatriculas().contains(matricula)) {
			this.matriculas.adicionarMatricula(matricula);
		}
		else System.out.println("matricula ja existente");
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
