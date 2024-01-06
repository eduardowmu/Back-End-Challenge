package br.com.desafio.vaga.enumeration;

import lombok.Getter;

@Getter
public enum FatorCnpj {
    ZERO(0,5),
    UM(1, 4),
    DOIS(2, 3),
    TRES(3, 2),
    QUATRO(4, 9),
    CINCO(5, 8),
    SEIS(6, 7),
    SETE(7, 6),
    OITRO(8, 5),
    NOVE(9, 4),
    DEZ(10, 3),
    ONZE(11, 2);

    private int id;
    private int fator;

    FatorCnpj(int id, int fator) {
        this.id = id;
        this.fator = fator;
    }
}
