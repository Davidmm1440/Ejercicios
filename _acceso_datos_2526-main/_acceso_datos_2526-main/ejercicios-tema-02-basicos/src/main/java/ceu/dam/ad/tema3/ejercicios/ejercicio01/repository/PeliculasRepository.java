package ceu.dam.ad.tema3.ejercicios.ejercicio01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;
import java.util.List;


@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer>{
	List<Pelicula> findAllByLongitud(Integer longitud);
}
