package negocios;


import java.util.ArrayList;

import dados.RepoPessoas;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;

public class Gerenciamento {
	private RepoPessoas pessoas;
	private Pessoa usuario;
	private static Gerenciamento _inst;
	public static Gerenciamento getInstMain() {
		if(_inst ==null) {
			_inst = new Gerenciamento();
		}
		return _inst;
	}
	
	private Gerenciamento() {
		pessoas = new RepoPessoas();
		testes();
	}
	
	private void testes() {
		Pessoa teste = new Aluno("gabriel","123","123");
		pessoas.adicionar(teste);
		Pessoa teste2 = new Aluno("gabriel","1234","1234");
		pessoas.adicionar(teste2);
		Disciplina tested01 = new Disciplina("mat", 50, 50);
		Disciplina tested02 = new Disciplina("fis", 50, 50);
		Disciplina tested03 = new Disciplina("art", 50, 50);
		Disciplina tested04 = new Disciplina("bio", 50, 50);
		
		matricularAluno(((Aluno)teste),tested01,2020.1);
		matricularAluno(((Aluno)teste),tested02,2020.1);
		matricularAluno(((Aluno)teste),tested03,2020.1);
		matricularAluno(((Aluno)teste),tested04,2020.1);
		ArrayList<AlunoMatriculado> testando= ((Aluno)teste).getMatriculas().getMatriculas(2020.1);
		for(AlunoMatriculado t:testando){t.setCursando(false);}
		matricularAluno(((Aluno)teste),tested01,2020.2);
		matricularAluno(((Aluno)teste),tested02,2020.2);
		matricularAluno(((Aluno)teste),tested03,2020.2);
		matricularAluno(((Aluno)teste),tested04,2020.2);
		
		Pessoa prof = new Professor("Luca", "000", "000", tested01);
		pessoas.adicionar(prof);
		
	}
	
	public boolean logIn(String codigo, String senha) {
		usuario = pessoas.logIN(codigo, senha);
		if(usuario != null) {
			return true;
		}
		return false;
	}
	
	public void logOut() {
		usuario = null;
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		if(!pessoas.getPessoas().contains(pessoa)) pessoas.adicionar(pessoa);
		else System.out.println("pessoa ja existente");
	}
	public void removerPessoa(Pessoa pessoa) {
		if(!pessoas.getPessoas().contains(pessoa)) pessoas.remover(pessoa);
		else System.out.println("pessoa não existente");
	}
	
	public void matricularAluno(Disciplina disciplina, double semestre) {
		if(usuario instanceof Aluno) {
		((Aluno) usuario).adicionarMatricula(disciplina,semestre);	
		}
	}
	public void matricularAluno(Aluno aluno,Disciplina disciplina, double semestre) {
		aluno.adicionarMatricula(disciplina,semestre);	
	}
	public boolean removerMatricula(Disciplina disciplina) {
		if(usuario instanceof Aluno) {
			return ((Aluno) usuario).removerMatricula(disciplina);	
			}
		return false;
	}
	public boolean removerMatricula(Aluno aluno,Disciplina disciplina) {
		
			return aluno.removerMatricula(disciplina);	
			
	}
	
	public void darFalta(Aluno aluno,Disciplina disciplina) {
		aluno.getMatriculas().disciplinaCursando(disciplina).darFalta();
	}
	public void tirarFalta(Aluno aluno,Disciplina disciplina) {
		aluno.getMatriculas().disciplinaCursando(disciplina).tirarFalta();
	}
	public void darNota(Aluno aluno,Disciplina disciplina, double nota, int numeroProva) {
		if(numeroProva >= 1 && numeroProva <= 4 &&nota>=0&&nota<=10) {
		aluno.getMatriculas().disciplinaCursando(disciplina).adicionarNota(nota, numeroProva);	
	    }
	}
	
	public RepoPessoas getPessoas() {
		return pessoas;
	}
	public Pessoa getUsuario() {
		return usuario;
	}
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	
}
