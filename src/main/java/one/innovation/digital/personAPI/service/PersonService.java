package one.innovation.digital.personAPI.service;

import lombok.AllArgsConstructor;
import one.innovation.digital.personAPI.dto.request.PersonDTO;
import one.innovation.digital.personAPI.dto.response.MessageResponseDTO;
import one.innovation.digital.personAPI.exception.PersonNotFoundException;
import one.innovation.digital.personAPI.mapping.PersonMapper;
import one.innovation.digital.personAPI.model.Person;
import one.innovation.digital.personAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person person = personMapper.toPerson ( personDTO );

        Person savedPersonDTO = personRepository.save ( person );

        return createMessageResponse ( savedPersonDTO.getId (), "Pessoa criada com ID: " );
    }

    public List<PersonDTO> listAll() {
        return personRepository.findAll ()
                .stream ()
                .map ( personMapper::toDTO )
                .collect ( Collectors.toList () );
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person = verifyIfExist ( id );
        return personMapper.toDTO ( person );

    }

    public void deleteById(Long id) throws PersonNotFoundException {

        verifyIfExist ( id );
        personRepository.deleteById ( id );

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExist ( id );

        Person person = personMapper.toPerson ( personDTO );

        Person savedPersonDTO = personRepository.save ( person );

        return createMessageResponse ( savedPersonDTO.getId (), "Pessoa atualizada com ID: " );
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder ()
                .message ( message + id )
                .build ();
    }

    private Person verifyIfExist(Long id) throws PersonNotFoundException {
        return personRepository.findById ( id )
                .orElseThrow ( () -> new PersonNotFoundException ( id ) );
    }


}
