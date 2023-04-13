package spring.repository;
import org.springframework.data.repository.CrudRepository;
import spring.model.Photo;
import java.util.UUID;

public interface PhotoRepository extends CrudRepository<Photo, UUID> {


}
