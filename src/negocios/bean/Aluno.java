package negocios.bean;

import dados.RepoAlunoMatriculado;

public class Aluno extends Pessoa {
	private RepoAlunoMatriculado matriculas;

	public Aluno (String nome, String senha, String codigo) {
		super(nome, senha, codigo);
		matriculas = new RepoAlunoMatriculado();
	}
	
	public void adicionarMatricula (AlunoMatriculado matricula) {
		this.matriculas.adicionarMatricula(matricula);
	}
	
	public String getNome () {
		return super.getNome();
	}
	public RepoAlunoMatriculado getMatriculas() {
		return matriculas;
	}
}
