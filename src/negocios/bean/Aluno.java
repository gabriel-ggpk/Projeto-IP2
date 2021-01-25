package negocios.bean;

import dados.RepoAlunoMatriculado;

public class Aluno extends Pessoa {
	private int codigo;
	private RepoAlunoMatriculado matriculas;

	public Aluno (String nome, String senha, int codigo) {
		super(nome, senha);
		this.codigo = codigo;
		matriculas = new RepoAlunoMatriculado();
	}
	
	public void adicionarMatricula (AlunoMatriculado matricula) {
		this.matriculas.adicionarMatricula(matricula);
	}
	
	public String getNome () {
		return super.getNome();
	}
	public int getCodigo () {
		return codigo;
	}
	public RepoAlunoMatriculado getMatriculas() {
		return matriculas;
	}
}
