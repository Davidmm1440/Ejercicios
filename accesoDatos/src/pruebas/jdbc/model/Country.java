package pruebas.jdbc.model;

import java.time.LocalDate;

public class Country {

	private Integer id;
	private String name;
	private LocalDate lastUpdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDate lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}

}
