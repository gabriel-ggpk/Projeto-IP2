package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import negocios.bean.AlunoMatriculado;

public class ProfessorEditController implements Initializable{
	
	AlunoMatriculado alunoSelecionado = null;
	ObservableList<String> provas = FXCollections.observableArrayList();
	
	@FXML
	private Label aluno;
	
	@FXML
	private ChoiceBox<String> qualProva;
	
	@FXML
	private Label erro;
	
	@FXML
	private TextField escreverNota;
	
	@FXML
	private void darNota(ActionEvent event) {
		String strNota = escreverNota.getText();
		String strProva = qualProva.getSelectionModel().getSelectedItem();
		int intProva = 0;
		double doubNota = -1;
		try {
			intProva = Integer.parseInt(strProva);
			doubNota = Double.parseDouble(strNota);
			erro.setText("");
		}
		catch (Exception ex) {
			erro.setText("Valor Invalido");
		}
		finally {
			if(doubNota >= 0 && doubNota <= 10) {
				alunoSelecionado.adicionarNota(doubNota, intProva);
				aluno.setText(alunoSelecionado.toString());
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
	
	public void settings() {
		provas.addAll("1", "2", "3", "4");
		qualProva.setItems(provas);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		settings();
	}

}