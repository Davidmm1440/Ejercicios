package dto.request;

import lombok.Data;

@Data
public class FilterDto {
	
	private String dni;
	private String email;
	private String first_name;
	private String last_name;
	private Integer age;
	private String gender;
	private String program;
	
}
