package com.devtracker.devtracker_backend.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.Getter;
@Setter
@Getter


@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Name is required")
    @Column (nullable = false, length = 40)
    private String name;

    @NotBlank(message = "Lastname is required")
    @Column(nullable = true)
    private String lastName;

    private Integer birthDate;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Column(nullable = false, length = 20)
    private String password;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = true, length = 14)
    private String phoneNumber;

    @Column (nullable = false)
    private String rol;
}





