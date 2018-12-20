package br.com.grupomult.configurations;

import static br.com.grupomult.api.animal.models.Animal.SpeciesEnum.CANINE;
import static br.com.grupomult.api.animal.models.Animal.SpeciesEnum.FELINE;
import static br.com.grupomult.utils.DateUtils.ISO8601_COMPLETE_DATE;
import static br.com.grupomult.utils.DateUtils.stringToDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.grupomult.api.animal.models.Animal.SpeciesEnum;
import br.com.grupomult.entities.Animal;
import br.com.grupomult.entities.Species;
import br.com.grupomult.repositories.AnimalRepository;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	public CommandLineRunner initDatabase(AnimalRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(createAnimal("Janis", "2015-02-09", CANINE)).toString());
			log.info("Preloading " + repository.save(createAnimal("Rocky", "2014-10-15", FELINE)).toString());
		};
	}

	private static Animal createAnimal(String name, String dob, SpeciesEnum species) {
		return Animal.builder().name(name).dob(stringToDate(dob, ISO8601_COMPLETE_DATE))
				.species(Species.builder().code(species).build()).build();
	}

}