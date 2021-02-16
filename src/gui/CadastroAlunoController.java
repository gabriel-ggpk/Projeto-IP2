package gui;

import exceptions.LoginJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import negocios.bean.Aluno;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CadastroAlunoController extends Cadastro implements Initializable {

    private Map<TextField, String> camposAluno = new LinkedHashMap<>();

    @FXML
    TextField login, nome;

    @FXML
    PasswordField senha;

    @FXML
    private void getSource(MouseEvent event) {
        if (event.getSource() instanceof TextField) tiraBorda((TextField) event.getSource());
    }

    @FXML
    private void validar(ActionEvent event) throws IOException {
        for (Map.Entry<TextField, String> campo: camposAluno.entrySet()) {
            if (campo.getKey().getText().isEmpty()) {
                colocarBorda(campo.getKey());
                criarAlerta(String.format("%s do aluno precisa ser preenchido", campo.getValue()));
                return;
            }
        }

        criarAluno();
    }

    private void criarAluno() {
        Aluno novoAluno = new Aluno(nome.getText(), senha.getText(), login.getText());

        try {
            cadastrar(novoAluno);
            showLogin();
        } catch (LoginJaExisteException err) {
            criarAlerta("Login já existente");
        }
    }

    @FXML
    private void showLogin() {
        ScreenManager.getInstance().showLoginScreen();
        limparDados(camposAluno);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        camposAluno.put(nome, "Nome");
        camposAluno.put(login, "Login");
        camposAluno.put(senha, "Senha");
    }
}
