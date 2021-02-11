package dados;

import java.util.ArrayList;
import negocios.bean.Disciplina;

public class RepoDiscplina {
	private ArrayList<Disciplina> materia;
	
	public RepoDiscplina() {
	materia = new ArrayList<>();
	}
	public RepoDiscplina(ArrayList<Disciplina> json) {
		materia = json;
	}
	public void adicionar(Disciplina disciplina) {
		materia.add(disciplina);
	}
	public void remover(Disciplina disciplina) {
		materia.remove(disciplina);
	}
	public ArrayList<Disciplina> getLista(){
		return materia;
	}
	
}
