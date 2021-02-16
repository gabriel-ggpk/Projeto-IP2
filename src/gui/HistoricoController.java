package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import negocios.bean.AlunoMatriculado;

public class HistoricoController implements Initializable {
	@FXML
    private ComboBox<AlunoMatriculado> cb;
	ArrayList<AlunoMatriculado> disciplinas;
	ObservableList<AlunoMatriculado> disciplinasObs;
    @FXML
    private Label periodo;

    @FXML
    private Label disciplina;

    @FXML
    private Label nota1;

    @FXML
    private Label nota2;

    @FXML
    private Label nota3;

    @FXML
    private Label nota4;

    @FXML
    private Label faltas;
    @FXML
    private Label statusLbl;
    @FXML
    private Label aulasTotais;
    private ArrayList<Label> notas;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		notas = new ArrayList<>();
		notas.add(nota1);
		notas.add(nota2);
		notas.add(nota3);
		notas.add(nota4);
	}
	public void set() {
		AlunoMatriculado selected = cb.getSelectionModel().getSelectedItem();
		disciplina.setText(selected.getDisciplina().getNome());
		faltas.setText(String.valueOf(selected.getFaltas()));
		aulasTotais.setText(String.valueOf(selected.getDisciplina().getAulasTotais()));
		statusLbl.setText(selected.isCursando());
		for(int x = 0;x<4;x++) {
			notas.get(x).setText(String.valueOf(selected.getNotas()[x]));
		}
    
}
	public void periodoEspecifico(ArrayList<AlunoMatriculado> aluno) {
		periodo.setText(String.valueOf(aluno.get(0).getSemestre()));
		disciplinasObs = FXCollections.observableArrayList(aluno);
		cb.setItems(disciplinasObs);
	}
}
