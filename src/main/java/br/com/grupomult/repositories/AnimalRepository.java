package br.com.grupomult.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.grupomult.entities.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {

}
