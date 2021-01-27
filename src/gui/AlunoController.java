package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import main.Main;

public class AlunoController implements Initializable {
	public Main m;
	@FXML
	Label nomeAluno;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		m = new Main();
		nomeAluno.setText(Main.getGer().getUsuario().getNome());
		
	}

}
