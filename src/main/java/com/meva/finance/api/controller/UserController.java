
package com.meva.finance.api.controller;

import com.meva.finance.api.dto.UserDto;
import com.meva.finance.api.model.User;
import com.meva.finance.api.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


@Slf4j
@RestController("/users") //controlador REST , recebe
public class UserController {

    //injeção de dependencia do Service
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.register(userDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto) {
        userService.update(userDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/delete/{cpf}")
    public ResponseEntity<UserDto> delete(@PathVariable String cpf) {
        userService.delete(cpf);
        //noContent retorna o 204 pois nao tem mais nada...
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscaporcpf/{cpf}")
    public ResponseEntity<User> getCpf(@PathVariable(value = "cpf") String cpf){
        Optional<User> userOptional = userService.findById(cpf);
        return userOptional.map(user -> ResponseEntity.status(HttpStatus.OK).body(user)).orElseGet(() -> ResponseEntity.notFound().build());
    }

}



