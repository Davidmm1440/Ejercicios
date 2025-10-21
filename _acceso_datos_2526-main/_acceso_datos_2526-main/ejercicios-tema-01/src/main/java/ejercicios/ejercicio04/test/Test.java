package ejercicios.ejercicio04.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import ejercicios.ejercicio04.modelo.Pedido;
import ejercicios.ejercicio04.modelo.PedidoLinea;
import ejercicios.ejercicio04.services.PedidoException;
import ejercicios.ejercicio04.services.PedidosService;

public class Test {

	public static void main(String[] args) {
		Pedido pedido = new Pedido();
		pedido.setFechaPedido(LocalDate.now());
		pedido.setFechaEntrega(LocalDate.of(2024, 12, 1));
		pedido.setCliente("Lucas Cangrejo");
		pedido.setLineas(new ArrayList<PedidoLinea>());
		
		for (int j = 1; j <= 3; j++) {
			PedidoLinea linea = new PedidoLinea();
			linea.setArticulo("Artículo " + j);
			linea.setPrecio(new BigDecimal(938));
			pedido.getLineas().add(linea);
//			if (j == 3) { // para probar si hay error que no guarde nada
//				linea.setArticulo("fñalsdkfjñalsdjfñlasdjfñlasdjfñlasjdfñlasjdflñkjasdñlfjaslñdfjasñldfjañlsdjfñalsdjkfñlaksjdfñlkasjdflñkasjdfñlkasj");
//			}
		}
		
		PedidosService service = new PedidosService();
		try {
			service.registrarPedido(pedido);
		} catch (PedidoException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
