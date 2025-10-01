package ej002.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import ej002.model.LineaPedido;
import ej002.model.Pedido;
import ej002.services.PedidosService;
import ej002.services.PedidosServiceException;

public class App {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2024, 12, 1));
		pedido.setCliente("Eloisa Paula");
		pedido.setListaLineaPedidos(new ArrayList<LineaPedido>());
		
		for (int j = 1; j <= 3; j++) {
			LineaPedido linea = new LineaPedido();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getListaLineaPedidos().add(linea);
		}
		
		PedidosService pS = new PedidosService();
		try {
			pS.registrarPedidos(pedido);
		} catch (PedidosServiceException e) {
			e.printStackTrace();
		}
		
	}
}
