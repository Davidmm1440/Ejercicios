package ceu.dam.javafx.ej2.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DatePickerController extends AppController{

	@FXML
	private DatePicker miDatePicker;
	
	@FXML
	private TextField miTextField;
	
	@FXML
	private Button btnLeer;
	
	private DateTimeFormatter formatter;
	
	@FXML
	public void imprimirFecha() {
		LocalDate fecha = miDatePicker.getValue();
		this.miTextField.setText(fecha.format(formatter));
	}
	
	@FXML
	public void initialize() {
		this.formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.miDatePicker.setValue(LocalDate.now());
	}
}

