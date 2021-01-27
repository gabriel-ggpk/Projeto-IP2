package gui;

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

import main.Main;
import negocios.bean.Aluno;

public class LoginController implements Initializable {
	private Main m;
    @FXML
    AnchorPane cena;

    @FXML
    TextField login;

    @FXML
    PasswordField senha;

    @FXML
    private void mudarCena(ActionEvent event) throws IOException {
        m.changeScene("/gui/Cadastro.fxml");
    }

    @FXML
    private void logar(ActionEvent event) throws IOException {
    	if(Main.getGer().logIn(login.getText(),senha.getText()) && Main.getGer().getUsuario() instanceof Aluno ) {
    		m.changeScene("/gui/Aluno.fxml");
    	}
  
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {m = new Main();}
}
