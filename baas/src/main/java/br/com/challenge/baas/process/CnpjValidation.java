package br.com.challenge.baas.process;

import br.com.challenge.baas.enumeration.FatorCnpj;
import br.com.challenge.baas.exception.BusinessException;
import br.com.challenge.baas.model.Client;
import br.com.challenge.baas.model.EntityModel;

//Referencia https://blog.dbins.com.br/como-funciona-a-logica-da-validacao-do-cnpj
public class CnpjValidation implements Validation {
    @Override
    public void process(EntityModel em) {
        Client client = (Client)em;
        if(!validCnpj(client.getDocument())) {
            throw new BusinessException("CPF invalido. Favor verifique se foi digitado corretamente e tente novamente");
        }
    }

    private Boolean validCnpj(String cnpj) {
        if(cnpj.length() != 14) return Boolean.FALSE;

        Integer[] numero = new Integer[14];
        for(int i = 0; i < cnpj.length(); i++) {
            numero[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
        }

        int soma = 0;
        for(int i = 0; i < (numero.length - 2); i++) {
            soma += numero[i] * this.getFator(i);
        }

        int primeiroDv = soma % 11;
        primeiroDv = primeiroDv <= 1 ? 0 : (11 - primeiroDv);

        if(primeiroDv != numero[12]) {
            return Boolean.FALSE;
        }

        return this.validaUltimoDigito(numero);
    }

    private Boolean validaUltimoDigito(Integer[] numero) {
        int soma = 0;
        for(int i = 0; i < (numero.length - 1); i++) {
            soma += numero[i] * (this.getFator(i) + 1);
        }

        int segundoDv = (soma % 11);
        segundoDv = segundoDv <= 1 ? 0 : (11 - segundoDv);

        if(segundoDv != numero[13]) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private int getFator(int index) {
        for(FatorCnpj fc : FatorCnpj.values()) {
            if(index == fc.getId()) {
                return fc.getFator();
            }
        }
        return 0;
    }

}