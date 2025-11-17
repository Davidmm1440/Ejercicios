package ceu.dam.javafx.ej2.gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Ej1Controller {

	@FXML
	private TextField tfUsuario;

	@FXML
	private TextField tfPassword;

	@FXML
	private Label labelResultado;

	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnSalir;

	@FXML
	public void login() {

		String usuario = tfUsuario.getText();
		String password = tfPassword.getText();

		String usuarioB = "test";
		String passwordB = "pass";

		if (usuario.equals(usuarioB) && password.equals(passwordB)) {
			labelResultado.setText("Login Correcto");
			labelResultado.setStyle("-fx-text-fill: green;");
		} else {
			labelResultado.setText("Login Incorrecto");
			labelResultado.setStyle("-fx-text-fill: red;");
		}

	}

	@FXML
	public void salir() {
		Platform.exit();

	}
}
