package negocios;


import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;

public class Gerenciamento {
	
	
	public void logIn(String nome,String senha) {
		
	}
	public void logOut() {
		
	}
	public void cadastrarPessoa(Pessoa pessoa) {
		
	}
	public void removerPessoa(Pessoa pessoa) {
		
	}
	public void matricularAluno(Aluno aluno,Disciplina disciplina) {
		AlunoMatriculado matricula = new AlunoMatriculado(aluno, disciplina);
		aluno.adicionarMatricula(matricula);
	}
}
