package one.innovation.digital.personAPI.service;

import one.innovation.digital.personAPI.dto.request.PersonDTO;
import one.innovation.digital.personAPI.dto.response.MessageResponseDTO;
import one.innovation.digital.personAPI.exception.PersonNotFoundException;
import one.innovation.digital.personAPI.mapping.PersonMapper;
import one.innovation.digital.personAPI.model.Person;
import one.innovation.digital.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Autowired
    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person person = personMapper.toPerson ( personDTO );



        Person savedPersonDTO = personRepository.save ( person );

        return MessageResponseDTO
                .builder ()
                .message ( "Pessoa criada com ID: " + savedPersonDTO.getId () )
                .build ();
    }

    public List<PersonDTO> listAll() {
        return personRepository.findAll ()
                .stream ()
                .map ( personMapper::toDTO )
                .collect ( Collectors.toList () );
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById ( id )
                .orElseThrow ( ()->  new PersonNotFoundException(id));
        return personMapper.toDTO ( person );
    }
}
