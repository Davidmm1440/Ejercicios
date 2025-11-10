package ceu.dam.ad.users.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserChangePasswordRequestDTO {

	@NotBlank(message = "La password antigua no puede ser vacia")
	private String oldPassword;
	
	@NotBlank(message = "La password nueva no puede ser vacia")
	@Size(min = 4, max = 20, message = "La password nueva tiene que tener entre 4 y 20 caracteres")
	private String newPassword;
	
}
