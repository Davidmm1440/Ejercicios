package ceu.dam.ad.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postre {

	private Long id;
	private String sabor;
	private BigDecimal precio;
	private String nombre;
	private Boolean gluten;
	
}
