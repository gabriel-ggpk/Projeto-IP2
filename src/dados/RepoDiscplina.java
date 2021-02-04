package dados;

import java.util.ArrayList;

import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;

public class RepoDiscplina {
	private ArrayList<Disciplina> materia = new ArrayList<>();
	
	public RepoDiscplina() {
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
	
	public ArrayList<AlunoMatriculado> devolverAluno(String materia){
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas = Gerenciamento.getInstMain().getPessoas().getPessoas();
		Aluno teste;
		ArrayList<AlunoMatriculado> alunos = new ArrayList<>();
		
		for(int n = 0; n < pessoas.size(); n++) {
			if(pessoas.get(n) instanceof Aluno) {
				teste = (Aluno) pessoas.get(n);
				alunos = teste.getMatriculas().buscarDisciplinas(materia);
			}
		}
		return alunos;
	}
}
