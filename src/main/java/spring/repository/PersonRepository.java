package spring.repository;

import org.springframework.data.repository.CrudRepository;
import spring.model.Person;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {


}
