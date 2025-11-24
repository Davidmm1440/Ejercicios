package ceu.dam.javafx.ej2.gui;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ComboBoxController extends AppController{

	@FXML
	private ComboBox<String> miCombo;
	
	@FXML
	private TextField miTextField;
	
	@FXML
	private Button btnLimpiar;
	
	@FXML
	private Button btnImprimir;
	
	@FXML
	public void initialize() {
	    miCombo.getItems().addAll(
	            "David",
	            "Paula",
	            "Juanma"
	    );
	    
	}
	
	
	@FXML
	public void imprimirCombo() {
		String seleccion = miCombo.getValue();
		miTextField.setText(seleccion);
	}
	
	@FXML
	public void limpiar() {
		miTextField.clear();
		miCombo.getSelectionModel().clearSelection();
	}
	
	
}
