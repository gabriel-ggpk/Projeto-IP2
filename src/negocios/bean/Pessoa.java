package negocios.bean;

public abstract class Pessoa {
	private String nome,senha;
	private String codigo;
	
	public Pessoa(String nome, String senha, String codigo) {
		this.nome =nome;
		this.senha = senha;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public String getCodigo() {
		return codigo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Nome: %s | Codigo: %s", this.getNome(), this.getCodigo());
	}
}