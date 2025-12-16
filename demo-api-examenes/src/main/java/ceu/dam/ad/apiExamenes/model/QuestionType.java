package ceu.dam.ad.apiExamenes.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class QuestionType {

	private String code;
	private String description;
}
