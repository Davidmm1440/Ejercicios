package ceu.dam.ad.apiExamenes.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MC")
public class MCHQuestion extends Question{

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
