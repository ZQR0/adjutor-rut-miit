package com.example.AdjutorRUTMIIT_bot.dao.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users_table", schema = "adjutor_schema")
@NoArgsConstructor
@Setter
public class UserEntity extends AbstractEntity<Integer> {

    private Integer id;
    private String firstName; // Имя
    private String lastName; // Фамилия
    private String phoneNumber;
    private String patronymic; // Отчество
    private String role;
    private String SNILS; //СНИЛС
    private LocalDate registrationDate;
    private List<GroupEntity> groups;


    public UserEntity(
            String firstName,
            String lastName,
            String phoneNumber,
            String patronymic,
            String role,
            String SNILS,
            LocalDate registrationDate
    )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.patronymic = patronymic;
        this.role = role;
        this.SNILS = SNILS;
        this.registrationDate = registrationDate;
        this.groups = new ArrayList<>();
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

    @Column(name = "phone_number", unique = true, nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Column(name = "patronymic", nullable = false)
    public String getPatronymic() {
        return patronymic;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    @Column(name = "snils", unique = true)
    public String getSNILS() {
        return SNILS;
    }

    @Column(name = "registration_date")
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @OneToMany(mappedBy = "creator", fetch = FetchType.EAGER)
    public List<GroupEntity> getGroups() {
        return groups;
    }

    public static UserEntityBuilder builder() {
        return new UserEntityBuilder();
    }

    public static final class UserEntityBuilder {
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String patronymic;
        private String role;
        private String SNILS;
        private LocalDate registrationDate;
        private List<GroupEntity> groups;

        public UserEntityBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserEntityBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserEntityBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserEntityBuilder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public UserEntityBuilder role(String role) {
            this.role = role;
            return this;
        }

        public UserEntityBuilder SNILS(String SNILS) {
            this.SNILS = SNILS;
            return this;
        }

        public UserEntityBuilder registrationDate(LocalDate registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public UserEntityBuilder groups(List<GroupEntity> groups) {
            this.groups = groups;
            return this;
        }

        public UserEntity build() {
            return new UserEntity(
                this.firstName,
                this.lastName,
                this.phoneNumber,
                this.patronymic,
                this.role,
                this.SNILS,
                this.registrationDate
            );
        }
    }

}
