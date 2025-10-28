package ceu.dam.ad.tema3.ejercicios.ejercicio06.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "PedidoEj6")
@Table(name = "pedidos2")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedido;
	
	
	private LocalDate fechaPedido;
	private LocalDate fechaEntrega;
	private String cliente;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido", nullable = false)
	private List<PedidoLinea> lineas;
	
	

}
