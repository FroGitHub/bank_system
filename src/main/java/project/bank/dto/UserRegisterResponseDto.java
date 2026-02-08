package project.bank.dto;

public record UserRegisterResponseDto(Long id,
                                      String email,
                                      String firstName,
                                      String lastName) {
}
