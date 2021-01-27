package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private ToggleGroup tipoConta;

    @FXML
    private void cadastrar(ActionEvent event) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        RadioButton radio = (RadioButton) tipoConta.getSelectedToggle();
        alerta.setTitle("Alerta");
        alerta.setHeaderText(null);
        alerta.setContentText("Login: " + login.getText() + " | Senha: " + senha.getText() + " | Tipo: " + radio.getText());
        alerta.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    }
}
