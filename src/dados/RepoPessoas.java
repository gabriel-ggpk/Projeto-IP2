package dados;

import java.util.ArrayList;
import negocios.bean.Pessoa;

public class RepoPessoas implements RepositorioPessoas {
	private ArrayList<Pessoa> pessoas;
	public RepoPessoas() {
	}
	public void adicionar(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	public void remover(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}
	public Pessoa procurar(String nome) {
		for(Pessoa p:pessoas) {
			if(p.getNome().equals(nome)) return p;
		}
		System.out.println("Pessoa inexistente");
		return null;
		
	}
	
}
