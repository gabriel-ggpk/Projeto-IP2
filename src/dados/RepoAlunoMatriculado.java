package dados;

import java.util.ArrayList;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class RepoAlunoMatriculado {
	private ArrayList<AlunoMatriculado> matriculas = new ArrayList<>();
	
	public RepoAlunoMatriculado() {
	
	}
	
	public void adicionarMatricula(AlunoMatriculado matricula) {
		
			matriculas.add(matricula);
		
		
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
	
	public ArrayList<AlunoMatriculado> buscarDisciplina(Disciplina disciplina) {
		ArrayList<AlunoMatriculado> matriculasNaDisciplina = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getDisciplina() == disciplina) {
				matriculasNaDisciplina.add(matriculas.get(n));
			}
		}
		
		return matriculasNaDisciplina;
	}
	
}
