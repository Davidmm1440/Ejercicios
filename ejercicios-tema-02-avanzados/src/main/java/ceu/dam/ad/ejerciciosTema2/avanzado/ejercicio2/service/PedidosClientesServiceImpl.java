package ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.model.Articulo;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.model.Cliente;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.model.Pedido;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.repository.ArticuloRepository;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.repository.ClienteRepository;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio2.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidosClientesServiceImpl implements PedidosClientesService {

	@Autowired
	private ClienteRepository repoC;
	@Autowired
	private PedidoRepository repoP;
	@Autowired
	private ArticuloRepository repoA;

	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {
			repoC.save(cliente);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);
		}
	}

	@Override
	@Transactional
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		try {
			for (int i = 1; i <= pedido.getLineas().size(); i++) {
				pedido.getLineas().get(i - 1).setNumLinea(i);
			}
			return repoP.save(pedido);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);
		}

	}

	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {

		try {
			return repoA.save(articulo);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {

		try {
			repoC.save(cliente);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);
		}
	}

	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {

		try {
			return repoC.findByDni(dni).orElseThrow(() -> new NotFoundException("Cliente con dni " + dni + " no existe"));
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);
		}
	}

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {

		try {
			return repoA.findById(idArticulo).orElseThrow(() -> new NotFoundException("Articulo con id " + idArticulo + " no existe"));
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);
		}
	}

	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {

		try {
			return repoP.findById(UUID.fromString(uuid)).orElseThrow(() -> new NotFoundException("Pedido con uuid " + uuid + " no existe"));
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error", e);		
		}
	}
	
	/** Consulta todos los pedidos que incluyan alguna línea donde se haya comprado el artículo con la descripción indicada
	 * Si no hay ningún pedido, se lanzará NotFoundException. */
	public List<Pedido> consultarPedidosByArticulo(String descripcionArticulo)	throws PedidosClientesServiceException, NotFoundException {
		List<Pedido> listaPedidos = repoP.findByLineasArticuloDescripcionEquals(descripcionArticulo);
		if (listaPedidos.isEmpty()) {
			throw new NotFoundException("Pedidos con descripcion de articulo: " + descripcionArticulo);
		}
		return listaPedidos;
		
	}

}
