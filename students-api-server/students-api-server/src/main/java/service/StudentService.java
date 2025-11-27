package service;

import java.util.List;

import dto.request.FilterDto;
import exception.StudentDuplicateException;
import exception.StudentNotFoundException;
import model.Student;

public interface StudentService {

	/**
	 * Creará el alumno en BBDD. La fecha de alta es algo que el servicio debe registrar automáticamente. Si ya existe alumno con el mismo DNI o Email lanzará un StudentDuplicateException.Devolverá el alumno creado con todos sus datos. 
	 * @param student
	 * @return
	 * @throws StudentDuplicateException
	 */
    Student create(Student student) throws StudentDuplicateException;

    /**
     * Eliminará el alumno con el id indicado en BBDD. Si el alumno no existe, lanzará StudentNotFoundException. 
     * @param id
     * @throws StudentNotFoundException
     */
    void remove(Long id) throws StudentNotFoundException;
    
    /**
     * Devolverá el alumno con el id indicado. Si no existe, lanzará StudentNotFoundException. 
     * @param id
     * @return
     * @throws StudentNotFoundException
     */
    Student findById(Long id) throws StudentNotFoundException;

    /**
     * Devolverá todos los alumnos ordenados por dni ascendente. Si no hay ninguno, lanzará StudentNotFoundException. 
     * @return
     * @throws StudentNotFoundException
     */
    List<Student> findAll() throws StudentNotFoundException;

    /**
     * Devolverá todos los alumnos con edades comprendidas entre la mínima y máxima recibidas (ambas inclusive). La lista estará ordenada por edad ascendente. Si no hay ninguno, devolverá una lista vacía.
     * @param minAge
     * @param maxAge
     * @return
     */
    List<Student> findByAgeRange(Integer minAge, Integer maxAge);

    /**
     * Devolverá todos los alumnos que cumplan con todos los filtros indicados ignorando mayúsculas/minúsculas y aplicando un LIKE en las cadenas.Si no hay resultados, devolverá lista vacía.
     * @param filter
     * @return
     */
    List<Student> search(FilterDto filter);
}
