package web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Name not empty")
    @Size(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Lastname not empty")
    @Size(min = 2, max = 50)
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Min(value = 1, message = "Age should be more than 0")
    @Column(name = "age")
    private int age;

    public User() {}

    public User(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
