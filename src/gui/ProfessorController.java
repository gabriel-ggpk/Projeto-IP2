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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Professor; 	

public class ProfessorController implements Initializable {
	
	Professor profAtual;
	AlunoMatriculado aluno = null;
	ObservableList<AlunoMatriculado> alunosMatriculadosOL = FXCollections.observableArrayList();
	ObservableList<Aluno> listaAlunosOL = FXCollections.observableArrayList();
	ObservableList<Double> semestreOL = FXCollections.observableArrayList();
	
	@FXML
	private Label nomeProfessor;
	
	@FXML
	private Label materia;
	
	@FXML
	private ListView<AlunoMatriculado> caixa;
	
	@FXML
	private ChoiceBox<Aluno> listaAlunos;
	
	@FXML
	private ComboBox<Double> periodo;
	
	@FXML
	private void sair(ActionEvent event) {
		Gerenciamento.getInstMain().logOut();
		ScreenManager.getInstance().showLoginScreen();
	}

	@FXML
	private void clicarAluno() {
		aluno = caixa.getSelectionModel().getSelectedItem();
		cenaAluno(aluno);
		caixa.getSelectionModel().select(null);
		aluno = null;
	}
	
	@FXML
	private void cadastrarAluno(ActionEvent event) {
		Aluno addAluno = listaAlunos.getSelectionModel().getSelectedItem();
		Gerenciamento.getInstMain().matricularAluno(addAluno, profAtual.getDisciplina(), 2020.2);
		alunosMatriculadosOL.clear();
		listaAlunosOL.clear();
		pegarAlunosMatriculados();
	}
	
	@FXML
	private void escolherSemestre(ActionEvent event) {
		listaAlunosOL.clear();
		alunosMatriculadosOL.clear();
		pegarAlunosMatriculados();
		listaAlunos.setItems(listaAlunosOL);
		caixa.setItems(alunosMatriculadosOL);
	}
	
	public void atualizar() {
		listaAlunosOL.clear();
		alunosMatriculadosOL.clear();
		
		pegarAlunosMatriculados();
		listaAlunos.setItems(listaAlunosOL);
		caixa.setItems(alunosMatriculadosOL);
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
		
		semestreOL.addAll(Gerenciamento.getInstMain().getSemestres().getSemestres());
		periodo.setItems(semestreOL);
		periodo.getSelectionModel().selectLast();
		
		pegarAlunosMatriculados();
		listaAlunos.setItems(listaAlunosOL);
		caixa.setItems(alunosMatriculadosOL);
		
		nomeProfessor.setText("Professor: " + Gerenciamento.getInstMain().getUsuario().getNome());
		materia.setText("Disciplina: " + profAtual.getDisciplina().getNome());
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		settings();
	}
	
    public void pegarAlunosMatriculados() {
    	ArrayList<Aluno> alunoDisipl = Gerenciamento.getInstMain().getPessoas().getAlunos();
    	alunoDisipl.removeAll(Gerenciamento.getInstMain().getAlunoMatriculado().getAlunosDisciplina(profAtual.getDisciplina()));
    	listaAlunosOL.addAll(alunoDisipl);
    	
		alunosMatriculadosOL.addAll(Gerenciamento.getInstMain().getAlunoMatriculado().getMatriculas(profAtual.getDisciplina(), periodo.getSelectionModel().getSelectedItem()));
    	
	}
}
