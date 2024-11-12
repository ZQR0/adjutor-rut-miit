package com.example.AdjutorRUTMIIT_bot.service;


import com.example.AdjutorRUTMIIT_bot.dto.UserCreationDTO;
import com.example.AdjutorRUTMIIT_bot.dto.UserDTO;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;

public interface AdminService {

    /**
     * Метод создания пользователя от имени админа
     * @author Yaroslav Rechkalov
     * */
    UserDTO createUserByAdmin(UserCreationDTO dto) throws UniqueEntityAlreadyExistsException;

}
