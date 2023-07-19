
package com.meva.finance.api.controller;

import com.meva.finance.api.model.entity.User;
import com.meva.finance.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok().build();


    }




	/*@PostMapping("/teste")
	private void teste() throws Exception {
		log.info("OK");

	}*/

}
