package gui;

import exceptions.LoginJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import negocios.Gerenciamento;
import negocios.bean.Aluno;
import negocios.bean.Disciplina;
import negocios.bean.Pessoa;
import negocios.bean.Professor;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    private Map<TextField, String> campos = new LinkedHashMap<>();
    private Map<TextField, String> camposDisciplina = new LinkedHashMap<>();

    @FXML
    TextField login, nome, nomedis, vagasdis, aulasdis;

    @FXML
    PasswordField senha;

    @FXML
    private ToggleGroup tipoConta;

    @FXML
    private AnchorPane disciplina;

    @FXML
    private Button botaoValidar, botaoVoltar;

    private void alterarDisciplina(RadioButton radio) {
        if (radio.getText().equals("Professor")) {
            disciplina.setOpacity(1);
            botaoValidar.setLayoutY(404);botaoVoltar.setLayoutY(404);
        } else {
            disciplina.setOpacity(0);
            botaoValidar.setLayoutY(284);botaoVoltar.setLayoutY(284);
        }
    }

    @FXML
    private void getSource(MouseEvent event) {
        if (event.getSource() instanceof TextField) tiraBorda((TextField) event.getSource());
        if (event.getSource() instanceof RadioButton) alterarDisciplina((RadioButton) event.getSource());
    }

    private void tiraBorda(TextField campo) {
        campo.setStyle("-fx-border-color: null;");
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
    private void validar(ActionEvent event) throws IOException {
        RadioButton radio = (RadioButton) tipoConta.getSelectedToggle();

        for (Map.Entry<TextField, String> campo: campos.entrySet()) {
            if (campo.getKey().getText().isEmpty()) {
                colocarBorda(campo.getKey());
                criarAlerta(String.format("%s precisa ser preenchido", campo.getValue()));
                return;
            }
        }

        if (radio.getText().equals("Professor")) {
            for (Map.Entry<TextField, String> campoDisciplina: camposDisciplina.entrySet()) {
                if (campoDisciplina.getKey().getText().isEmpty()) {
                    colocarBorda(campoDisciplina.getKey());
                    criarAlerta(String.format("%s da disciplina precisa ser preenchida", campoDisciplina.getValue()));
                    return;
                }
            }
        }

        criarPessoa(radio);
    }

    @FXML
    private void showLogin() {
        ScreenManager.getInstance().showLoginScreen();
        limparDados();
    }

    private void criarPessoa(RadioButton tipo) {
        Pessoa novaPessoa;
        if (tipo.getText().equals("Aluno")) {
            novaPessoa = new Aluno(nome.getText(), senha.getText(), login.getText());
        } else {
            novaPessoa = new Professor(nome.getText(), senha.getText(), login.getText(),
                            new Disciplina(
                                nomedis.getText(),
                                Integer.parseInt(aulasdis.getText()),
                                Integer.parseInt(vagasdis.getText())
                            ));
        }

        cadastrar(novaPessoa);
    }

    private void cadastrar(Pessoa pessoa) {
        try {
            Gerenciamento.getInstMain().cadastrarPessoa(pessoa);
            showLogin();
        } catch(LoginJaExisteException err) {
            colocarBorda(login);
            criarAlerta("Login já existente");
        }
    }

    private void criarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Alerta");
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    private void colocarBorda(TextField campo) {
        campo.setStyle("-fx-border-color: #f00;");
    }

    private void limparDados() {
        for (TextField campo : campos.keySet()) {
            campo.setText("");
            tiraBorda(campo);
        }
        for (TextField campoDisciplina : camposDisciplina.keySet()) {
            campoDisciplina.setText("");
            tiraBorda(campoDisciplina);
        }

        tipoConta.selectToggle(tipoConta.getToggles().get(0));
        alterarDisciplina((RadioButton) tipoConta.getSelectedToggle());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	campos.put(nome, "Nome");
    	campos.put(login, "Login");
    	campos.put(senha, "Senha");
    	camposDisciplina.put(nomedis, "Nome");
    	camposDisciplina.put(vagasdis, "Vagas");
    	camposDisciplina.put(aulasdis, "Total de Aulas");
    }
}
