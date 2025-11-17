package ceu.dam.ad.users.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserLoginRequestDTO {

	@NotBlank(message = "El login no puede estar vacío")
	@Size(max = 100, message = "El username o email no puede tener mas de 100 caracteres")
	private String login;

	@NotBlank(message = "La password no puede ser vacia")
	@Size(min = 4, max = 12, message = "La password tiene que tener entre 4 y 12 caracteres")
	private String password;

}
