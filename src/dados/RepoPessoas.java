package dados;

import java.util.ArrayList;
import negocios.bean.Pessoa;

public class RepoPessoas {
	private ArrayList<Pessoa> pessoas;
	public RepoPessoas() {
	}
	public void adicionarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	public void removerPessoa(Pessoa pessoa) {
		pessoas.remove(pessoa);
	}
	
}
