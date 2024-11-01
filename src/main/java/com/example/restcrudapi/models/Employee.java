package com.example.restcrudapi.models;

import com.example.restcrudapi.validators.ShouldStartWith;
import com.example.restcrudapi.validators.UniqueEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Table(name="employee")
@Getter
@Setter
public class  Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^(?!\\s).*(?<!\\s)$",
            message = "First name must not start or end with whitespace")
    @ShouldStartWith("Max")
    private String firstName;

    @Column(name="last_name")
    @Pattern(regexp = "^(?!\\s).*(?<!\\s)$",
            message = "First name must not start or end with whitespace")
    private String lastName;

    @Column(name="email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
            message="value must meet email format criteria")
    @NotBlank(message="email is required")
    @UniqueEmail
    private String email;

    @Min(0)
    @Max(100)
    @Column(name="number_of_points")
    private int points;

    public Employee(String firstName, String lastName, String email, int points) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id = " + id +
                ", first name = " + firstName + '\'' +
                ", last name = " + lastName + '\'' +
                ", email = " + email + '\'' +
                '}';
    }
}
