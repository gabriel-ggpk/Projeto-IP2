package gui;

import exceptions.LoginJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import negocios.bean.Professor;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CadastroProfessorController extends Cadastro implements Initializable {

    private Map<TextField, String> camposProfessor = new LinkedHashMap<>();

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
        for (Map.Entry<TextField, String> campo: camposProfessor.entrySet()) {
            if (campo.getKey().getText().isEmpty()) {
                colocarBorda(campo.getKey());
                criarAlerta(String.format("%s do professor precisa ser preenchido", campo.getValue()));
                return;
            }
        }

        criarProfessor();
    }
    
    private void criarProfessor() {
        Professor novoProfessor = new Professor(nome.getText(), senha.getText(), login.getText(), null);

        try {
            cadastrar(novoProfessor);
            voltarTela();
        } catch(LoginJaExisteException err) {
            criarAlerta("Login já existente!");
            colocarBorda(login);
        }
    }

    @FXML
    private void voltarTela() {
        ScreenManager.getInstance().showLoginScreen(); // Mudar pra onde vai a tela
        limparDados(camposProfessor);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	camposProfessor.put(nome, "Nome");
    	camposProfessor.put(login, "Login");
    	camposProfessor.put(senha, "Senha");
    }
}
