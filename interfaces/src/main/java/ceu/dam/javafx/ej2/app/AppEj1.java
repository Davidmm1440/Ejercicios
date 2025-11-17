package ceu.dam.javafx.ej2.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEj1 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(AppEj1.class.getResource("/ceu/dam/javafx/ej2/gui/ej1.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 640, 480);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	public static void main(String[] args) {
		launch();
	}

}
