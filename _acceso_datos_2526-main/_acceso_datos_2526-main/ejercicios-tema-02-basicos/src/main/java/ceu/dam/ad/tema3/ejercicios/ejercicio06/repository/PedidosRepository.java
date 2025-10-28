package ceu.dam.ad.tema3.ejercicios.ejercicio06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio06.modelo.Pedido;

@Repository("RepositoryEj6")
public interface PedidosRepository extends JpaRepository<Pedido, Long>{

}
