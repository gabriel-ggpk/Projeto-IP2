package negocios;


import java.util.ArrayList;
import dados.RepoAlunoMatriculado;
import dados.RepoDiscplina;
import dados.RepoPessoas;
import dados.RepoSemestres;
import exceptions.ContaNaoExisteException;
import exceptions.LoginJaExisteException;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Coordenacao;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;

public class Gerenciamento {
	private RepoPessoas pessoas;
	private RepoDiscplina discplina;
	private RepoAlunoMatriculado alunosMatriculados;
	private RepoSemestres semestres;
	private Pessoa usuario;
	private static Gerenciamento _inst;
	public static Gerenciamento getInstMain() {
		if(_inst ==null) {
			_inst = new Gerenciamento();
		}
		return _inst;
	}
	
	private Gerenciamento() {
		discplina = new RepoDiscplina();
		pessoas = new RepoPessoas();
		alunosMatriculados = new RepoAlunoMatriculado();
		semestres = new RepoSemestres();
		testes();
	}
	
	private void testes() {
		semestres.adicionarSemestre(2020.1);
		semestres.adicionarSemestre(2020.2);
		
		Pessoa Aluno1 = new Aluno("gabriel","123","123");
		pessoas.adicionar(Aluno1);
		Pessoa Aluno2 = new Aluno("roberto","1234","1234");
		pessoas.adicionar(Aluno2);
		
		Disciplina Disciplina1 = new Disciplina("mat", 50, 50);
		discplina.adicionar(Disciplina1);
		Disciplina Disciplina2 = new Disciplina("fis", 50, 50);
		discplina.adicionar(Disciplina2);
		Disciplina Disciplina3 = new Disciplina("art", 50, 50);
		discplina.adicionar(Disciplina3);
		Disciplina Disciplina4 = new Disciplina("bio", 50, 50);
		discplina.adicionar(Disciplina4);
		
		matricularAluno(((Aluno)Aluno1), Disciplina1, 2020.1);
		matricularAluno(((Aluno)Aluno1), Disciplina2, 2020.1);
		matricularAluno(((Aluno)Aluno1), Disciplina3, 2020.1);
		matricularAluno(((Aluno)Aluno1), Disciplina4, 2020.1);
		
		ArrayList<AlunoMatriculado> testando= alunosMatriculados.getMatriculasSemestre(2020.1);
		for(AlunoMatriculado t:testando) {
			t.setCursando(-1);
		}
		matricularAluno(((Aluno)Aluno1), Disciplina1, 2020.2);
		matricularAluno(((Aluno)Aluno1), Disciplina2, 2020.2);
		matricularAluno(((Aluno)Aluno1), Disciplina3, 2020.2);
		matricularAluno(((Aluno)Aluno1), Disciplina4, 2020.2);
		
		Pessoa prof = new Professor("Luca", "000", "000", Disciplina1);
		pessoas.adicionar(prof);
		
		Pessoa cordenacao = new Coordenacao("Thomas", "111", "111", "departamento");
		pessoas.adicionar(cordenacao);
	}
	
	public boolean logIn(String codigo, String senha) throws ContaNaoExisteException {
		usuario = pessoas.logIN(codigo, senha);
		if(usuario == null) {
			throw new ContaNaoExisteException(codigo, senha);
		}
		return true;
	}
	public void logOut() {
		usuario = null;
	}
	
	public void cadastrarPessoa(Pessoa pessoa) throws LoginJaExisteException {
		boolean existe = false;
		for(Pessoa p : pessoas.getPessoas()) {
			if (p.getCodigo().equals(pessoa.getCodigo())) {
				existe = true;
				break;
			}
		}

		if(!existe) pessoas.adicionar(pessoa);
		else throw new LoginJaExisteException(pessoa.getCodigo());
	}
	public void removerPessoa(Pessoa pessoa) {
		if(!pessoas.getPessoas().contains(pessoa)) pessoas.remover(pessoa);
		else System.out.println("pessoa n�o existente");
	}
	
	public void matricularAluno(Disciplina disciplina, double semestre) {
		if(usuario instanceof Aluno) {
			this.matricularAluno(((Aluno) usuario), disciplina, semestre);	
		}
	}
	public void matricularAluno(Aluno aluno, Disciplina disciplina, double semestre) {
		AlunoMatriculado matricula = new AlunoMatriculado(aluno, disciplina, semestre);
		alunosMatriculados.adicionarMatricula(matricula);	
	}
	
	public RepoPessoas getPessoas() {
		return pessoas;
	}
	public RepoDiscplina getDiscplina() {
		return discplina;
	}
	public RepoAlunoMatriculado getAlunoMatriculado() {
		return alunosMatriculados;
	}
	public RepoSemestres getSemestres() {
		return semestres;
	}
	
	public Pessoa getUsuario() {
		return usuario;
	}
	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
}
