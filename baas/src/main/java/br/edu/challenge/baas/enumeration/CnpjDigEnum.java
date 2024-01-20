package br.edu.challenge.baas.enumeration;

import lombok.Getter;

@Getter
public enum CnpjDigEnum {
    PRIMEIRO(5),
    SEGUNDO(4),
    TERCEIRO(3),
    QUARTO(2),
    QUINTO(9),
    SEXTO(8),
    SETIMO(7),
    OITAVO(6),
    NONO(5),
    DECIMO(4),
    DEC_PRIM(3),
    DEC_SEG(2);

    private int id;

    CnpjDigEnum(int id) {
        this.id = id;
    }
}