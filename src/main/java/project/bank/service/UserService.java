package project.bank.service;

import project.bank.dto.user.UserRegisterRequestDto;
import project.bank.dto.user.UserRegisterResponseDto;

public interface UserService {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegReqDto);
}
