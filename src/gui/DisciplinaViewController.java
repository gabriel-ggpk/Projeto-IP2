package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import negocios.bean.Disciplina;

public class DisciplinaViewController implements Initializable {
	@FXML
	Label lblTest;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void disciplinaEspecifica(String string) {
		lblTest.setText(string);
	}

}