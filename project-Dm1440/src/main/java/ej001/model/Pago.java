package ej001.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Pago {
	
	private BigDecimal importe;
	private LocalDate fecha;
}
