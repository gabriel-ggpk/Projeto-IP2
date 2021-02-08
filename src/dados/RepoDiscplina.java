package dados;

import java.util.ArrayList;

import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;

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
	
	public ArrayList<Aluno> devolverAluno(Disciplina materia){
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas = Gerenciamento.getInstMain().getPessoas().getPessoas();
		Aluno alunoTemp;
		ArrayList<Aluno> alunos = new ArrayList<>();
		
		for(int n = 0; n < pessoas.size(); n++) {
			if(pessoas.get(n) instanceof Aluno) {
				alunoTemp = (Aluno)pessoas.get(n);
				for(int i = 0; i < alunoTemp.getMatriculas().getMatriculas().size(); i++) {
					if(alunoTemp.getMatriculas().getMatriculas().get(i).getDisciplina() == materia) {
						alunos.add(alunoTemp);
					}
				}
			}
		}
		return alunos;
	}
	
	public Professor devolverProfessor(Disciplina materia){
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas = Gerenciamento.getInstMain().getPessoas().getPessoas();
		Professor teste;
		Professor professor = null;
		
		for(int n = 0; n < pessoas.size(); n++) {
			if(pessoas.get(n) instanceof Professor) {
				teste = (Professor) pessoas.get(n);
				if(teste.getDisciplina() == materia) {
					professor = teste;
				}
			}
		}
		return professor;
	}
}
