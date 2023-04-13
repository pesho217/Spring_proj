package spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.error.InvalidObjectPropertiesException;
import spring.mapper.PersonMapper;
import spring.model.Person;
import spring.service.PersonService;
import spring.validation.ObjectValidator;
import spring.web.dto.*;
import java.io.InvalidObjectException;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonService personService;

    private final Integer PAGE_SIZE = 10;


@GetMapping(name= "", produces = "application/json")
public PersonApiPage<PersonResponse> getAllPersons(
@RequestParam(required = false, defaultValue = "0") Integer currPage) {
        Page<PersonResponse> personPage =
        personService.fetchAll(currPage, PAGE_SIZE).map(personMapper::responseFromModel);
        return new PersonApiPage<>(personPage);
        }

@GetMapping("/{personId}")
public ResponseEntity<PersonResponse> getPersonById(@PathVariable String personId) {
        Person person = personService.findById(personId);

        return ResponseEntity.ok(personMapper.responseFromModel(person));
        }

@DeleteMapping("/{personId}")
public void deletePersonById(@PathVariable String personId) {
        personService.deleteById(personId);
        }

@PostMapping("")
public ResponseEntity<PersonResponse> createPerson(@RequestBody PersonCreateRequest personDto) {

        Map<String, String> validationErrors = validator.validate(personDto);
        if (validationErrors.size() != 0) {
        throw new InvalidObjectPropertiesException("Invalid Person Create", validationErrors);
        }

        Person mappedPerson = personMapper.modelFromCreateRequest(personDto);

        Person savedPerson = personService.save(mappedPerson);

        PersonResponse responsePerson = personMapper.responseFromModel(savedPerson);

        return ResponseEntity.status(201).body(responsePerson);
        }

@PatchMapping("/{personId}")
public ResponseEntity<PersonResponse> updatePerson(@PathVariable String personId,
@RequestBody PersonUpdateRequest personDto) {

        Map<String, String> validationErrors = validator.validate(personDto);
        if (validationErrors.size() != 0) {
        throw new InvalidObjectPropertiesException("Invalid Person Create", validationErrors);
        }

        Person currentPerson = personService.findById(personId);

        personMapper.updateModelFromDto(personDto, currentPerson);

        Person updatedPerson = personService.save(currentPerson);

        PersonResponse responsePerson = personMapper.responseFromModel(updatedPerson);

        return ResponseEntity.status(200).body(responsePerson);
        }

@GetMapping("/{personId}/photos")
public PersonPhotosGetResponse getAllPersonPhotos(@PathVariable String personId) {

        Set<UUID> allPersonPhotoIds = personService.getAllPersonPhotoIds(personId);

        PersonPhotosGetResponse response =
        PersonPhotosGetResponse.builder().personPhotoIds(allPersonPhotoIds).build();

        return response;
        }

@PutMapping(value = "/{personId}/photos")
public PersonPhotosGetResponse setPersonPhotos(@PathVariable String personId,
@RequestBody PersonPhotosUpsertRequest request) {

        Map<String, String> validationErrors = validator.validate(request);

        if (validationErrors.size() != 0) {
        throw new InvalidObjectPropertiesException("Invalid Person Photos Upsert Request",
        validationErrors);
        }

        Set<UUID> allPersonPhotoIds = personService.setPersonPhotos(personId, request.getPersonPhotoIds());

        PersonPhotosGetResponse response =
        PersonPhotosGetResponse.builder().personPhotoIds(allPersonPhotoIds).build();

        return response;
        }

        }