package ceu.dam.psp.api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ceu.dam.psp.PostresApiServerApplication;
import ceu.dam.psp.model.Postre;

@RestController
@RequestMapping("/postre")
public class PostresService {

    private final PostresApiServerApplication postresApiServerApplication;


    PostresService(PostresApiServerApplication postresApiServerApplication) {
        this.postresApiServerApplication = postresApiServerApplication;
    }


	@GetMapping("/{id}")
	public Postre getById(@PathVariable Long id) {
		return new Postre(id, "chocolate", new BigDecimal(300), new BigDecimal(200), "Tarta Choco", false );
	}
	
	@PostMapping()
	public Postre create(@RequestBody Postre postre) {
		postre.setId(877L);
		return postre;
	}
	
	@GetMapping()
	public List<Postre> search(@RequestParam(required = false) String sabor, @RequestParam(required = false) String nombre){
		List<Postre> resultado = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			resultado.add(new Postre(i+100L, sabor, new BigDecimal(300), new BigDecimal(200), nombre + " blas " + i, false ));
		}
		return resultado;
	}
	
	@DeleteMapping("/{id}")
	public String borrar(@PathVariable Long id) {
		System.out.println("ID " + id + " borrado!! ");
		return "Borrado";
		
	}
	
	@PutMapping("/{id}")
	public Postre update(@PathVariable Long id, @RequestBody Postre postre) {
		System.out.println("Postre con ID " + id + " actualizado");
		postre.setId(id);
		return postre;
	}
	
	
	
	
	
}










