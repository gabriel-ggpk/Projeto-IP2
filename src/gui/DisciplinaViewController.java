package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import main.Main;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class DisciplinaViewController implements Initializable {
	 @FXML
	    private Label lblName;
	    @FXML
	    private Label lblSem;
	    @FXML
	    private Label lblFaltas;
	    @FXML
	    private Label lblVagas;
	    @FXML
	    private Label lblAulas;
	    @FXML
	    private Label lblNota1;
	    @FXML
	    private Label lblNota2;
	    @FXML
	    private Label lblNota3;
	    @FXML
	    private Label lblNota4;
	    @FXML
	    private Button btnDesistir;
	    private ArrayList<Label> notas;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		notas = new ArrayList<>();
		notas.add(lblNota1);
		notas.add(lblNota2);
		notas.add(lblNota3);
		notas.add(lblNota4);
		
	}
	public void disciplinaEspecifica(AlunoMatriculado aluno) {
		lblName.setText(aluno.getDisciplina().getNome());
		lblAulas.setText(String.valueOf(aluno.getDisciplina().getAulasTotais()));
		lblFaltas.setText(String.valueOf(aluno.getFaltas()));
		lblSem.setText(String.valueOf(aluno.getSemestre()));
		lblVagas.setText(String.valueOf(aluno.getDisciplina().getVagas()));
		for(int x = 0;x<4;x++) {
			notas.get(x).setText(String.valueOf(aluno.getNotas()[x]));
		}
		
		
	}
	public void desistir() {
		
	}

}
