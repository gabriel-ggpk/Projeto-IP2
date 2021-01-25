package negocios.bean;

public class Disciplina {

	private String nome;
	private int aulasTotais,vagas;
	
	public Disciplina(String nome, int aulasTotais, int vagas) {
		this.nome = nome;
		this.setAulasTotais(aulasTotais);
		this.setVagas(vagas);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAulasTotais() {
		return this.aulasTotais;
	}

	public void setAulasTotais(int aulasTotais) {
		this.aulasTotais = Math.max(0, aulasTotais);
	}

	public int getVagas() {
		return this.vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = Math.max(0, vagas);
	}

}
