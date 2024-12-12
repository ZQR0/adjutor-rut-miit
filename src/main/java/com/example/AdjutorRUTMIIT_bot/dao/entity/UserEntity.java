package com.example.AdjutorRUTMIIT_bot.dao.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user_entity")
@Table(name = "users_table", schema = "adjutor_schema")
@NoArgsConstructor
@Setter
public class UserEntity extends AbstractEntity<Integer> {

    private Integer id;
    private String firstName; // Имя
    private String lastName; // Фамилия
    private String patronymic; // Отчество
    private String SNILS; //СНИЛС
    private String role;
    private Boolean isDeleted;
    private LocalDate registrationDate;
    private List<String> createdGroupsNames;


    public UserEntity(
            String firstName,
            String lastName,
            String patronymic,
            String SNILS,
            String role
            )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.SNILS = SNILS;
        this.role = role;
        this.isDeleted = false;
        this.registrationDate = LocalDate.now();
        this.createdGroupsNames = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    @Override
    public Integer getId() {
        return id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "patronymic", nullable = false)
    public String getPatronymic() {
        return patronymic;
    }

    @Column(name = "snils", unique = true, nullable = false, columnDefinition = "varchar")
    public String getSNILS() {
        return SNILS;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    @Column(name = "registration_date")
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }


    @Column(name = "created_groups_names", columnDefinition = "TEXT[]")
    public List<String> getCreatedGroupsNames() {
        return createdGroupsNames;
    }


    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public static final class UserEntityBuilder {
        private String firstName;
        private String lastName;
        private String patronymic;
        private String SNILS;
        private String role;

        public UserEntityBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserEntityBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public UserEntityBuilder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public UserEntityBuilder SNILS(String SNILS) {
            this.SNILS = SNILS;
            return this;
        }

        public UserEntityBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(
                    this.firstName,
                    this.lastName,
                    this.patronymic,
                    this.SNILS,
                    this.role
            );
        }
    }

}
