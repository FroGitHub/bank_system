package project.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private BigDecimal amount;

    @OneToMany(mappedBy = "transaction",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Fee> fees = new HashSet<>();

    private String description;

}
