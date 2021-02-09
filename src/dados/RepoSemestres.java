package dados;

import java.util.ArrayList;

public class RepoSemestres {
	private ArrayList<Double> semestres = new ArrayList<>();
	
	public RepoSemestres() {
	}
	
	public void adicionarSemestre(double semestre) {
		semestres.add(semestre);
	}
	
	public ArrayList<Double> getSemestres() {
		return this.semestres;
	}
	
	public double getSemestreAtual() {
		return semestres.get(semestres.size() - 1);
	}

}
