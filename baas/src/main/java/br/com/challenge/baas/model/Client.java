package br.com.challenge.baas.model;

import br.com.challenge.baas.enumeration.TypePersonal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
public class Client implements EntityModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 14, nullable = false)
    private String document;
    @Enumerated
    private TypePersonal typePersonal;
    @OneToMany
    private List<Account> accounts;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}