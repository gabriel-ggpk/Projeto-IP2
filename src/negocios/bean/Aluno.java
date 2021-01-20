package negocios.bean;

import dados.RepoAlunoMatriculado;

public class Aluno extends Pessoa {
	private String entrada;
	private RepoAlunoMatriculado matriculas;

	public Aluno(String nome, String senha,String entrada) {
		super(nome, senha);
		this.entrada = entrada;
		matriculas = new RepoAlunoMatriculado();
	}
	public void adicionarMatricula(AlunoMatriculado matriculado) {
		for(AlunoMatriculado m: matriculas.getMatriculas()) {
			if(matriculado.equals(m)) {
				
			}
		}
	}
	
}
