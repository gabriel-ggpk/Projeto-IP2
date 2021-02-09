package gui;

import exceptions.ContaNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.Coordenacao;
import negocios.bean.Professor;

public class LoginController implements Initializable {
	
	@FXML
    AnchorPane cena;

    @FXML
    TextField login;

    @FXML
    PasswordField senha;

    @FXML
    private void mudarCena(ActionEvent event) throws IOException {
    	ScreenManager.getInstance().showCadastroScreen();
    	limparDados();
    }

    @FXML
    private void logar(ActionEvent event) throws IOException {
    	try {
			if (Gerenciamento.getInstMain().logIn(login.getText(), senha.getText())) {
				if (Gerenciamento.getInstMain().getUsuario() instanceof Aluno) {
					ScreenManager.getInstance().showAlunoScreen();
				}
				if (Gerenciamento.getInstMain().getUsuario() instanceof Professor) {
					ScreenManager.getInstance().showProfessoeScreen();
				}
				if (Gerenciamento.getInstMain().getUsuario() instanceof Coordenacao) {
					ScreenManager.getInstance().showCoordenacaoScreen();
				}
				limparDados();
			}
		} catch(ContaNaoExisteException err) {
    		senha.setText("");
    		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    		alerta.setTitle("Alerta");
			alerta.setHeaderText(null);
    		alerta.setContentText("Usuário não existe");
    		alerta.showAndWait();
    	}
    }

    private void limparDados() {
		login.setText("");
		senha.setText("");
	}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
