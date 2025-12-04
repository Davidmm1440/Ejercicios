package dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentRequestDTO {
	
	@NotBlank(message = "dni can't be blank")
	@Size(max = 20, message = "Dni max size is 20")
	private String dni;
	
	@NotBlank(message = "First name can't be blank")
	@Size(max = 100, message = "First name max size is 100")
	private String firstName;
	
	@NotBlank(message = "Last name can't be blank")
	@Size(max = 100, message = "Last name max size is 100")
	private String lastName;
	
	@NotBlank(message = "Email can't be blank")
	@Size(max = 150, message = "Email max size is 150")
	@Email(message = "Wrong email pattern")
	private String email;
	
	@NotBlank(message = "Date of birth can't be blank")
	private LocalDate dateOfBirth;
	
	@Size(max = 20, message = "Gender max size is 20")
	private String gender;
	
	@Size(max = 100, message = "Program max size is 100")
	private String program;
	
}

