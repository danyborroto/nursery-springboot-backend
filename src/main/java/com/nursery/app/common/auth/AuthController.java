package com.nursery.app.common.auth;

import com.nursery.app.common.security.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequestDTO dto,
                                      HttpServletResponse res) {
        String token = authenticationService.authenticate(dto.getUsername(),dto.getPassword());
        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // en produccion poner true (https)
        cookie.setPath("/");
        cookie.setMaxAge(3600);

        res.addCookie(cookie);
        return  ResponseEntity.noContent().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse res){
        Cookie cookie = new Cookie("jwt","");
        cookie.setHttpOnly(true);
        cookie.setSecure(false); // en produccion poner true (https)
        cookie.setPath("/");
        cookie.setMaxAge(0);

        res.addCookie(cookie);
        return  ResponseEntity.noContent().build();
    }
}
