package one.innovation.digital.personAPI.controller;

import one.innovation.digital.personAPI.dto.MessageResponseDTO;
import one.innovation.digital.personAPI.model.Person;
import one.innovation.digital.personAPI.repository.PersonRepository;
import one.innovation.digital.personAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson ( person );
    }

}

