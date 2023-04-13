package spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.error.NotfoundObjectException;
import spring.model.Person;
import spring.model.Photo;
import spring.repository.PersonPagingRepository;
import spring.repository.PersonRepository;
import spring.repository.PhotoRepository;

import java.util.*;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;

    @Autowired
    private PersonPagingRepository pagingRepo;

    @Autowired
    private PhotoRepository photoRepo;

    public Person save(Person person){
        return repo.save(person);
    }
    public Page<Person> fetchAll (int currentPage, int pageSize){
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }
    public Person findById(String personId){
        return repo.findById(UUID.fromString(personId)).orElseThrow(() -> {
            throw new NotfoundObjectException("Person Not Found", Person.class.getName(), personId);
        });

        public void deleteById(String personId){
            repo.deleteById(UUID.fromString(personId));
        }

        public Set<UUID> getAllPersonPhotoIds(String personId){
            Person person = repo.findById(UUID.fromString(personId)).get();
            Set<UUID> allPersonPhotoIds = new HashSet<>();
            for (Photo photo : person.getPhotos()) {
                allPersonPhotoIds.add(photo.getId());
            }
            return allPersonPhotoIds;

        }

        public Set<UUID> setPersonPhotos(String personId, Set<UUID> personPhotoIds) {
            Person person = repo.findById(UUID.fromString(personId)).orElseThrow(() -> {
                throw new NotfoundObjectException("Person Not Found", Person.class.getName(), personId);
            });

            List<Photo> allPersonPhotos =
                    (List<Photo>) photoRepo.findAllById(personPhotoIds);

            person.setPhotos(new HashSet<>(allPersonPhotos));
            Person savedPerson = repo.save(person);

            Set<UUID> allPersonPhotoIds = new HashSet<>();
            for (Photo photo : savedPerson.getPhotos()) {
                allPersonPhotoIds.add(photo.getId());
            }

            return allPersonPhotoIds;
        }
    }
}

