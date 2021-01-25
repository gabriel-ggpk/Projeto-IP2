package negocios.bean;

public class AlunoMatriculado {
	private Aluno aluno;
	private Disciplina disciplina;
	private double semestre;
	private float[] notas;
	private int faltas;
	private boolean cursando;
	
	public AlunoMatriculado(Aluno aluno, Disciplina disciplina, double semestre) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.notas = new float[4];
		this.faltas = 0;
		cursando = true;
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
	public float[] getNotas() {
		return notas;
	}
	public int getFaltas() {
		return faltas;
	}
	public boolean isCursando() {
		return cursando;
	}
	public void setCursando(boolean cursando) {
		this.cursando = cursando;
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
	
	

}
