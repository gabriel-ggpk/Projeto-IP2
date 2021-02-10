
package negocios.bean;

public class Disciplina {

	private String nome;
	private int aulasTotais,vagas,vagasPreenchidas;
	
	public Disciplina(String nome, int aulasTotais, int vagas) {
		this.nome = nome;
		this.setAulasTotais(aulasTotais);
		this.setVagas(vagas);
		this.vagasPreenchidas = 0;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVagasPreenchidas() {
		return vagasPreenchidas;
	}

	public void setVagasPreenchidas(int vagasPreenchidas) {
		this.vagasPreenchidas = vagasPreenchidas;
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
	public void preencherVaga() {
		this.vagasPreenchidas++;
	}
	public void liberarVaga() {
		this.vagasPreenchidas--;
	}

	/*@Override
	public String toString() {
		return String.format("Disciplina: (Nome: %s | Aulas Totais: %d | Vagas: %d)", this.getNome(), this.getAulasTotais(), this.getVagas());
	}*/
	@Override
	public String toString() {
		return String.format("%s", this.getNome());
	}
}
