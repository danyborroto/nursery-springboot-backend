package com.nursery.app.features.users.service;

import com.nursery.app.exception.FeatureNotFoundException;
import com.nursery.app.features.users.dto.UserRequestDTO;
import com.nursery.app.features.users.dto.UserResponseDTO;
import com.nursery.app.features.users.entity.User;
import com.nursery.app.features.users.repository.UserRepository;
import com.nursery.app.util.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> users = userRepository.findAll().stream()
                .map(Mappers::toUserResponseDTO)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    public ResponseEntity<UserResponseDTO> getOne(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new FeatureNotFoundException("Usuario", userId));
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toUserResponseDTO(user));
    }

    public ResponseEntity<UserResponseDTO> findByName(String userName) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toUserResponseDTO(user));
    }


    public ResponseEntity<UserResponseDTO> register(UserRequestDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserPassword(passwordEncoder.encode(dto.getUserPassword()));
        user.setUserEmail(dto.getUserEmail());
        user.setUserPhone(dto.getUserPhone());
        user.setAdmin(Boolean.TRUE.equals(dto.getAdmin()));
        user.setActive(true);

        User saved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Mappers.toUserResponseDTO(saved));
    }

    public ResponseEntity<UserResponseDTO> update(Integer userId, UserRequestDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new FeatureNotFoundException("User", userId));
        user.setUserName(dto.getUserName());
        if (dto.getUserPassword() != null) user.setUserPassword(passwordEncoder.encode(dto.getUserPassword()));
        user.setUserEmail(dto.getUserEmail());
        user.setUserPhone(dto.getUserPhone());
        user.setAdmin(Boolean.TRUE.equals(dto.getAdmin()));
        user.setActive(Boolean.TRUE.equals(dto.getActive()));

        User saved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(Mappers.toUserResponseDTO(saved));
    }

    public ResponseEntity<Void> delete(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new FeatureNotFoundException("User", userId));
        user.setActive(false);
        User saved = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
