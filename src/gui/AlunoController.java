package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import gui.DisciplinaViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.Main;
import negocios.bean.Pessoa;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
public class AlunoController implements Initializable {
	private Main m;
	@FXML
private	Label nomeAluno;
	@FXML
	Hyperlink disciplina01,disciplina02,disciplina03,disciplina04;
	@FXML
	ArrayList<Hyperlink> links;
	
	ArrayList<AlunoMatriculado> disciplinas;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { 
		m = new Main();
		nomeAluno.setText(Main.getGer().getUsuario().getNome());
		Pessoa usuario = Main.getGer().getUsuario();
		if(usuario instanceof Aluno) {
		disciplinas = ((Aluno)usuario).getMatriculas().disciplinasCursando();
		disciplina01.setText(((Aluno)usuario).getMatriculas().buscarDisciplina("mat").getDisciplina().getNome());
		setDisciplinas();
		for(int x = 0;x<4;x++) {
			links.get(x).setText(disciplinas.get(x).getDisciplina().getNome());
		}
		}
	}
	public void mudarCenaDisciplina() {
		 try {
	            FXMLLoader loader=new FXMLLoader(getClass().getResource("/gui/DisciplinaView.fxml"));
	            Parent root = (Parent) loader.load();

	           DisciplinaViewController Controller=loader.getController();
	           Controller.disciplinaEspecifica(disciplinas.get(0).getDisciplina());
	           
	            Stage stage=new Stage();
	            stage.setScene(new Scene(root));
	            stage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	public void setDisciplinas() {
		links = new ArrayList<Hyperlink>();
		links.add(disciplina01);
		links.add(disciplina02);
		links.add(disciplina03);
		links.add(disciplina04);
	}
}
