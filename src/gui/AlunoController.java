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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocios.bean.Pessoa;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class AlunoController implements Initializable {
	ArrayList<AlunoMatriculado> disciplinas;
	ObservableList<AlunoMatriculado> disciplinasObs;
	ObservableList<Double> periodoObs;
	ArrayList<Double> periodoList;
	private Pessoa usuario;
	
	@FXML
    private	Label nomeAluno;
	@FXML
    private ListView<AlunoMatriculado> cb;
	@FXML
	private ComboBox<Double> periodo;
	@FXML
    private Button logOut;
	@FXML
    private Button att;
	@FXML
	private TextField matriculatxt;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		settings();
	}
	public void settings() {
		nomeAluno.setText(Gerenciamento.getInstMain().getUsuario().getNome());
		usuario = Gerenciamento.getInstMain().getUsuario();
		disciplinas = Gerenciamento.getInstMain().getAlunoMatriculado().getMatriculasAlunoCursando((Aluno)usuario);
		periodoList = Gerenciamento.getInstMain().getAlunoMatriculado().getPeriodosAluno((Aluno)usuario);
		setCbMatriculas();
		setCbPeriodos();
		
	}
	public void mudarCenaDisciplina() throws InterruptedException {
		disciplinas = Gerenciamento.getInstMain().getAlunoMatriculado().getMatriculasCursando();
		   setCbMatriculas(); 
		try {
			   
	           FXMLLoader loader=new FXMLLoader(getClass().getResource("/gui/DisciplinaView.fxml"));
	           Parent root = (Parent) loader.load();
	           DisciplinaViewController Controller=loader.getController();
	          
	           Controller.disciplinaEspecifica(cb.getSelectionModel().selectedItemProperty().getValue());
	          
	            Stage stage=new Stage();
	            stage.setScene(new Scene(root));
	            stage.show();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	private void setCbMatriculas() {
		disciplinasObs = FXCollections.observableArrayList(disciplinas);
		cb.setItems(disciplinasObs);
	}
	private void setCbPeriodos() {
		periodoObs = FXCollections.observableArrayList(periodoList);
		periodo.setItems(periodoObs);	
	}
	public void logOut() {
		Gerenciamento.getInstMain().logOut();
		ScreenManager.getInstance().showLoginScreen();
		
	}
	public void buscarHistorico() {
    	try {
	           FXMLLoader loader=new FXMLLoader(getClass().getResource("/gui/Historico.fxml"));
	           Parent root = (Parent) loader.load();
	           HistoricoController Controller=loader.getController();
	          Controller.periodoEspecifico(Gerenciamento.getInstMain().getAlunoMatriculado().getMatriculasAluno((Aluno)usuario, periodo.getSelectionModel().selectedItemProperty().getValue()));
	            Stage stage=new Stage();
	            stage.setScene(new Scene(root));
	            stage.show();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public void matricular() {
		Disciplina disciplina = new Disciplina(matriculatxt.getText(), 50, 50);
		Gerenciamento.getInstMain().matricularAluno(disciplina, 2020.2);
	}
}
