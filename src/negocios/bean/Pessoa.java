package negocios.bean;

public abstract class Pessoa {
	private String nome,senha;
	public Pessoa(String nome,String senha) {
		this.nome =nome;
		this.senha = senha;
	}
}
