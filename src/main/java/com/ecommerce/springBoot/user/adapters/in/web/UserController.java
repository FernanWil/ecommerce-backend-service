package com.ecommerce.springBoot.user.adapters.in.web;

import com.ecommerce.springBoot.user.adapters.in.web.dto.UserDTO;
import com.ecommerce.springBoot.user.application.commands.RegisterUserCommand;
import com.ecommerce.springBoot.user.application.ports.in.RegisterUserUseCase;
import com.ecommerce.springBoot.user.domain.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    final RegisterUserUseCase userUseCase;
    public UserController(RegisterUserUseCase userUseCase){
        this.userUseCase = userUseCase;
    }
    @PostMapping
    public ResponseEntity<User> execute(@Valid @RequestBody UserDTO dto){
        RegisterUserCommand command = dto.toCommand();
        User newUser = userUseCase.execute(command);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

}
