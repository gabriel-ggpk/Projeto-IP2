package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import negocios.Gerenciamento;
import negocios.bean.Aluno;

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
    }

    @FXML
    private void logar(ActionEvent event) throws IOException {
    	if(Gerenciamento.getInstMain().logIn(login.getText(),senha.getText()) && Gerenciamento.getInstMain().getUsuario() instanceof Aluno ) {
    		ScreenManager.getInstance().showAlunoScreen();
    	}
  
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	}
}
