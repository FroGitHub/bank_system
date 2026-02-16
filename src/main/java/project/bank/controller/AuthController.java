package project.bank.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.bank.dto.user.UserLoginRequestDto;
import project.bank.dto.user.UserLoginResponseDto;
import project.bank.dto.user.UserRegisterRequestDto;
import project.bank.dto.user.UserRegisterResponseDto;
import project.bank.security.AuthenticationService;
import project.bank.service.UserService;

@Tag(name = "Auth controller", description = "reg/log/logout")
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private AuthenticationService authenticationService;

    @Operation(summary = "User registration")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisterResponseDto register(@Valid UserRegisterRequestDto userRegReqDto) {

        return userService.register(userRegReqDto);
    }

    @Operation(summary = "User logging")
    @PostMapping("/login")
    public UserLoginResponseDto login(@Valid UserLoginRequestDto userLogReqDto) {
        return authenticationService.login(userLogReqDto);
    }

    @Operation(summary = "User logout", description = "Logout and clear cookies")
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
