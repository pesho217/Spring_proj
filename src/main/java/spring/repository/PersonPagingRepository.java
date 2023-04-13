package spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import spring.model.Person;

import java.util.UUID;

@Repository
public interface PersonPagingRepository extends PagingAndSortingRepository<Person, UUID> {

}
