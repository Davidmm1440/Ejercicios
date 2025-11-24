package ceu.dam.javafx.ej2.app;

import ceu.dam.javafx.ej2.gui.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppEj1 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController controller = new AppController(primaryStage);
		controller.cambiarVista(FXMLPaths.LOGIN);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
