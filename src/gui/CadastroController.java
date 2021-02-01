package gui;

import dados.RepoPessoas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {
	
    @FXML
    TextField login, nome, nomedis, vagasdis, aulasdis;

    @FXML
    PasswordField senha;

    @FXML
    private ToggleGroup tipoConta;

    @FXML
    private AnchorPane disciplina;

    @FXML
    private Button botaoCadastro;

    @FXML
    private void mostrarDisciplina(ActionEvent event) {
        RadioButton radio = (RadioButton) tipoConta.getSelectedToggle();
        if (radio.getText().equals("Professor")) {
            disciplina.setOpacity(1);
            botaoCadastro.setLayoutY(404);
        } else {
            disciplina.setOpacity(0);
            botaoCadastro.setLayoutY(284);
        }
    }

    @FXML
    public void removeLetra(KeyEvent event) {
        TextField[] entrada = new TextField[] {vagasdis, aulasdis};
        int chamada = event.getSource().toString().contains("vagasdis") ? 0 : 1;
        char input = event.getCharacter().charAt(0);
        if (Character.isAlphabetic(input) || input == ' ') {
            if (entrada[chamada].getText().length() > 0) {
                entrada[chamada].setText(entrada[chamada].getText().substring(0, entrada[chamada].getText().length() - 1));
            } else {
                entrada[chamada].setText("");
            }

            entrada[chamada].positionCaret(entrada[chamada].getText().length());
        }
    }


    @FXML
    private void cadastrar(ActionEvent event) throws IOException {
        RadioButton radio = (RadioButton) tipoConta.getSelectedToggle();
        Pessoa add;

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText("Você deve preencher todos os campos");
        alerta.setTitle("Alerta");

        if (nome.getText().isEmpty() || login.getText().isEmpty() || senha.getText().isEmpty()) {
            alerta.showAndWait();
        } else if (radio.getText().equals("Professor") &&
                (nomedis.getText().isEmpty() || vagasdis.getText().isEmpty() || aulasdis.getText().isEmpty())) {
            alerta.showAndWait();
        } else {
            if (radio.getText().equals("Aluno")) {
                add = new Aluno(nome.getText(), senha.getText(), login.getText());
            } else {
                add = new Professor(nome.getText(), senha.getText(), login.getText(),
                        new Disciplina(nomedis.getText(),
                                Integer.parseInt(aulasdis.getText()),
                                Integer.parseInt(vagasdis.getText())));
            }

            Gerenciamento.getInstMain().cadastrarPessoa(add);
            ScreenManager.getInstance().showLoginScreen();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    }
}
