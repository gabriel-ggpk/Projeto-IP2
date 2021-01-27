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

public class Teste implements Initializable {

    @FXML
    AnchorPane cena;

    @FXML
    TextField login;

    @FXML
    PasswordField senha;

    @FXML
    private void cadastrar(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText("Login: " + login.getText() + " | Senha: " + senha.getText());
        alerta.showAndWait();
    }

    @FXML
    private void mudarCena(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("/gui/Cadastro.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
