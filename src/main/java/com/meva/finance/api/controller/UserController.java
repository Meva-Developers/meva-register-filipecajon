
package com.meva.finance.api.controller;

import com.meva.finance.api.dto.UserDto;
import com.meva.finance.api.model.User;
import com.meva.finance.api.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController("/users")
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
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.update(userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{cpf}")
    public ResponseEntity<UserDto> delete(@PathVariable String cpf) {
        userService.delete(cpf);
        //noContent retorna o 204 pois nao tem mais nada...
        return ResponseEntity.noContent().build();
    }

}



