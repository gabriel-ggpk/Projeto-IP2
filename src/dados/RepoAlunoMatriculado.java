package dados;

import java.util.ArrayList;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

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
	public AlunoMatriculado buscarMatricula(Disciplina disciplina) {
		for(AlunoMatriculado a:matriculas) {
			if(a.getDisciplina().equals(disciplina)) {
				return a;
			}
		}
		System.out.println("log: Matricula inexistente");
		return null;
		
	}
	
}
