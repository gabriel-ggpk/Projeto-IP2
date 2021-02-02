package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocios.bean.AlunoMatriculado;

public class ProfessorEditController implements Initializable{
	
	AlunoMatriculado alunoSelecionado = null;
	
	@FXML
	private Label aluno;
	
	@FXML
	private Label erro;
	
	@FXML
	private TextField escreverNota;
	
	@FXML
	private void darNota(ActionEvent event) {
		String strNota = escreverNota.getText();
		double doubNota = -1;
		try {
			doubNota = Double.parseDouble(strNota);
			erro.setText("");
		}
		catch (Exception ex) {
			erro.setText("Valor Invalido");
		}
		finally {
			if(doubNota >= 0 && doubNota <= 10) {
				
			}
			else {
				erro.setText("Valor Invalido");
			}
			escreverNota.clear();
		}
	}
	
	@FXML
	private void darFalta(ActionEvent event) {
		alunoSelecionado.darFalta();
		aluno.setText(alunoSelecionado.toString());
	}
	
	@FXML
	private void tirarFalta(ActionEvent event) {
		alunoSelecionado.tirarFalta();
		aluno.setText(alunoSelecionado.toString());
	}
	
	public void alunoEspecifico(AlunoMatriculado matricula) {
		alunoSelecionado = matricula;
		aluno.setText(alunoSelecionado.toString());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}