
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class Main {
	public static void main(String[] args) {
		Disciplina mat = new Disciplina("Mat", 20, 15);
		Disciplina arte = new Disciplina("Artes", 20, 15);
		Disciplina bio = new Disciplina("Bio", 20, 15);
		Aluno l = new Aluno("L", "senha", "1234");
		
		/*AlunoMatriculado mat1 = new AlunoMatriculado(l, mat, 2020.2);
		AlunoMatriculado mat2 = new AlunoMatriculado(l, mat, 2020.2);
		AlunoMatriculado art1 = new AlunoMatriculado(l, arte, 2020.1);
		AlunoMatriculado art2 = new AlunoMatriculado(l, arte, 2020.2);
		AlunoMatriculado bio1 = new AlunoMatriculado(l, bio, 2020.2);*/
		
		l.adicionarMatricula(mat,2020.2);
		l.adicionarMatricula(mat,2020.2);
		l.adicionarMatricula(arte,2020.1);
		l.adicionarMatricula(arte,2020.2);
		l.adicionarMatricula(bio,2020.2);
		
		System.out.println(l.getMatriculas().getMatriculas() + "\n");
		System.out.println(l.getMatriculas().getMatriculas(2020.2) + "\n");
	}
}
