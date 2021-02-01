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
import javafx.stage.Stage;
import negocios.bean.Pessoa;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;

public class AlunoController implements Initializable {
	@FXML
  private	Label nomeAluno;
	@FXML
    private ComboBox<AlunoMatriculado> cb;
	@FXML
    private Button logOut;
	ArrayList<AlunoMatriculado> disciplinas;
	ObservableList<AlunoMatriculado> disciplinasObs;
	private Pessoa usuario;
	@FXML
    private Button att;

    @FXML
    void buscarHistorico() {
    	/*try {
	           FXMLLoader loader=new FXMLLoader(getClass().getResource("/gui/DisciplinaView.fxml"));
	           Parent root = (Parent) loader.load();
	           DisciplinaViewController Controller=loader.getController();
	           Controller.disciplinaEspecifica(disciplinas.get(cb.getSelectionModel().getSelectedIndex()));
	          
	            Stage stage=new Stage();
	            stage.setScene(new Scene(root));
	            stage.show();
	            } catch (IOException e) {
	            e.printStackTrace();
	        }*/
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		settings();
	}
	public void settings() {
		nomeAluno.setText(Gerenciamento.getInstMain().getUsuario().getNome());
		usuario = Gerenciamento.getInstMain().getUsuario();
		disciplinas = ((Aluno)usuario).getMatriculas().disciplinasCursando();
		
		set();
		
	}
	public void mudarCenaDisciplina() throws InterruptedException {
		disciplinas = ((Aluno)usuario).getMatriculas().disciplinasCursando();
		   set(); 
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
	
	private void set() {
		disciplinasObs = FXCollections.observableArrayList(disciplinas);
		cb.setItems(disciplinasObs);
	}
	public void logOut() {
		Gerenciamento.getInstMain().logOut();
		ScreenManager.getInstance().showLoginScreen();
		
	}
}
