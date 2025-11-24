package ceu.dam.ad.users.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserChangePasswordRequestDTO {

	@NotBlank(message = "La password antigua no puede ser vacia")
	private String oldPassword;

	@NotBlank(message = "La password nueva no puede ser vacia")
	private String newPassword;

}
