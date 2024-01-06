package br.com.desafio.vaga.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage implements EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 200)
    private String msg;
    private LocalDateTime dateTime;

    public ErrorMessage(String msg) {
        this.msg = msg;
        this.dateTime = LocalDateTime.now();
    }
}