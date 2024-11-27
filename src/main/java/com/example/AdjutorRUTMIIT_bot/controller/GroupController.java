package com.example.AdjutorRUTMIIT_bot.controller;

import com.example.AdjutorRUTMIIT_bot.dto.GroupCreationDTO;
import com.example.AdjutorRUTMIIT_bot.exception.EntityNotFoundException;
import com.example.AdjutorRUTMIIT_bot.exception.EntityValidationFailedException;
import com.example.AdjutorRUTMIIT_bot.exception.UniqueEntityAlreadyExistsException;
import com.example.AdjutorRUTMIIT_bot.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/groups/")
public class GroupController {

    private final GroupService groupService;

    @GetMapping(path = "get-all-groups")
    public ResponseEntity<?> getAllGroupsEndpoint() {
        return new ResponseEntity<>(
                this.groupService.getAllGroups(),
                HttpStatus.OK
        );
    }

    //FIXME: будет фикситься уже после релиза, т.к. не самая важная функция
//    @GetMapping(path = "get-all-by-count", params = "count")
//    public ResponseEntity<?> getAllByCount(@RequestParam(name = "count") Integer count) {
//        return new ResponseEntity<>(
//                this.groupService.getFixedCountOfGroups(count),
//                HttpStatus.OK
//        );
//    }


    @GetMapping(path = "by-id", params = "id")
    public ResponseEntity<?> findByIdEndpoint(@RequestParam(name = "id") int id)
            throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.groupService.findGroupById(id),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "by-group-name", params = "groupName")
    public ResponseEntity<?> findByGroupNameEndpoint(@RequestParam(name = "groupName") String groupName)
            throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.groupService.findGroupByName(groupName),
                HttpStatus.OK
        );
    }

//    @GetMapping(path = "by-creator-id", params = "creatorId")
//    public ResponseEntity<?> findGroupByCreatorId(@RequestParam(name = "creatorId") int creatorId)
//        throws EntityNotFoundException
//    {
//        return new ResponseEntity<>(
//                this.groupService.findGroupByCreatorId(creatorId),
//                HttpStatus.OK
//        );
//    }

    @PostMapping(path = "create-group")
    public ResponseEntity<?> createGroupEndpoint(@RequestBody GroupCreationDTO dto)
        throws EntityNotFoundException, EntityValidationFailedException, UniqueEntityAlreadyExistsException
    {
        return new ResponseEntity<>(
                this.groupService.createGroup(dto),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "delete/by-id", params = "id")
    public ResponseEntity<?> safeDeleteById(@RequestParam(name = "id") int id)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.groupService.safeDeleteGroupById(id),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "delete/by-group-name", params = "groupName")
    public ResponseEntity<?> safeDeleteByGroupName(@RequestParam(name = "groupName") String groupName)
        throws EntityNotFoundException
    {
        return new ResponseEntity<>(
                this.groupService.safeDeleteGroupByGroupName(groupName),
                HttpStatus.OK
        );
    }

}
