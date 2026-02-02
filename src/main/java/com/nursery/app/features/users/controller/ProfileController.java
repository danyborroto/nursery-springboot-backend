package com.nursery.app.features.users.controller;

import com.nursery.app.features.users.dto.ProfileResponseDTO;
import com.nursery.app.features.users.entity.User;
import com.nursery.app.features.users.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<ProfileResponseDTO> profile(Authentication auth) {
        String username = auth.getName();

        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        ProfileResponseDTO dto = new ProfileResponseDTO();
        dto.setUserName(user.getUserName());
        dto.setUserEmail(user.getUserEmail());
        String role = user.getAdmin() ? "ROLE_ADMIN" : "ROLE_USER";
        dto.setUserRole(role);

        return ResponseEntity.ok(dto);
    }
}
