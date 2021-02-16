package gui;

import exceptions.LoginJaExisteException;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import negocios.Gerenciamento;
import negocios.bean.Pessoa;
import java.util.Map;

public class Cadastro {

    protected void criarAlerta(String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Alerta");
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    protected void colocarBorda(TextField campo) {
        campo.setStyle("-fx-border-color: #f00;");
    }

    protected void tiraBorda(TextField campo) {
        campo.setStyle("-fx-border-color: null;");
    }

    protected void removeLetra(TextField campo) {
        int ultimoIndex = campo.getText().length() - 1;
        if (ultimoIndex < 0) return;
        char input = campo.getCharacters().charAt(ultimoIndex);
        if (!Character.isDigit(input)) {
            if (campo.getText().length() > 0) {
                campo.setText(campo.getText().substring(0, campo.getText().length() - 1));
            } else {
                campo.setText("");
            }
            
            campo.positionCaret(campo.getText().length());
        }
    }

    protected void cadastrar(Pessoa pessoa) throws LoginJaExisteException{
        Gerenciamento.getInstMain().cadastrarPessoa(pessoa);
    }

    protected void limparDados(Map<TextField, String> campos) {
        for (TextField campo : campos.keySet()) {
            campo.setText("");
            tiraBorda(campo);
        }
    }
}
