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

 
}
