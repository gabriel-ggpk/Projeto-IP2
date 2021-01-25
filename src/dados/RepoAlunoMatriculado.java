package dados;

import java.util.ArrayList;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class RepoAlunoMatriculado {
	private ArrayList<AlunoMatriculado> matriculas = new ArrayList<>();
	
	public RepoAlunoMatriculado() {
	
	}
	
	public void adicionarMatricula(AlunoMatriculado matricula) {
		if (!matriculas.contains(matricula)) {
			matriculas.add(matricula);
		}
		else {
			System.out.println("Já esta matriculado em " + matricula.getDisciplina() + " em " + matricula.getSemestre());
		}
		
	}

	public ArrayList<AlunoMatriculado> getMatriculas() {
		return matriculas;
	}
	
	public ArrayList<AlunoMatriculado> getMatriculas(double semestre) {
		ArrayList<AlunoMatriculado> matriculasDoSemestre = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getSemestre() == semestre) {
				matriculasDoSemestre.add(matriculas.get(n));
			}
		}
		
		return matriculasDoSemestre;
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
