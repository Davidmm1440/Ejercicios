package ejercicios.ejercicio03.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Pago {
	private Integer id;
	private BigDecimal cantidad;
	private LocalDate fecha;
	
	
}
