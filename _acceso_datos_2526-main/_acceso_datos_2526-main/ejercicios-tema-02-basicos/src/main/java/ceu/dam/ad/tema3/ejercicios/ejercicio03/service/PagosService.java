package ceu.dam.ad.tema3.ejercicios.ejercicio03.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio02.model.Cliente;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.repository.ClientesRepository;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.model.Pago;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.repository.PagosRepository;

@Service
public class PagosService {

	@Autowired
	private PagosRepository repoP;
	@Autowired
	private ClientesRepository repoC;

	// private static final Logger log = LoggerFactory.getLogger(PagosService.class);

	public Map<String, List<Pago>> consultarPagosClientes() throws PagosException {
		try {
			HashMap<String, List<Pago>> mapa = new HashMap<>();
			List<Cliente> clientes = repoC.findAll();
			for (Cliente cliente : clientes) {
				List<Pago> pagos = repoP.findAllByCustomerId(cliente.getId());
				mapa.put(cliente.getEmail(), pagos);
			}
			return mapa;
		} catch (DataAccessException e) {
			throw new PagosException();
		}

	}
}
