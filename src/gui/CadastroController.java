package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import negocios.bean.Aluno;
import negocios.bean.Pessoa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    TextField login;

    @FXML
    PasswordField senha;

    @FXML
    private void cadastrar(ActionEvent event) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText("Login: " + login.getText() + " | Senha: " + senha.getText());
        alerta.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
