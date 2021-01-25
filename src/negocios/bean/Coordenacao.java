package negocios.bean;

public class Coordenacao extends Pessoa {
	private String departamento;

	public Coordenacao(String nome, String senha,String codigo, String departamento) {
		super(nome, senha,codigo);
		this.departamento = departamento;
	}
	
	
}
