package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import negocios.Gerenciamento;
import negocios.bean.Pessoa;

public class Aluno implements Initializable {
	 private Gerenciamento ger;
	@FXML
	Label nomeAluno;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		nomeAluno.setText(ger.);
		
	}

}
