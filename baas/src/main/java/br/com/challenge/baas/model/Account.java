package br.com.challenge.baas.model;

import br.com.challenge.baas.enumeration.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Account implements EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 4, nullable = false)
    private String agency;
    @Column(length = 9, nullable = false, unique = true)
    private String number;
    @Column(precision = 2)
    private BigDecimal balance;
    @Enumerated
    private Status status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}