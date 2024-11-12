package com.example.AdjutorRUTMIIT_bot.controller;

import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(path = "find-by-id", params = "id")
    public ResponseEntity<?> findUserByIdEndpoint(@RequestParam(name = "id") int id)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.userService.findUserById(id),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "find-by-snils", params = "id")
    public ResponseEntity<?> findUserBySNILSEndpoint(@RequestParam(name = "snils") String SNILS)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.userService.findUserBySNILS(SNILS),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "find-by-fsp", params = {"first-name", "second-name", "patronymic"})
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
}
