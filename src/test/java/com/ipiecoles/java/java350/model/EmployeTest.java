package com.ipiecoles.java.java350.model;


import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ipiecoles.java.java350.model.Employe;

public class EmployeTest {

	
//Emmploye dateEmbauche avec date 2ans avant aujourd'hui=>2ann�es
	
@Test
	public void testAncienneteDateEmployeEmbauche() {
	 //Given
	 Employe employe= new Employe();
	 employe.setDateEmbauche(LocalDate.now().minusYears(2));
	 //When
	 Integer nbAnnees = employe.getNombreAnneeAnciennete();
	 //Then
	 Assertions.assertThat(nbAnnees).isEqualTo(2);
		
	}

@Test
	public void testAncienneteDateEmployeEmbauchen2() {
	//Given
	Employe employe= new Employe();
	employe.setDateEmbauche(LocalDate.now().plusYears(2));
	//When
	Integer nbAnnees = employe.getNombreAnneeAnciennete();
	//Then
	Assertions.assertThat(nbAnnees).isEqualTo(0);
	}



	@ParameterizedTest
	@CsvSource({
		"1,'T12345',0,1.0,1000.0",
		"1,'T12345',0,1.0,500.0",
		"1,'M12345',0,0.5,1700.0",
	
})
void testGetPrimeAnnuelle(Integer performance, String matricule ,Integer nbAnneesAnciennete, Double tempsPartiel, Double prime ) {
	//Given
	 Employe employe=new Employe();
	 employe.setMatricule(matricule);
	 employe.setPerformance(performance);
	 employe.setDateEmbauche(LocalDate.now().minusYears(nbAnneesAnciennete));
	 employe.setTempsPartiel(tempsPartiel);
	 //When
	 Double primeCalculee = employe.getPrimeAnnuelle();
	//Then
	 Assertions.assertThat(primeCalculee).isEqualTo(prime);
	
   }
}


