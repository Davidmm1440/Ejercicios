package ceu.dam.ad.tema3.ejercicios.ejercicio06.modelo;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "PedidoLineaEj6")
@Table(name = "pedidos_lineas2")
public class PedidoLinea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLinea;
	
	@Column(name = "numero_linea")
	private Integer numLinea;
	
	private String articulo;
	private BigDecimal precio;
	

}
