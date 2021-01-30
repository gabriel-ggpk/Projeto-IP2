package gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ScreenManager {

	private static ScreenManager instance;
    private Stage mainStage;
    private Scene loginScene;
    private Scene cadastroScene;
    private Scene alunoScene = null;
    
    public static ScreenManager getInstance() {
        if (instance == null) {
            instance = new ScreenManager();
        } 
        
        return instance; 
    }
    
    private ScreenManager() {
        
        
        try {
        	
            Parent loginPane = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));
            this.loginScene = new Scene(loginPane);
            Parent singUpPane = FXMLLoader.load(getClass().getResource("/gui/Cadastro.fxml"));
            this.cadastroScene = new Scene(singUpPane);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
        mainStage.setWidth(720);
        mainStage.setHeight(480);
      
        mainStage.setTitle("3GLT-sistema acadeimico");
    }
    
    public void showLoginScreen() {
        this.mainStage.setScene(this.loginScene);
        this.mainStage.show();
    }
    
    public void showCadastroScreen() {
        this.mainStage.setScene(this.cadastroScene);
        this.mainStage.show();
    }
    public void showAlunoScreen() throws IOException {
    	Parent alunoPane = FXMLLoader.load(getClass().getResource("/gui/Aluno.fxml"));
        this.alunoScene = new Scene(alunoPane);
    	this.mainStage.setScene(alunoScene);
    	this.mainStage.show();
    }
}
