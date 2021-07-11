package one.innovation.digital.personAPI.controller;

import one.innovation.digital.personAPI.dto.request.PersonDTO;
import one.innovation.digital.personAPI.dto.response.MessageResponseDTO;
import one.innovation.digital.personAPI.exception.PersonNotFoundException;
import one.innovation.digital.personAPI.model.Person;
import one.innovation.digital.personAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson ( personDTO );
    }

    @GetMapping
    public List<PersonDTO> ListAll() {
        return personService.listAll ();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById ( id );
    }
}

