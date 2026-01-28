package com.nursery.app.features.users.controller;

import com.nursery.app.features.users.dto.UserRequestDTO;
import com.nursery.app.features.users.dto.UserResponseDTO;
import com.nursery.app.features.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getOne(@PathVariable Integer userId){
        return userService.getOne(userId);
    }

    @GetMapping
    public ResponseEntity<UserResponseDTO> getByName(@RequestParam String userName){
        return userService.findByName(userName);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO dto){
        return userService.register(dto);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Integer userId, @Valid @RequestBody UserRequestDTO dto){
        return userService.update(userId, dto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Integer userId){
        return userService.delete(userId);
    }
}
