package test.api;

import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import test.api.model.VideoJuego;

public class Test {

	public static void main(String[] args) {
		
		try {
			URI url = new URI("https://crudcrud.com/api/4809d5b2b35e4a9486e026c6dea0b8ef/videojuego");
			
			VideoJuego v1 = new VideoJuego();
			v1.setNombre("Mario Kart Wii");
			v1.setValoracion(BigDecimal.valueOf(9.9));
			v1.setAñoPublicacion(2010);
			v1.setPaisOrigen("Canadá");
			
			String json = new Gson().toJson(v1);
			System.out.println("Request body: " + json);
			
			HttpClient client2 = HttpClient.newHttpClient();
			HttpRequest request2 = HttpRequest.newBuilder(url)
					.setHeader("Content-Type", "application/json")
					.POST(BodyPublishers.ofString(json))
					.build();
			
			HttpResponse<String> response2 = client2.send(request2, BodyHandlers.ofString());
			System.out.println(response2.statusCode());
			System.out.println(response2.body());
			VideoJuego videojuegoAnadido = new Gson().fromJson(response2.body(), VideoJuego.class);
			System.out.println("Videojuego creado " + videojuegoAnadido);

			HttpClient client1 = HttpClient.newHttpClient();
			HttpRequest request1 = HttpRequest.newBuilder(url).GET().build();
			
			HttpResponse<String> response = client1.send(request1, BodyHandlers.ofString());
			
			System.out.println(response.statusCode());
			System.out.println(response.body());
			VideoJuego[] videojuegos = new Gson().fromJson(response.body(), VideoJuego[].class);
			List<VideoJuego> listaVideojuegos = Arrays.asList(videojuegos);
			listaVideojuegos.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
