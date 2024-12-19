package com.example.AdjutorRUTMIIT_bot.controller;

import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserRegistrationDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.exception.InvalidSNILSFormatException;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;
import com.example.AdjutorRUTMIIT_bot.service.UserService;
import com.example.AdjutorRUTMIIT_bot.utils.SnilsParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping(path = "find-by-id", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserByIdEndpoint(@RequestParam(name = "id") int id)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.userService.findUserById(id),
                HttpStatus.OK
        );
    }


    @GetMapping(path = "find-by-snils", params = "snils", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findUserBySNILSEndpoint(@RequestParam(name = "snils") String SNILS)
        throws EntityNotFoundException
    {
        String snils = SnilsParser.convertStringToSNILS(SNILS);
        return new ResponseEntity<>(
                this.userService.findUserBySNILS(snils),
                HttpStatus.OK
        );
    }


    @GetMapping(path = "find-by-fsp", params = {"first-name", "second-name", "patronymic"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findByFSPEndpoint(@RequestParam(name = "first-name") String firstName,
                                               @RequestParam(name = "second-name") String secondName,
                                               @RequestParam(name = "patronymic") String patronymic)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
            this.userService.findUserByFirstNameAndSecondNameAndPatronymic(firstName, secondName, patronymic),
                HttpStatus.OK
        );
    }

    @PostMapping(path = "register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerAndSafeUser(@RequestBody UserRegistrationDTO dto)
        throws UniqueEntityAlreadyExistsException, InvalidSNILSFormatException
    {
        UserDTO userDTO = this.userService.saveUser(dto);

        return new ResponseEntity<>(
                userDTO,
                HttpStatus.OK
        );
    }


    @DeleteMapping(path = "delete/by-fsp", params = {"firstName", "secondName", "patronymic"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> safeDeleteUserByFSP(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "secondName") String secondName,
            @RequestParam(name = "patronymic") String patronymic)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.userService.safeDeleteUserByFSP(firstName, secondName, patronymic),
                HttpStatus.OK
        );
    }


    @DeleteMapping(path = "delete/by-snils", params = "snils", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> safeDeleteUserBySNILS(@RequestParam(name = "snils") String snils)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.userService.safeDeleteUserBySNILS(snils),
                HttpStatus.OK
        );
    }


    @DeleteMapping(path = "delete/by-id", params = "id")
    public ResponseEntity<?> safeDeleteUserById(@RequestParam(name = "id") Integer id)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.userService.findUserById(id),
                HttpStatus.OK
        );
    }
}
