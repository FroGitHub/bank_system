package project.bank.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private RoleEnum role;

    @Override
    public @Nullable String getAuthority() {
        return role.name();
    }

    public enum RoleEnum {
        ROLE_ADMIN,
        ROLE_USER,
        ROLE_ACCOUNTANT
    }
}
