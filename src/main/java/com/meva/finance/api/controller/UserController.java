
package com.meva.finance.api.controller;

import com.meva.finance.api.dto.UserDto;
import com.meva.finance.api.model.User;
import com.meva.finance.api.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

@Slf4j
@RestController("/users")
public class UserController {

    //injeção de dependencia do Service
    @Autowired
    private UserService userService;

/*
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserDto userDto) {

        User user = new User();
        BeanUtils.copyProperties(userDto, user);  //Convertendo User para UserDto com o BeanUtils
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(User user));
*/

        @PostMapping("/register")
        public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            return ResponseEntity.ok().build();


        }
  /*  public ResponseEntity<User> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok().build();
*/

    }




	/*@PostMapping("/teste")
	private void teste() throws Exception {
		log.info("OK");

	}*/


