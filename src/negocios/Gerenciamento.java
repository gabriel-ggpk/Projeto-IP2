package negocios;


import dados.RepoPessoas;
import negocios.bean.Aluno;

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
		if(!pessoas.getPessoas().contains(pessoa)) pessoas.adicionar(pessoa);
		else System.out.println("pessoa ja existente");
	}
	public void removerPessoa(Pessoa pessoa) {
		if(!pessoas.getPessoas().contains(pessoa)) pessoas.remover(pessoa);
		else System.out.println("pessoa não existente");
	}
	public void matricularAluno(Aluno aluno, Disciplina disciplina, double semestre) {
		
		aluno.adicionarMatricula(disciplina,semestre);
	}
}
