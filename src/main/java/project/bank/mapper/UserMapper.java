package project.bank.mapper;

import org.mapstruct.Mapper;
import project.bank.config.MapperConfig;
import project.bank.dto.UserRegisterRequestDto;
import project.bank.dto.UserRegisterResponseDto;
import project.bank.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {

    User toModel(UserRegisterRequestDto userRegisterRequestDto);

    UserRegisterResponseDto toDto(User user);

}
