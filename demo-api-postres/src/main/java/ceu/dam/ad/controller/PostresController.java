package ceu.dam.ad.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.dto.request.PostreRequestDto;
import ceu.dam.ad.dto.response.PostreResponseDto;
import ceu.dam.ad.model.Postre;

@RestController
@RequestMapping("/postre")
public class PostresController {
	
//	@Autowired
//	private ModelMapper mapper;

	@GetMapping("/{id}")
	public Postre getById(@PathVariable Long id) {
		return new Postre(id, "Queso", new BigDecimal(10), "Tarta de queso", true);
	}

	@PostMapping()
	public PostreResponseDto create(@RequestBody PostreRequestDto postreDto) {
		
		// Obtenemos Entity desde RequestDto 
		Postre postreEntity = new ModelMapper().map(postreDto, Postre.class);
		// Llamar al servicio para insertar pasando el entity
		postreEntity.setId(888L);
		// Obtenemos ResponseDto desde entity
		return new ModelMapper().map(postreEntity, PostreResponseDto.class);
	}

	@GetMapping
	public List<Postre> getBySaborNombre(@RequestParam(required = false) String sabor,
			@RequestParam(required = false) String nombre) {

		List<Postre> resultado = new ArrayList<>();
		for (int i = 0; i <= 5; i++) {
			resultado.add(new Postre(i + 0L, sabor, new BigDecimal(10), nombre, true));
		}

		return resultado;

	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		System.out.println("Borrado postre id: " + id);
	}
	
	@PutMapping("/{id}")
	public Postre update(@RequestBody Postre postre, @PathVariable Long id) {
		postre.setId(id);
		System.out.println("Postre con id " + id + " actualizado");
		return postre;
		
	}
}