package project.bank.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bank.dto.UserLoginRequestDto;
import project.bank.dto.UserLoginResponseDto;
import project.bank.dto.UserRegisterRequestDto;
import project.bank.dto.UserRegisterResponseDto;
import project.bank.security.AuthenticationService;
import project.bank.service.UserService;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisterResponseDto register(@Valid UserRegisterRequestDto userRegReqDto) {

        return userService.register(userRegReqDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@Valid UserLoginRequestDto userLogReqDto) {
        return authenticationService.login(userLogReqDto);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie cookie = ResponseCookie.from("jwt", "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .sameSite("Lax")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }
}
