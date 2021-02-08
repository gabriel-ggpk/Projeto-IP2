package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import negocios.bean.AlunoMatriculado;

public class CoordenacaoViewController implements Initializable{

	@FXML
    private ListView<AlunoMatriculado> alunos;
	
	@FXML
    private ListView<AlunoMatriculado> professor;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
