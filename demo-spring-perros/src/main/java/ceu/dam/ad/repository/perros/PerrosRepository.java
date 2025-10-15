package ceu.dam.ad.repository.perros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.model.Perro;
import java.util.List;


@Repository
public interface PerrosRepository extends JpaRepository<Perro, Long>{
	List<Perro> findByPerroNameContains(String filtroNombre);
}
