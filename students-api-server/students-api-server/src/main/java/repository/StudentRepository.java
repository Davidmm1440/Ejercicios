package repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByFirstName(String firstName);
	List<Student> findByEmail(String email);
	List<Student> findByAgeBetween(Integer minAge, Integer maxAge, Sort sort);
}
