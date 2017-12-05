package ca.leandro.springoauthexample.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping({ "/", "/external" })
public class HelloController {


    @GetMapping
    public ResponseEntity<String> hello(Principal principal) {

        return ResponseEntity.ok("Hello, " + principal.getName() + "!");
    }

}
