package controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.request.StudentRequestDTO;
import dto.response.StudentCreateResponseDTO;
import dto.response.StudentResponseDTO;
import exception.StudentDuplicateException;
import exception.StudentNotFoundException;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import model.Student;
import service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping()
	public StudentCreateResponseDTO create(@Valid @RequestBody StudentRequestDTO student) throws StudentDuplicateException {
		Student studentEntity = new ModelMapper().map(student, Student.class);
		studentEntity = service.create(studentEntity);
		return new ModelMapper().map(studentEntity, StudentCreateResponseDTO.class);
	}
	
	
	 @DeleteMapping("/{id}/delete")
	    public String eliminarUsuario(@PathVariable Long id) throws StudentNotFoundException {
	        service.remove(id);
	        return "Usuario eliminado correctamente";
	       
	    }

	 
	 @GetMapping("/{id}")
		public StudentResponseDTO getById(@PathVariable Long id) throws StudentNotFoundException {
			Student student = service.findById(id);
			return new ModelMapper().map(student, StudentResponseDTO.class);
		}
//
//    /**
//     * Devolverá todos los alumnos ordenados por dni ascendente. Si no hay ninguno, lanzará StudentNotFoundException. 
//     * @return
//     * @throws StudentNotFoundException
//     */
//    List<Student> findAll() throws StudentNotFoundException;
	 
//
//    /**
//     * Devolverá todos los alumnos con edades comprendidas entre la mínima y máxima recibidas (ambas inclusive). La lista estará ordenada por edad ascendente. Si no hay ninguno, devolverá una lista vacía.
//     * @param minAge
//     * @param maxAge
//     * @return
//     */
//    List<Student> findByAgeRange(Integer minAge, Integer maxAge);
//
//    /**
//     * Devolverá todos los alumnos que cumplan con todos los filtros indicados ignorando mayúsculas/minúsculas y aplicando un LIKE en las cadenas.Si no hay resultados, devolverá lista vacía.
//     * @param filter
//     * @return
//     */
//    List<Student> search(FilterDto filter);

}
