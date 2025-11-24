package ceu.dam.ad.users.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginRequestDTO {

	@NotBlank(message = "El login no puede estar vacío")
	@Schema(description = "Username o email con el que hara login")
	private String login;

	@NotBlank(message = "La password no puede ser vacia")
	@Schema(description = "Password sin cifrar")
	private String password;

}
