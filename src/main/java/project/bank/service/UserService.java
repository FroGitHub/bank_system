package project.bank.service;

import project.bank.dto.UserRegisterRequestDto;
import project.bank.dto.UserRegisterResponseDto;

public interface UserService {

    UserRegisterResponseDto register(UserRegisterRequestDto userRegReqDto);
}
