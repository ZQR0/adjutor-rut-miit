package com.example.AdjutorRUTMIIT_bot.controller;

import com.example.AdjutorRUTMIIT_bot.dto.UserCreationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;
import com.example.AdjutorRUTMIIT_bot.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/admin/")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping(path = "create-user")
    public ResponseEntity<UserDTO> createUserEndpoint(@RequestBody UserCreationDTO dto)
        throws UniqueEntityAlreadyExistsException
    {
        return new ResponseEntity<>(
                this.adminService.createUserByAdmin(dto),
                HttpStatus.OK
        );
    }

}
