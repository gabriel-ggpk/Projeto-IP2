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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Pessoa;
import negocios.bean.Professor; 	

public class ProfessorController implements Initializable {
	
	Professor profAtual;
	AlunoMatriculado aluno = null;
	ObservableList<AlunoMatriculado> alunosMatriculadosOL = FXCollections.observableArrayList();
	ObservableList<Aluno> listaAlunosOL = FXCollections.observableArrayList();
	
	@FXML
	private Label nomeProfessor;
	
	@FXML
	private Label materia;
	
	@FXML
	private Label alunoSelecionado;
	
	@FXML
	private ListView<AlunoMatriculado> caixa;
	
	@FXML
	private ChoiceBox<Aluno> listaAlunos;
	
	@FXML
	private void sair(ActionEvent event) {
		Gerenciamento.getInstMain().logOut();
		ScreenManager.getInstance().showLoginScreen();
	}

	@FXML
	private void clicarAluno() {
		if(aluno == caixa.getSelectionModel().getSelectedItem()) {
			cenaAluno(aluno);
			caixa.getSelectionModel().select(null);
		}
		aluno = caixa.getSelectionModel().getSelectedItem();
		alunoSelecionado.setText(aluno.toString());
	}
	public void zerar() {
		alunoSelecionado.setText("");
		caixa.getSelectionModel().select(null);
		aluno = null;
	}
	
	@FXML
	private void cadastrarAluno(ActionEvent event) {
		Aluno addAluno = listaAlunos.getSelectionModel().getSelectedItem();
		Gerenciamento.getInstMain().matricularAluno(addAluno, profAtual.getDisciplina(), 2020.1);
		alunosMatriculadosOL.clear();
		listaAlunosOL.clear();
		pegarAlunosMatriculados();
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
		alunoSelecionado.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		profAtual = (Professor) Gerenciamento.getInstMain().getUsuario();
		pegarAlunosMatriculados();
		
		nomeProfessor.setText(Gerenciamento.getInstMain().getUsuario().getNome());
		materia.setText(profAtual.getDisciplina().getNome() + " | Vagas: " + alunosMatriculadosOL.size() + "/" + profAtual.getDisciplina().getVagas());
		caixa.setItems(alunosMatriculadosOL);
		listaAlunos.setItems(listaAlunosOL);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		settings();
	}
	
    public void pegarAlunosMatriculados() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();
		pessoas = Gerenciamento.getInstMain().getPessoas().getPessoas();
		Aluno teste;
		
		for(int n = 0; n < pessoas.size(); n++) {
			if(pessoas.get(n) instanceof Aluno) {
				teste = (Aluno) pessoas.get(n);
				if(teste.getMatriculas().buscarDisciplinas(profAtual.getDisciplina()).size() != 0) {
					alunosMatriculadosOL.addAll(teste.getMatriculas().buscarDisciplinas(profAtual.getDisciplina()));
				}
				else {
					listaAlunosOL.add(teste);
				}
			}
		}
	}
}
