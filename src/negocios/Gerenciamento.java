package negocios;


import java.io.FileNotFoundException;
import java.io.IOException;
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
	private RepoDiscplina disciplinas;
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
		//testes();
		TesteJson json = new TesteJson();
		try {
			semestres = new RepoSemestres(json.readJSONSemestre());
			disciplinas = new RepoDiscplina(json.readJSONDisciplinas());
			pessoas = new RepoPessoas(json.readJSONPessoas());
			alunosMatriculados = new RepoAlunoMatriculado(json.readJSONMatriculas());
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void testes() {
		semestres = new RepoSemestres();
		pessoas = new RepoPessoas();
		disciplinas = new RepoDiscplina();
		alunosMatriculados = new RepoAlunoMatriculado();
		semestres.adicionarSemestre(2020.1);
		semestres.adicionarSemestre(2020.2);
		
		Pessoa Aluno1 = new Aluno("Gabriel Henrique Cavacanti","123","123");
		pessoas.adicionar(Aluno1);
		Pessoa Aluno2 = new Aluno("roberto","1234","1234");
		pessoas.adicionar(Aluno2);
		
		Disciplina Disciplina1 = new Disciplina("mat", 50, 50);
		disciplinas.adicionar(Disciplina1);
		Disciplina Disciplina2 = new Disciplina("fis", 50, 50);
		disciplinas.adicionar(Disciplina2);
		Disciplina Disciplina3 = new Disciplina("art", 50, 50);
		disciplinas.adicionar(Disciplina3);
		Disciplina Disciplina4 = new Disciplina("bio", 50, 50);
		disciplinas.adicionar(Disciplina4);
		
		matricularAluno(((Aluno)Aluno1), Disciplina1, 2020.1);
		matricularAluno(((Aluno)Aluno1), Disciplina2, 2020.1);
		matricularAluno(((Aluno)Aluno1), Disciplina3, 2020.1);
		matricularAluno(((Aluno)Aluno1), Disciplina4, 2020.1);
		
		ArrayList<AlunoMatriculado> testando= alunosMatriculados.getMatriculasSemestre(2020.1);
		for(AlunoMatriculado t:testando) {
			alunosMatriculados.reprovarMatricula(t);
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
		else System.out.println("Pessoa n�o existente");
	}
	
	public void matricularAluno(Disciplina disciplina, double semestre) {
		if(usuario instanceof Aluno) {
			this.matricularAluno(((Aluno) usuario), disciplina, semestre);	
		}
	}
	public void matricularAluno(Aluno aluno, Disciplina disciplina, double semestre) {
		if(disciplina.getVagas()>disciplina.getVagasPreenchidas()) {
		AlunoMatriculado matricula = new AlunoMatriculado(aluno, disciplina, semestre);
		alunosMatriculados.adicionarMatricula(matricula);	
		}
	}
	public RepoPessoas getPessoas() {
		return pessoas;
	}
	public RepoDiscplina getDiscplina() {
		return disciplinas;
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
