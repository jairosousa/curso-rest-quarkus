package io.github.jairosousa.quarkussocial.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 09:19
 */
public class CreateUserRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
