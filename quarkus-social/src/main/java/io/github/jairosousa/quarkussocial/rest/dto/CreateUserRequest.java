package io.github.jairosousa.quarkussocial.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 09:19
 */

@Data
public class CreateUserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    private Integer age;

}
