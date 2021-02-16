package main;

import gui.ScreenManager;
import javafx.application.Application;
import javafx.stage.Stage;
import negocios.Gerenciamento;

class Tread extends Thread {

    public void run() {
       Gerenciamento.getInstMain().salvar();
       System.out.println("Bye.");
       
    }
 }

public class Main extends Application {
	/*
	LOGIN E SENHA DOS TESTES:
	ALUNO: login: 123 senha: 123
	PROFESSOR: login 000 senha: 000 
	*/
	private static Stage stg;
	private static Gerenciamento ger;
	
	@Override
    public void start(Stage primaryStage) throws Exception {
		ScreenManager.getInstance().setMainStage(primaryStage);
	    ScreenManager.getInstance().showLoginScreen();
	      
	    primaryStage.show();
	
	    Runtime.getRuntime().addShutdownHook(new Tread());
    }

	public static Gerenciamento getGer() { 
		return ger; 
	}

	public static void main(String[] args) {
		ger = Gerenciamento.getInstMain();
		launch(args);
	}

	public static Stage getStg() {
		return stg;
	}
	
	
}
