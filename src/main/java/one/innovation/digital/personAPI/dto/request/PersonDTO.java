package one.innovation.digital.personAPI.dto.request;


import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import one.innovation.digital.personAPI.model.Phone;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;

    private String birthDate;
}
