package ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos_lineas")
@IdClass(PedidoLineaKey.class)
public class PedidoLinea {

	@Id
	private Long idPedido;
	
	@Id
	private Integer numeroLinea;
	private String articulo;
	private BigDecimal precio;
	

}
