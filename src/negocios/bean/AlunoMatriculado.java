package negocios.bean;

public class AlunoMatriculado {
 private Aluno aluno;
 private float[] notas;
 private int faltas;
 private Disciplina disciplina;
 private boolean cursando;
public AlunoMatriculado(Aluno aluno, Disciplina disciplina) {
	this.aluno = aluno;
	this.notas = new float[4];
	this.faltas = 0;
	this.disciplina = disciplina;
	cursando = true;
}
public Aluno getAluno() {
	return aluno;
}
public void setAluno(Aluno aluno) {
	this.aluno = aluno;
}
public float[] getNotas() {
	return notas;
}
public void setNotas(float[] notas) {
	this.notas = notas;
}
public int getFaltas() {
	return faltas;
}
public void setFaltas(int faltas) {
	this.faltas = faltas;
}
public Disciplina getDisciplina() {
	return disciplina;
}
public void setDisciplina(Disciplina disciplina) {
	this.disciplina = disciplina;
}
public boolean isCursando() {
	return cursando;
}
public void setCursando(boolean cursando) {
	this.cursando = cursando;
}


 
}
