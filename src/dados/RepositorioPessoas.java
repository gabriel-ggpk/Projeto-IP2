package dados;

import negocios.bean.Pessoa;

public interface RepositorioPessoas {
	void adicionar(Pessoa pessoa);
	void remover(Pessoa pessoa);
	Pessoa procurar(String nome);
}
