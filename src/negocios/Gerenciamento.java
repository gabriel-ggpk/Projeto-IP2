package negocios;


import dados.RepoPessoas;
import negocios.bean.Aluno;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;

public class Gerenciamento {
	private RepoPessoas pessoas = new RepoPessoas();
	private Pessoa usuario;
	private Gerenciamento() {
		pessoas = new RepoPessoas();
		testes();
	}
	private static Gerenciamento _inst;
	public static Gerenciamento getInstMain() {
		if(_inst ==null) {
			_inst = new Gerenciamento();
		}
		return _inst;
	}
	
	public boolean logIn(String codigo, String senha) {
		for(Pessoa p: pessoas.getPessoas()) {
			if(codigo.equals(p.getCodigo())) {
				if(senha.equals(p.getSenha())) {
					usuario = p;
					return true;
				}
				else return false;	
			}
			else return false;
		}
		return false;
	}
	
	public void logOut() {
		usuario = null;
	}
	private void testes() {
		Pessoa teste = new Aluno("gabriel","123","123");
		pessoas.adicionar(teste);
		Disciplina tested01 = new Disciplina("mat", 50, 50);
		Disciplina tested02 = new Disciplina("fis", 50, 50);
		Disciplina tested03 = new Disciplina("art", 50, 50);
		Disciplina tested04 = new Disciplina("bio", 50, 50);
		matricularAluno(((Aluno)teste),tested01,2020.1);
		matricularAluno(((Aluno)teste),tested02,2020.1);
		matricularAluno(((Aluno)teste),tested03,2020.1);
		matricularAluno(((Aluno)teste),tested04,2020.1);
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
	public Pessoa getUsuario() {
		return usuario;
	}
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
	
}
