package dados;

import java.util.ArrayList;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class RepoAlunoMatriculado {
	private ArrayList<AlunoMatriculado> matriculas = new ArrayList<>();
	
	public RepoAlunoMatriculado() {
	
	}
	
	public boolean adicionarMatricula(AlunoMatriculado matricula) {
		
		return	matriculas.add(matricula);
		
		
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
		if(matriculasDoSemestre.isEmpty()) {
			System.out.println("nenhuma matricula encontrada");
		}
		return matriculasDoSemestre;
	}
	
	public ArrayList<AlunoMatriculado> buscarDisciplinas(Disciplina disciplina) {
		ArrayList<AlunoMatriculado> matriculasNaDisciplina = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getDisciplina().equals(disciplina)) {
				matriculasNaDisciplina.add(matriculas.get(n));
			}
		}
		
		return matriculasNaDisciplina;
	}
	public ArrayList<AlunoMatriculado> buscarDisciplinas(String nome) {
		ArrayList<AlunoMatriculado> matriculasNaDisciplina = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getDisciplina().getNome().equals(nome)) {
				matriculasNaDisciplina.add(matriculas.get(n));
			}
		}
		
		return matriculasNaDisciplina;
	}
	public AlunoMatriculado buscarDisciplina(String nome) {
		for(AlunoMatriculado m: matriculas) {
			if(m.getDisciplina().getNome().equals(nome)&&m.isCursando()) return m;
		}
		return null;
	}
	
	public AlunoMatriculado disciplinaCursando(Disciplina disciplina) {
		for(AlunoMatriculado m: matriculas) {
			if(m.getDisciplina().equals(disciplina)&&m.isCursando()) return m;
		}
		return null;
	}
	public ArrayList<AlunoMatriculado> disciplinasCursando(){
		ArrayList<AlunoMatriculado> cadeirasCursando = new ArrayList<AlunoMatriculado>();
		for(AlunoMatriculado m : matriculas) {
			if(m.isCursando()) {
				cadeirasCursando.add(m);
			}
		}
		return cadeirasCursando;
	}
	
}
