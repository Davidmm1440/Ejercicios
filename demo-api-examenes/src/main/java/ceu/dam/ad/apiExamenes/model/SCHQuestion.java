package ceu.dam.ad.apiExamenes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SC")
public class SCHQuestion extends Question {

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
