package test.api.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class VideoJuego {
	public String _id;
	public String nombre;
	public BigDecimal valoracion;
	public Integer añoPublicacion;
	public String paisOrigen;
}
