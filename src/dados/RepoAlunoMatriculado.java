package dados;

import java.util.ArrayList;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class RepoAlunoMatriculado {
	private ArrayList<AlunoMatriculado> matriculas = new ArrayList<>();
	
	public RepoAlunoMatriculado() {
	}
	
	public boolean adicionarMatricula(AlunoMatriculado matricula) {
		matricula.getDisciplina().preencherVaga();
		return	matriculas.add(matricula);
	}
	
	public ArrayList<AlunoMatriculado> getMatriculas() {
		return matriculas;
		
	}
	public void reprovarMatricula(AlunoMatriculado aluno) {
		aluno.getDisciplina().liberarVaga();
		aluno.setCursando(-1);
		
	}
	public ArrayList<AlunoMatriculado> getMatriculas(Disciplina disciplina, double semestre) {
		ArrayList<AlunoMatriculado> matriculasDoSemestre = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getSemestre() == semestre && matriculas.get(n).getDisciplina().equals(disciplina)) {
				matriculasDoSemestre.add(matriculas.get(n));
			}
		}
		
		return matriculasDoSemestre;
	}

	public ArrayList<AlunoMatriculado> getMatriculasDisciplina(Disciplina disciplina) {
		ArrayList<AlunoMatriculado> matriculasNaDisciplina = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getDisciplina().equals(disciplina)) {
				matriculasNaDisciplina.add(matriculas.get(n));
			}
		}
		
		return matriculasNaDisciplina;
	}
	
	public ArrayList<AlunoMatriculado> getMatriculasSemestre(double semestre) {
		ArrayList<AlunoMatriculado> matriculasDoSemestre = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getSemestre() == semestre) {
				matriculasDoSemestre.add(matriculas.get(n));
			}
		}
		
		return matriculasDoSemestre;
	}
	public AlunoMatriculado getMatriculaUnica(Aluno aluno,Disciplina disciplina) {
		ArrayList<AlunoMatriculado> list = getMatriculasAlunoCursando(aluno);
		for(AlunoMatriculado l:list) {
			if(l.getDisciplina().equals(disciplina)) return l; 
		}
		return null;
		
	}
	public ArrayList<AlunoMatriculado> getMatriculasAlunoCursando(Aluno aluno) {
        ArrayList<AlunoMatriculado> matriculasDoAluno = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getAluno().equals(aluno) && matriculas.get(n).getCursando() == 0) {
				matriculasDoAluno.add(matriculas.get(n));
			}
		}
		
		return matriculasDoAluno;
	}
	public ArrayList<Double> getPeriodosAluno(Aluno aluno){
		ArrayList<AlunoMatriculado> matriculasDoAluno= getMatriculasAluno(aluno);
		ArrayList<Double> periodos = new ArrayList<>();
		for(AlunoMatriculado mat:matriculasDoAluno) {
			if(!periodos.contains(mat.getSemestre())) {
				periodos.add(mat.getSemestre());
			}
		}
		return periodos;
	}
	
	public ArrayList<AlunoMatriculado> getMatriculasAluno(Aluno aluno) {
		ArrayList<AlunoMatriculado> matriculasDoAluno = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getAluno().equals(aluno)) {
				matriculasDoAluno.add(matriculas.get(n));
			}
		}
		
		return matriculasDoAluno;
	}
	public ArrayList<AlunoMatriculado> getMatriculasAluno(Aluno aluno,double periodo) {
		ArrayList<AlunoMatriculado> matriculasDoAluno = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getAluno().equals(aluno)&&matriculas.get(n).getSemestre()==periodo) {
				matriculasDoAluno.add(matriculas.get(n));
			}
		}
		
		return matriculasDoAluno;
	}
	
	public ArrayList<AlunoMatriculado> getMatriculasCursando() {
		ArrayList<AlunoMatriculado> cadeirasCursando = new ArrayList<AlunoMatriculado>();
		
		for(AlunoMatriculado m : matriculas) {
			if(m.getCursando() == 0) {
				cadeirasCursando.add(m);
			}
		}
		
		return cadeirasCursando;
	}
	
	public ArrayList<Aluno> getAlunosDisciplina(Disciplina disciplina) {
		ArrayList<Aluno> alunosNaDisciplina = new ArrayList<>();
		
		for (int n = 0; n < matriculas.size(); n++) {
			if (matriculas.get(n).getDisciplina().equals(disciplina)) {
				if(!alunosNaDisciplina.contains(matriculas.get(n).getAluno())) {
					alunosNaDisciplina.add(matriculas.get(n).getAluno());
				}
			}
		}
		
		return alunosNaDisciplina;
	}
	
}
