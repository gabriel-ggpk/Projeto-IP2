package negocios.bean;

public class Coordenacao extends Pessoa {
	private String departamento;

	public Coordenacao(String nome, String senha, String codigo, String departamento) {
		super(nome, senha,codigo);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s | Departamento: %s","Coordenação", super.toString(), this.getDepartamento());
	}
}
