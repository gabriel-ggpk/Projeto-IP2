package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocios.Gerenciamento;

public class Main extends Application {
	
	private static Stage stg;
	private static Gerenciamento ger;
	
	@Override
    public void start(Stage stageInicial) throws Exception {
		stg = stageInicial;
		stageInicial.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));

        stageInicial.setScene(new Scene(root));
        stageInicial.setTitle("Teste");
        stageInicial.show();
    }
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public Gerenciamento getGer() { return ger; }

	public static void main(String[] args) {
		ger = Gerenciamento.getInstMain();
		launch(args);
	}

}
