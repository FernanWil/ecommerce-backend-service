package com.ecommerce.springBoot.infrastructure.controller.User;

import com.ecommerce.springBoot.application.dto.User.RegisterUserCommand;
import com.ecommerce.springBoot.application.ports.in.User.RegisterUserUseCase;
import com.ecommerce.springBoot.domain.models.User;
import com.ecommerce.springBoot.infrastructure.controller.dto.UserDTO;
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
