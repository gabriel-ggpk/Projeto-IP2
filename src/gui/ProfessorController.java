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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Pessoa;
import negocios.bean.Professor; 	

public class ProfessorController implements Initializable {
	
	Professor profAtual;
	AlunoMatriculado aluno = null;
	ObservableList<AlunoMatriculado> alunos = FXCollections.observableArrayList();
	
	@FXML
	private Label nomeProfessor;
	
	@FXML
	private Label alunoSelecionado;
	
	@FXML
	private ListView<AlunoMatriculado> caixa;
	
	@FXML
	private void sair(ActionEvent event) {
		Gerenciamento.getInstMain().logOut();
		ScreenManager.getInstance().showLoginScreen();
	}

	@FXML
	private void clicarAluno() {
		aluno = caixa.getSelectionModel().getSelectedItem();
		alunoSelecionado.setText(aluno.toString());
		cenaAluno(aluno);
	}
	
	public void cenaAluno(AlunoMatriculado aluno) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/ProfessorEdit.fxml"));
			Parent root = (Parent) loader.load();
			
			ProfessorEditController control = loader.getController();
			control.alunoEspecifico(aluno);
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch(IOException e) {
				e.printStackTrace();
		}
	}
	
	public void settings() {
		profAtual = (Professor) Gerenciamento.getInstMain().getUsuario();
		pegarAlunos();
		
		nomeProfessor.setText(Gerenciamento.getInstMain().getUsuario().getNome());
		caixa.setItems(alunos);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		settings();
	}
	
    public void pegarAlunos() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas = Gerenciamento.getInstMain().getPessoas().getPessoas();
		Aluno teste;
		
		for(int n = 0; n < pessoas.size(); n++) {
			if(pessoas.get(n) instanceof Aluno) {
				teste = (Aluno) pessoas.get(n);
				alunos.addAll(teste.getMatriculas().buscarDisciplinas(profAtual.getDisciplina()));
			}
		}
	}
}
