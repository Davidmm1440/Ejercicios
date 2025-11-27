package service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dto.request.FilterDto;
import exception.StudentDuplicateException;
import exception.StudentNotFoundException;
import model.Student;
import repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository repo;
	
	@Override
	public Student create(Student student) throws StudentDuplicateException {
		
		if((repo.findByFirstName(student.getFirstName()).size() + repo.findByEmail(student.getEmail()).size()) > 0) {
			
			throw new StudentDuplicateException();
		}
		
		student.setCreatedAt(LocalDate.now());
		return repo.save(student);
	}

	@Override
	public void remove(Long id) throws StudentNotFoundException {
		
		repo.findById(id).orElseThrow(() -> new StudentNotFoundException("This student doesn´t exist."));
		repo.deleteById(id);
	}

	@Override
	public Student findById(Long id) throws StudentNotFoundException {
		return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("This student doesn´t exist."));
	}

	@Override
	public List<Student> findAll() throws StudentNotFoundException {
	    try {
	        List<Student> students = repo.findAll(Sort.by("dni").ascending());
	        if (students.isEmpty()) {
	            throw new StudentNotFoundException("No students found");
	        }
	        
	        return students;
	        
	    } catch (DataAccessException e) {
	        throw e;
	    }
	}

	@Override
	public List<Student> findByAgeRange(Integer minAge, Integer maxAge) {
	    try {
	        return repo.findByAgeBetween(minAge, maxAge, Sort.by("age").ascending());
	    } catch (DataAccessException e) {
	        e.printStackTrace();
	        return Collections.emptyList();
	    }
	}

	@Override
	public List<Student> search(FilterDto filter) {
		return null;
	}

}
