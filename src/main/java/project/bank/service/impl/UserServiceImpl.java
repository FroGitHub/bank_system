package project.bank.service.impl;

import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.bank.dto.user.UserRegisterRequestDto;
import project.bank.dto.user.UserRegisterResponseDto;
import project.bank.exception.EntityNotFoundException;
import project.bank.exception.RegistrationException;
import project.bank.mapper.UserMapper;
import project.bank.model.Role;
import project.bank.model.User;
import project.bank.repository.RoleRepository;
import project.bank.repository.UserRepository;
import project.bank.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Override
    public UserRegisterResponseDto register(UserRegisterRequestDto userRegReqDto) {

        if (userRepository.existsByEmail(userRegReqDto.getEmail())) {
            throw new RegistrationException("User already exists with email: "
                    + userRegReqDto.getEmail());
        }

        User user = userMapper.toModel(userRegReqDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName(Role.RoleName.ROLE_USER)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Role is not found: " + Role.RoleName.ROLE_USER)
                );
        user.setRoles(Set.of(role));

        return userMapper.toDto(userRepository.save(user));
    }
}
