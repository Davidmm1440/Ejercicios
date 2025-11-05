package ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ceu.dam.ad.ejerciciosTema2.avanzado.ejercicio1.model.Serie;
import java.util.List;

public interface SeriesRepository extends JpaRepository<Serie, Long> {
	List<Serie> findByDescripcionContaining(String descripcion);
}
