package one.innovation.digital.personAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Fixo"),
    MOBILE("Celular"),
    COMERCIAL("Trabalho");

    private final String description;

}
