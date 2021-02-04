package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;



public class CoordenacaoController implements Initializable{

	@FXML
    private ComboBox<Disciplina> comboBox;
	
	ArrayList<Disciplina> materia;
	ObservableList<Disciplina> materiaOL;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		settings();
	}
	
	public void settings() {
		
		ArrayList<Disciplina> usuario = Gerenciamento.getInstMain().getDiscplina().getLista();
		materia = usuario;
		
		materiaOL = FXCollections.observableArrayList(materia);
		comboBox.setItems(materiaOL);
	}	
	
	public void mudarCena() throws InterruptedException {
		settings();
		try {
			   
	           FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfessorController.fxml"));
	           Parent root = (Parent) loader.load();
	           ProfessorController Controller = loader.getController();
	          
	           //Controller.disciplinaEspecifica(comboBox.getSelectionModel().selectedItemProperty().getValue());
	          
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	

}
