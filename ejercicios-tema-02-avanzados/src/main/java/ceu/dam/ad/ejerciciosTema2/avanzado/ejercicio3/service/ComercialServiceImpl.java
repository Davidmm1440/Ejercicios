package ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.modelo.CentroComercial;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.modelo.Marca;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.modelo.Pais;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.modelo.Tienda;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.repository.CCRepository;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.repository.MarcasRepository;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.repository.PaisesRepository;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio3.repository.TiendasRepository;
import jakarta.transaction.Transactional;

@Service
public class ComercialServiceImpl implements ComercialService {

	@Autowired
	private PaisesRepository repoP;

	@Autowired
	private MarcasRepository repoM;

	@Autowired
	private CCRepository repoCC;

	@Autowired
	private TiendasRepository repoT;

	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		try {
			return repoP.findAllByDescripcionStartingWith(filtro);
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		try {
			repoM.save(marca);
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

	@Override
	@Transactional
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		try {
			repoCC.save(cc);
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {

		try {
			UUID uidCentro = UUID.fromString(uuidCentro);
			Optional<CentroComercial> cc = repoCC.findById(uidCentro);
			if (cc.isEmpty()) {
				throw new NotFoundException("Centro Comercial no encontrado");
			}
			return cc.get();
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

	@Override
	public Tienda consultarTienda(Long idTienda) throws ComercialException, NotFoundException {

		try {
			Optional<Tienda> tienda = repoT.findById(idTienda);
			if (tienda.isEmpty()) {
				throw new NotFoundException("Tienda no encontrada");
			}
			return tienda.get();
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {

		try {
			repoT.deleteById(idTienda);
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

	@Override
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		try {
			UUID uidCentro = UUID.fromString(uuidCentro);
			repoCC.deleteById(uidCentro);
		} catch (DataAccessException e) {
			throw new ComercialException("Error inesperado", e);
		}
	}

}
