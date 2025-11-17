package ceu.dam.javafx.ej1.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HolaMundoController {
	@FXML
	private Label labelHolaMundo;
	
	@FXML
	public void pulsa(ActionEvent event) {
		System.out.println("Bien pulsao maquina");
	}
	

	
	@FXML
	public void cabiaLabel(ActionEvent event) {
		labelHolaMundo.setText("Buenas tarde");
	}
}
