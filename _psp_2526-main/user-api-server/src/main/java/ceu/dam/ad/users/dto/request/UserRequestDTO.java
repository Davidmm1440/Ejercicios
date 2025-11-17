package ceu.dam.ad.users.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {

	@NotBlank(message = "El username no puede estar vacio")
	@Size(max = 50, message = "El username puede tener como maximo 50 caracteres")
	private String username;

	@NotBlank(message = "El email no puede estar vacio")
	@Email(message = "Formato del email invalido")
	@Size(max = 100, message = "El email no puede tener mas de 100 caracteres")
	private String email;

	@NotBlank(message = "La password no puede ser vacia")
	@Size(min = 4, max = 12, message = "La password tiene que tener entre 4 y 12 caracteres")
	private String password;

}
