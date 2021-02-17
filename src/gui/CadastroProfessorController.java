package gui;

import exceptions.LoginJaExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocios.Gerenciamento;
import negocios.bean.Professor;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CadastroProfessorController extends Cadastro implements Initializable {

    private Map<TextField, String> camposProfessor = new LinkedHashMap<>();
    ArrayList<Professor> listagemProfessor = new ArrayList<>();
	ObservableList<Professor> listagemProfessorOL;
	
    @FXML
    TextField login, nome;

    @FXML
    PasswordField senha;
    
    @FXML
    private ListView<Professor> listaProfessores;

    @FXML
    private void getSource(MouseEvent event) {
        if (event.getSource() instanceof TextField) tiraBorda((TextField) event.getSource());
    }

    @FXML
    private void validar(ActionEvent event) throws IOException {
        for (Map.Entry<TextField, String> campo: camposProfessor.entrySet()) {
            if (campo.getKey().getText().isEmpty()) {
                colocarBorda(campo.getKey());
                criarAlerta(String.format("%s do professor precisa ser preenchido", campo.getValue()));
                return;
            }
        }

        criarProfessor();
    }
    
    @FXML
    void clicarProfessor() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/CoordenacaoView.fxml"));
			Parent root = (Parent) loader.load();
			
			CoordenacaoViewController control = loader.getController();
			control.professorEspesifico(listaProfessores.getSelectionModel().getSelectedItem());
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch(IOException e) {
				e.printStackTrace();
		}
    }
    
    private void criarProfessor() {
        Professor novoProfessor = new Professor(nome.getText(), senha.getText(), login.getText(), null);

        try {
            cadastrar(novoProfessor);
            limparDados(camposProfessor);
            atualiza();
        } catch(LoginJaExisteException err) {
            criarAlerta("Login já existente!");
            colocarBorda(login);
        }
    }
    
    public void atualiza() {
    	listagemProfessor.clear();
    	listagemProfessorOL.clear();
    	listagemProfessor.addAll(Gerenciamento.getInstMain().getPessoas().getProfessor());
		listagemProfessorOL = FXCollections.observableArrayList(listagemProfessor);
		listaProfessores.setItems(listagemProfessorOL);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	camposProfessor.put(nome, "Nome");
    	camposProfessor.put(login, "Login");
    	camposProfessor.put(senha, "Senha");
    	
    	listagemProfessor.addAll(Gerenciamento.getInstMain().getPessoas().getProfessor());
		listagemProfessorOL = FXCollections.observableArrayList(listagemProfessor);
		listaProfessores.setItems(listagemProfessorOL);
    }
}
