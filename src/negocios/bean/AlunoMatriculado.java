package negocios.bean;

public class AlunoMatriculado {
	private Aluno aluno;
	private Disciplina disciplina;
	private double semestre;
	private double[] notas;
	private int faltas;
	private int cursando;
	
	public AlunoMatriculado(Aluno aluno, Disciplina disciplina, double semestre) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.notas = new double[4];
		this.faltas = 0;
		cursando = 0;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public double getSemestre() {
		return semestre;
	}
	public double[] getNotas() {
		return notas;
	}
	public int getFaltas() {
		return faltas;
	}
	public int getCursando() {
		return cursando;
	}
	
	public void adicionarNota(double nota, int numeroProva) {
		this.notas[numeroProva - 1] = nota;
	}
	
	public void darFalta() {
		this.faltas++;
	}
	public void tirarFalta() {
		if(faltas > 0) {
			this.faltas--;
		}
	}
	
	public String isCursando() {
		if(cursando == 0) {
			return "Cursando";
		}
		if(cursando == 1) {
			return "Aprovado";
		}
		if(cursando == -1) {
			return "Reprovado";
		}
		else {
			return "Erro";
		}
	}
	public void setCursando(int status) {
		this.cursando = status;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoMatriculado other = (AlunoMatriculado) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (Double.doubleToLongBits(semestre) != Double.doubleToLongBits(other.semestre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String notasString = "[";
		for (int i = 0; i < this.getNotas().length; i++) {
			notasString += this.getNotas()[i];
			if(i < this.getNotas().length - 1)
				notasString += ", ";
		}
		notasString += "]";

		return String.format("Aluno: " + this.getAluno().getNome() + " Disciplina: " + this.getDisciplina() + " Semestre: " + this.getSemestre() +
				"\nNotas: " + notasString + " Faltas: " + this.getFaltas() + " Status: " + this.isCursando());
	 }

}
