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
import negocios.bean.Aluno;
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
    private ComboBox<String> comboBoxPessoa;
	
	ArrayList<String> pessoa = new ArrayList<>();
	ObservableList<String> pessoaOL;
	
	@FXML
    private ListView<Pessoa> Lista;
	
	ArrayList<Pessoa> listagem = new ArrayList<>();
	ObservableList<Pessoa> listagemOL;
	
	public void listar() {
		if(comboBoxMateria.getSelectionModel().getSelectedItem() != null && comboBoxPessoa.getSelectionModel().getSelectedItem() != null) {
			listagem.clear();
			if(comboBoxPessoa.getSelectionModel().getSelectedItem() == "Professor") {
				listagem.add(Gerenciamento.getInstMain().getDiscplina().devolverProfessor(comboBoxMateria.getSelectionModel().getSelectedItem()));
			}
			else {
				listagem.addAll(Gerenciamento.getInstMain().getDiscplina().devolverAluno(comboBoxMateria.getSelectionModel().getSelectedItem()));
			}
			listagemOL = FXCollections.observableArrayList(listagem);
			Lista.setItems(listagemOL);
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
		
		ArrayList<Disciplina> usuario = Gerenciamento.getInstMain().getDiscplina().getLista();
		materia = usuario;
		
		materiaOL = FXCollections.observableArrayList(materia);
		comboBoxMateria.setItems(materiaOL);
		
		pessoa.add("Professor");
		pessoa.add("Aluno");
		
		pessoaOL = FXCollections.observableArrayList(pessoa);
		comboBoxPessoa.setItems(pessoaOL);
	}	
	
	public void mudarCena() throws InterruptedException {
		settings();
		if(comboBoxPessoa.getValue() == "Professor") {
			
		}
		
	}
	
}