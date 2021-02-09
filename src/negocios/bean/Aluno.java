package negocios.bean;

public class Aluno extends Pessoa {
	public Aluno (String nome, String senha, String codigo) {
		super(nome, senha, codigo);
	}
	
	public String getNome() {
		return super.getNome();
	}
	public String getCodigo() {
		return super.getCodigo();
	}

	@Override
	public String toString() {
		return String.format("%s%n%s","Aluno", super.toString());
	}
}
