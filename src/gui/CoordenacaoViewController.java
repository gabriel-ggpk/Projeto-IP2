package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import negocios.Gerenciamento;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Professor;

public class CoordenacaoViewController implements Initializable{

	@FXML
    private Label label;

    @FXML
    private Button botao;
    
    Professor professorSelecionado = null;
    
    @FXML
    void apertarBotao(ActionEvent event) {
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public void professorEspesifico(Professor professor) {
		professorSelecionado = professor;
		label.setText("Professor: " + professorSelecionado.getNome());
	}
	
	


}
