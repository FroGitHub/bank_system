package project.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import project.bank.validate.FieldsMatches;

@Data
@FieldsMatches(fields = {"password", "repeatPassword"})
public class UserRegisterRequestDto {
    @Email
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
