package negocios;


import dados.RepoPessoas;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;

public class Gerenciamento {
	private RepoPessoas pessoas = new RepoPessoas();
	
	public void logIn(String codigo, String senha) {
		pessoas.logIN(codigo, senha);
	}
	public void logOut() {
		
	}
	public void cadastrarPessoa(Pessoa pessoa) {
		
	}
	public void removerPessoa(Pessoa pessoa) {
		
	}
	public void matricularAluno(Aluno aluno, Disciplina disciplina, double semestre) {
		
		aluno.adicionarMatricula(disciplina,semestre);
	}
}
