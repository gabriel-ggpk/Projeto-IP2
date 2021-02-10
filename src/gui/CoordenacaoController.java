package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;



public class CoordenacaoController implements Initializable{

	@FXML
    private ComboBox<Disciplina> comboBoxMateria;
	
	ArrayList<Disciplina> materia;
	ObservableList<Disciplina> materiaOL;
	
	@FXML
    private ComboBox<Double> comboBoxPeriodo;
	
	ArrayList<Double> semestre = new ArrayList<>();
	ObservableList<Double> semestreOL;
	
	@FXML
    private ListView<Professor> ListaProfessor;
	
	ArrayList<Professor> listagemProfessor = new ArrayList<>();
	ObservableList<Professor> listagemProfessorOL;
	
	@FXML
    private ListView<AlunoMatriculado> ListaAluno;
	
	ArrayList<AlunoMatriculado> listagemAluno = new ArrayList<>();
	ObservableList<AlunoMatriculado> listagemAlunoOL;
	
	@FXML
    void clicarAluno() {
		listar();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfessorEdit.fxml"));
			Parent root = (Parent) loader.load();
			
			ProfessorEditController control = loader.getController();
			control.alunoEspecifico(ListaAluno.getSelectionModel().getSelectedItem());
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch(IOException e) {
				e.printStackTrace();
		}
    }
	
	public void listar() {
		if(comboBoxMateria.getSelectionModel().getSelectedItem() != null && comboBoxPeriodo.getSelectionModel().getSelectedItem() != null) {
			listagemAluno.clear();
			listagemAluno.addAll(Gerenciamento.getInstMain().getAlunoMatriculado().getMatriculas(comboBoxMateria.getSelectionModel().getSelectedItem(), comboBoxPeriodo.getSelectionModel().getSelectedItem()));
			listagemAlunoOL = FXCollections.observableArrayList(listagemAluno);
			ListaAluno.setItems(listagemAlunoOL);
			
			listagemProfessor.clear();
			listagemProfessor.add(Gerenciamento.getInstMain().getPessoas().getProfessor(comboBoxMateria.getSelectionModel().getSelectedItem()));
			listagemProfessorOL = FXCollections.observableArrayList(listagemProfessor);
			ListaProfessor.setItems(listagemProfessorOL);
		}
	}
	
	@FXML
    void selecianar1(ActionEvent event) {
		listar();
    }

    @FXML
    void selecionar2(ActionEvent event) {
    	listar();
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		settings();
	}
	
	public void settings() {
		materia = Gerenciamento.getInstMain().getDiscplina().getLista();;
		materiaOL = FXCollections.observableArrayList(materia);
		comboBoxMateria.setItems(materiaOL);
		
		semestre = Gerenciamento.getInstMain().getSemestres().getSemestres();
		semestreOL = FXCollections.observableArrayList(semestre);
		comboBoxPeriodo.setItems(semestreOL);
	}	
	
}
