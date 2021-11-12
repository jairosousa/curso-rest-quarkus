package io.github.jairosousa.quarkussocial.rest.dto;

/**
 * @Autor Jairo Nascimento
 * @Created 12/11/2021 - 09:19
 */
public class CreateUserRequest {
    private String name;
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
