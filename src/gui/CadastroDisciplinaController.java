package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import negocios.Gerenciamento;
import negocios.bean.Disciplina;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CadastroDisciplinaController extends Cadastro implements Initializable {
    
    private Map<TextField, String> camposDisciplina = new LinkedHashMap<>();

    @FXML
    TextField vagas, nome, aulas;

    @FXML
    private void getSource(MouseEvent event) {
        if (event.getSource() instanceof TextField) tiraBorda((TextField) event.getSource());
    }

    @FXML
    private void chamaRemover(KeyEvent event) {
        if (event.getSource() instanceof TextField) removeLetra((TextField) event.getSource());
    }

    @FXML
    private void validar(ActionEvent event) throws IOException {
        for (Map.Entry<TextField, String> campo: camposDisciplina.entrySet()) {
            if (campo.getKey().getText().isEmpty()) {
                colocarBorda(campo.getKey());
                criarAlerta(String.format("%s da disciplina precisa ser preenchido", campo.getValue()));
                return;
            }
        }

        criarDisciplina();
    }

    private void criarDisciplina() {
        Disciplina novaDisciplina = new Disciplina(nome.getText(), Integer.parseInt(vagas.getText()), Integer.parseInt(aulas.getText()));

        if(Gerenciamento.getInstMain().getDiscplina().disciplinaExiste(novaDisciplina)) {
            Gerenciamento.getInstMain().getDiscplina().adicionar(novaDisciplina);
            limparDados(camposDisciplina);
        } 
        else {
            criarAlerta("Essa disciplina já existente!");
            colocarBorda(nome);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        camposDisciplina.put(nome, "Nome");
        camposDisciplina.put(vagas, "Vagas");
        camposDisciplina.put(aulas, "Total de aulas");
    }
}
