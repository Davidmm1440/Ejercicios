package ej002.model;

import java.math.BigDecimal;

import lombok.Data;

@Data

public class LineaPedido {
	
	private Integer idPedido;
	private Integer numeroLinea;
	private String articulo;
	private BigDecimal precio;
	

	public LineaPedido() {
		this.numeroLinea = 0;
	}

}
