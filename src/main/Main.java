package main;

import java.io.IOException;

import gui.ScreenManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import negocios.Gerenciamento;

public class Main extends Application {
	
	private static Stage stg;
	private static Gerenciamento ger;
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		ScreenManager.getInstance().setMainStage(primaryStage);
	    ScreenManager.getInstance().showLoginScreen();
	      
	    primaryStage.show();
    }
	
	

	public static Gerenciamento getGer() { return ger; }

	public static void main(String[] args) {
		ger = Gerenciamento.getInstMain();
		launch(args);
	}

}
