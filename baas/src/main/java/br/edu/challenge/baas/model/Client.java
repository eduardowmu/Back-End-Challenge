package br.edu.challenge.baas.model;

import br.edu.challenge.baas.enumeration.TypePerson;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CLIENTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String document;

    private String address;

    @Enumerated
    @Column(nullable = false, name = "type_person")
    private TypePerson typePerson;

    // https://www.baeldung.com/jpa-one-to-one
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}