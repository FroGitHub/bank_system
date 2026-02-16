package project.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "fees")
@Getter
@Setter
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private ValueType valueType;

    @Enumerated(EnumType.STRING)
    private FeeType feeType;

    @ManyToOne
    @JoinColumn(name = "transaction_id",
            nullable = false)
    private Transaction transaction;

    public enum ValueType {
        PERCENT,
        FIX;
    }

    public enum FeeType {
        AUTHORIZATION,
        SETTLE,
        DECLINE
    }
}
