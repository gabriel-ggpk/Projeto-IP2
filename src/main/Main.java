package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage estagio1) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("teste.fxml"));
		
		estagio1.setTitle("Hello Woeld!");
		estagio1.setScene(new Scene(root, 400, 300));
		estagio1.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
