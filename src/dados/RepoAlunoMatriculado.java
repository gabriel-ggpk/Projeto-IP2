package dados;

import java.util.ArrayList;

import negocios.bean.AlunoMatriculado;

public class RepoAlunoMatriculado {
	private ArrayList<AlunoMatriculado> matriculas;
	public RepoAlunoMatriculado() {
	
	}
	public void adicionarMatricula(AlunoMatriculado matricula) {
		matriculas.add(matricula);
	}
	public ArrayList<AlunoMatriculado> getMatriculas() {
		return matriculas;
	}
	
}
