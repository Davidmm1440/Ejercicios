package ceu.dam.ad.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PostreRequestDto {

	private String sabor;
	private BigDecimal precio;
	private String nombre;
	private Boolean gluten;

}
