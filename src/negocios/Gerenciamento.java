package negocios;


import dados.RepoPessoas;
import negocios.bean.Aluno;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;

public class Gerenciamento {
	private RepoPessoas pessoas = new RepoPessoas();
	private Pessoa usuario;
	public Gerenciamento() {	
	}
	public void logIn(String codigo, String senha) {
		for(Pessoa p: pessoas.getPessoas()) {
			if(codigo.equals(p.getCodigo())) {
				if(senha.equals(p.getSenha())) {
					usuario = p;
				}
				else System.out.println("senha incorreta");	
			}
			else System.out.println("usuario inexistente");
		}
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
	public void setPessoas(RepoPessoas pessoas) {
		this.pessoas = pessoas;
	}
	public Pessoa getUsuario() {
		return usuario;
	}
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	
}
