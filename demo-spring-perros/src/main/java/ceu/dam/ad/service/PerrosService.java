package ceu.dam.ad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.model.Perro;
import ceu.dam.ad.repository.perros.PerrosRepository;

@Service
public class PerrosService {
	
	@Autowired
	private PerrosRepository repo;
	
	public Perro crearPerro(Perro perro) {
		return repo.save(perro);
	}
	
	public Perro consultarPerro(Long id) throws NotFoundException {

		
		Optional<Perro> opcionalPerro = repo.findById(id);
		
//		return opcionalPerro.orElseThrow(()-> new NotFoundException("No existe el perro"));
		
		if (opcionalPerro.isPresent()) {
			return opcionalPerro.get();
		}
		throw new NotFoundException("No existe el perro");
	}
	
	public List<Perro> getAll(){
		return repo.findAll();
	}
	
	public List<Perro> encontrarPerros(String filtroNombre){
		return repo.findByPerroNameContains(filtroNombre);
		
	}
}
