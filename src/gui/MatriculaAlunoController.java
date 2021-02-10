package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.sun.javafx.tk.quantum.OverlayWarning;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.ContextMenuEvent;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.AlunoMatriculado;
import negocios.bean.Disciplina;

public class MatriculaAlunoController implements Initializable {
	private Aluno aluno;
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	private ObservableList<Disciplina> disciplinasObs;
    @FXML
    private Label periodo;

    @FXML
    private Label disciplina;

    @FXML
    private Label faltas;

    @FXML
    private Label aulasTotais;

    @FXML
    private ListView<Disciplina> lv;

    @FXML
    private Label vagas;

    @FXML
    void set() {
    	Disciplina selected = lv.getSelectionModel().getSelectedItem();
		disciplina.setText(selected.getNome());
		vagas.setText(String.valueOf(selected.getVagas())+"/"+String.valueOf(selected.getVagasPreenchidas()));
		aulasTotais.setText(String.valueOf(selected.getAulasTotais()));
    }
    @FXML
    boolean matricular() {
    Disciplina selected = lv.getSelectionModel().getSelectedItem();
    for(AlunoMatriculado m:Gerenciamento.getInstMain().getAlunoMatriculado().getMatriculasAlunoCursando(aluno)) {
    	lv.getSelectionModel().clearSelection();
    	if(m.getDisciplina().equals(selected)) {
		alert("você já esta matriculado nesta disciplina");
		return false;
		}
    	if(m.getDisciplina().getVagas()<=m.getDisciplina().getVagasPreenchidas()) {
    		alert("Não há mais vagas para esta turma");
    		return false;
    	}
    }
    Gerenciamento.getInstMain().matricularAluno(aluno, selected, Gerenciamento.getInstMain().getSemestres().getSemestreAtual());
    return true;
    }
    void alert(String alert) {
    	Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText(null);
		alerta.setContentText(alert);
		alerta.showAndWait();
    }
    void pegarAluno(Aluno aluno) {
    	this.aluno = aluno;
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		disciplinas = Gerenciamento.getInstMain().getDiscplina().getLista();
		disciplinasObs = FXCollections.observableArrayList(disciplinas);
		lv.setItems(disciplinasObs);
		
	}

}
