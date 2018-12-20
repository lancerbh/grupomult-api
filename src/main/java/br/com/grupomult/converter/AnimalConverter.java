package br.com.grupomult.converter;

import static br.com.grupomult.utils.DateUtils.ISO8601_COMPLETE_DATE;
import static br.com.grupomult.utils.DateUtils.dateToLocalDate;
import static br.com.grupomult.utils.DateUtils.dateToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.grupomult.api.animal.models.Animal;

public class AnimalConverter {

	protected final static Animal convert(br.com.grupomult.entities.Animal entity) {
		Animal domain = new Animal();
		domain.setName(entity.getName());
		domain.setDob(dateToString(entity.getDob(), ISO8601_COMPLETE_DATE));
		domain.setSpecies(entity.getSpecies().getCode());

		LocalDate localDate = dateToLocalDate(entity.getDob());
		LocalDate now = LocalDate.now();
		domain.setAgeInDays(localDate.until(now, ChronoUnit.DAYS));
		domain.setAgeInMonths(localDate.until(now, ChronoUnit.MONTHS));
		domain.setAgeInYears(localDate.until(now, ChronoUnit.YEARS));

		return domain;
	}

}
