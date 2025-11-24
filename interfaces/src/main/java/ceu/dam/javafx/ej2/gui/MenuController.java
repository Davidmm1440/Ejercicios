package ceu.dam.javafx.ej2.gui;


import ceu.dam.javafx.ej2.app.FXMLPaths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class MenuController extends AppController {
	
	@FXML
	private BorderPane borderPanel;
	
	@FXML
	public void cargarPantallaComboBox(ActionEvent e) {
		Parent vista = cargarVista(FXMLPaths.COMBOBOX);
		borderPanel.setCenter(vista);
	}

	@FXML
	public void logOut(ActionEvent e) {
		cambiarVista(FXMLPaths.LOGIN);
	}
}
