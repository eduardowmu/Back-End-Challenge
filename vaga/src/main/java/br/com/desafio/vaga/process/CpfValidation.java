package br.com.desafio.vaga.process;

import br.com.desafio.vaga.exception.BusinessException;
import br.com.desafio.vaga.model.Client;
import br.com.desafio.vaga.model.EntityModel;

public class CpfValidation implements Validation {
    @Override
    public void process(EntityModel em) {
        Client client = (Client)em;
        if(!validCpf(client.getDocument())) {
            throw new BusinessException("CPF inválido");
        }
    }

    private Boolean validCpf(String cpf) {
        if(cpf.length() != 11) return Boolean.FALSE;

        Integer[] numero = new Integer[11];
        for(int i = 0; i < cpf.length(); i++) {
            numero[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
        }

        int  soma = 0;
        for(int i = 0; i < (numero.length - 2); i++) {
            soma += numero[i] * (10 - i);
        }

        //dezena do digito verificador
        int dezenaDv = soma % 11;
        dezenaDv = dezenaDv <= 1 ? 0 : (11 - dezenaDv);
        if(dezenaDv != numero[9]) {
            return Boolean.FALSE;
        }

        return validaUltimoDigito(numero);
    }

    private Boolean validaUltimoDigito(Integer[] numero) {
        int soma = 0;
        for(int i = 0; i < (numero.length - 1); i++) {
            soma += numero[i] * (11 - i);
        }

        int unidadeDv = soma % 11;
        unidadeDv = unidadeDv <= 1 ? 0 : (11 - unidadeDv);
        if(unidadeDv != numero[10]) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
