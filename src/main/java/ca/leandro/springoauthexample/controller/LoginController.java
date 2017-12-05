package ca.leandro.springoauthexample.controller;

import ca.leandro.springoauthexample.dto.LoginDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto, HttpServletRequest request) throws ServletException {
            request.login(loginDto.getUsername(), loginDto.getPassword());
    }
}
