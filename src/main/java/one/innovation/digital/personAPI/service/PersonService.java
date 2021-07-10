package one.innovation.digital.personAPI.service;

import one.innovation.digital.personAPI.dto.MessageResponseDTO;
import one.innovation.digital.personAPI.model.Person;
import one.innovation.digital.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save ( person );
        return MessageResponseDTO
                .builder()
                .message ( "Pessoa criada com ID: " + savedPerson.getId () )
                .build();
    }
}
