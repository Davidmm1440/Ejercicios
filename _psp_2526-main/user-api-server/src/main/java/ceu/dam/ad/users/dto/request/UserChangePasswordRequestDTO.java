package ceu.dam.ad.users.dto.request;

import lombok.Data;

@Data
public class UserChangePasswordRequestDTO {

	private Long idUser;
	private String oldPassword;
	private String newPassword;
	
}
