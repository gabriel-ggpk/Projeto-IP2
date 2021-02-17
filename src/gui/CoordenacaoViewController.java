package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.Disciplina;
import negocios.bean.Professor;

public class CoordenacaoViewController implements Initializable{
	
	Professor professorSelecionado = null;
	ArrayList<Disciplina> materia;
	ObservableList<Disciplina> materiaOL;
	
	@FXML
    private Label label;

    @FXML
    private Button botao;
    
    @FXML
	private ComboBox<Disciplina> disciplinaBox;
    
    @FXML
    void apertarBotao(ActionEvent event) {
    	Gerenciamento.getInstMain().getPessoas().remover(professorSelecionado);
    	Stage stage = (Stage) botao.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    void liberarProfessor(ActionEvent event) {
    	professorSelecionado.setDisciplina(null);
    	label.setText(professorSelecionado.toString());
    }
    
    @FXML
    void selecionarMateria(ActionEvent event) {
    	if(disciplinaBox.getSelectionModel().getSelectedItem() != null) {
    		professorSelecionado.setDisciplina(disciplinaBox.getSelectionModel().getSelectedItem());
    		label.setText(professorSelecionado.toString());
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		materia = Gerenciamento.getInstMain().getDiscplina().getLista();;
		materiaOL = FXCollections.observableArrayList(materia);
		disciplinaBox.setItems(materiaOL);
	}
	
	public void professorEspesifico(Professor professor) {
		professorSelecionado = professor;
		label.setText(professorSelecionado.toString());
	}
	
	protected void criarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Alerta");
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }


}
