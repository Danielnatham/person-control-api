package one.innovation.digital.personAPI.mapping;

import one.innovation.digital.personAPI.dto.request.PersonDTO;
import one.innovation.digital.personAPI.model.Person;
import org.modelmapper.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;


@Service
public class PersonMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    ModelMapper modelMapper = new ModelMapper ();


    public Person toPerson(PersonDTO personDTO){

        Person person = modelMapper.map ( personDTO, Person.class );

        LocalDate nascimento = LocalDate.parse ( personDTO.getBirthDate (),formatter  );
        person.setBirthDate ( nascimento );

        return person ;
    }

    public PersonDTO toDTO(Person person){

        PersonDTO dto = modelMapper.map ( person, PersonDTO.class );

        String nascimento = person.getBirthDate ().format ( formatter );
        dto.setBirthDate ( nascimento );

        return  dto ;
    }

}
