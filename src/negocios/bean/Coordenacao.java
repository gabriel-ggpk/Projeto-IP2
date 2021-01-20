package negocios.bean;

public class Coordenacao extends Pessoa {
	private String departamento;

	public Coordenacao(String nome, String senha, String departamento) {
		super(nome, senha);
		this.departamento = departamento;
	}
	
	
}
