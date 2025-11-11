package ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio1.model.Serie;
import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio1.repository.SeriesRepository;
import jakarta.transaction.Transactional;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	private SeriesRepository repoS;

	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {

		try {
			Optional<Serie> opcionalSerie = repoS.findById(idSerie);
			return opcionalSerie
					.orElseThrow(() -> new SerieNotFoundException("La serie con id " + idSerie + " no existe"));
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error", e);
		}

	}

	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {

		try {
			List<Serie> byDescripcionContains = repoS.findByDescripcionContaining(filtroDescripcion);
			if (byDescripcionContains.isEmpty()) {
				throw new SerieNotFoundException();
			}
			return byDescripcionContains;
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error", e);
		}
	}

	@Override
	@Transactional
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		try {
			return repoS.save(serie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error", e);
		}

	}

	@Override
	@Transactional
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		try {
			repoS.deleteById(idSerie);
		} catch (Exception e) {
			throw new SeriesServiceException("Error", e);
		}

	}

	@Override
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		try {
			repoS.save(serie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error", e);
		}

	}

}
