package one.innovation.digital.personAPI.service;

import one.innovation.digital.personAPI.dto.request.PersonDTO;
import one.innovation.digital.personAPI.dto.response.MessageResponseDTO;
import one.innovation.digital.personAPI.model.Person;
import one.innovation.digital.personAPI.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private static final ModelMapper modelMapper = new ModelMapper ();
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person person = modelMapper.map ( personDTO, Person.class  );

        Person savedPersonDTO = personRepository.save ( person );

        return MessageResponseDTO
                .builder()
                .message ( "Pessoa criada com ID: " + savedPersonDTO.getId () )
                .build();
    }
}
