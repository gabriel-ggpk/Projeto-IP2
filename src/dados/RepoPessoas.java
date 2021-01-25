package dados;

import java.util.ArrayList;
import negocios.bean.Pessoa;

public class RepoPessoas implements RepositorioPessoas {
	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public RepoPessoas() {
	}
	
	public void adicionar(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	public void remover(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}
	
	public boolean logIN(String codigo, String senha) {
		boolean retorno = false;
		
		for (int n = 0; n < pessoas.size(); n++) {
			if (pessoas.get(n).getCodigo().equals(codigo)) {
				if (pessoas.get(n).getSenha().equals(senha)) {
					retorno = true;
				}
			}
		}
		
		return retorno;
	}
	
	public Pessoa procurar(String codigo) {
		for(Pessoa p:pessoas) {
			if(p.getCodigo().equals(codigo)) return p;
		}
		System.out.println("Pessoa inexistente");
		return null;	
	}
	public Pessoa procurarPorNome(String nome) {
		for(Pessoa p:pessoas) {
			if(p.getCodigo().equals(nome)) return p;
		}
		System.out.println("Pessoa inexistente");
		return null;	
	}
	

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}
	
	
}
