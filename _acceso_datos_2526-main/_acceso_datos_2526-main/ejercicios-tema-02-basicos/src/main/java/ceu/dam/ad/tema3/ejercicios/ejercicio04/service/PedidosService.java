package ceu.dam.ad.tema3.ejercicios.ejercicio04.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.Pedido;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.PedidoLinea;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.repository.PedidoLineaRepository;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.repository.PedidosRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidosService {

	@Autowired
	private PedidosRepository repoP;

	@Autowired
	private PedidoLineaRepository repoPL;

	private static final Logger log = LoggerFactory.getLogger(PedidosService.class);

	public Pedido consultarPedido(Long idPedido) throws PedidoNotFoundException, PedidoException {

		try {
			Optional<Pedido> p = repoP.findById(idPedido);
			if (p.isEmpty()) {
				log.warn("No se ha encontrado el pedido con id " + idPedido);
				throw new PedidoNotFoundException("No existe pedido con id " + idPedido);
			}
			p.get().setLineas(repoPL.findAllByIdPedido(idPedido));
			return p.get();
		} catch (DataAccessException e) {
			throw new PedidoException("Error al registrar pedido", e);
		}

	}

	@Transactional
	public Long crearPedido(Pedido pedido) throws PedidoException {
		try {
			log.debug("Insertando datos generales del pedido...");
			Pedido guardado = repoP.save(pedido);
			Integer numLinea = 1;
			log.debug("Insertando líneas del pedido...");
			for (PedidoLinea linea : guardado.getLineas()) {
				linea.setIdPedido(guardado.getIdPedido());
				linea.setNumeroLinea(numLinea);
				numLinea++;
				repoPL.save(linea);
			}
			return guardado.getIdPedido();
		} catch (DataAccessException e) {
			log.error("Error creando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
		

	}

}
