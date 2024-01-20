package br.edu.challenge.baas.process;

import br.edu.challenge.baas.enumeration.CnpjDigEnum;
import br.edu.challenge.baas.enumeration.TypePerson;
import br.edu.challenge.baas.exception.BusinessException;
import br.edu.challenge.baas.model.EntityModel;
import br.edu.challenge.baas.model.User;
import br.edu.challenge.baas.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/* Referências:
   https://www.macoratti.net/alg_cpf.htm e
   https://www.geradorcnpj.com/algoritmo_do_cnpj.htm*/
public class DocumentValidation implements Validation {
    private final ClientRepository clientRepository;
    @Autowired
    public DocumentValidation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public void process(EntityModel em) {
        User user = (User) em;
        if(this.clientRepository.findByDocument(user.getClient().getDocument()).isPresent()) {
            throw new BusinessException("Documento já cadastrado em nossa base! Favor entrar em contato com suporte");
        } else if(!this.isLegalDocument(user.getClient().getDocument())) {
            throw new BusinessException("Documento inválido! " + user.getClient().getDocument());
        } else if(user.getClient().getDocument().length() > 11) {
            user.getClient().setTypePerson(TypePerson.PJ);
        } else {
            user.getClient().setTypePerson(TypePerson.PF);
        }
    }

    private Boolean isLegalDocument(String document) {
        return document.length() > 11 ? this.isLegalCnpj(document) : this.isLegalCpf(document);
    }

    private Boolean isLegalCpf(String cpf) {
        if(cpf.length() != 11) {
            return Boolean.FALSE;
        }

        String[] document = this.getArrayValue(cpf);

        int soma = this.getSumValueCpf(document, 10);

        String dig1 = this.getRest(soma);

        if(!dig1.equals(String.valueOf(cpf.charAt(9)))) {
            return Boolean.FALSE;
        }

        soma = this.getSumValueCpf(document, 11);

        String dig2 = this.getRest(soma);

        if(!dig2.equals(String.valueOf(cpf.charAt(10)))) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    private Boolean isLegalCnpj(String cnpj) {
        if(cnpj.length() != 14) {
            return Boolean.FALSE;
        }

        String[] document = this.getArrayValue(cnpj);

        int soma = this.getSumValueCnpj(document, 12);

        String dig1 = this.getRest(soma);

        if(!dig1.equals(String.valueOf(cnpj.charAt(12)))) {
            return Boolean.FALSE;
        }

        soma = this.getSumValueCnpj(document, 13);

        String dig2 = this.getRest(soma);

        if(!dig2.equals(String.valueOf(cnpj.charAt(13)))) {
            return Boolean.TRUE;
        }

        return Boolean.TRUE;
    }

    private String[] getArrayValue(String document) {
        String[] doc = new String[document.length()];
        for(int i = 0; i < document.length(); i++) {
            doc[i] = String.valueOf(document.charAt(i));
        }
        return doc;
    }

    private int getSumValueCpf(String[] cpf, int length) {
        var soma = 0;
        for(int i = length; i >= 2; i--) {
            soma += Integer.parseInt(cpf[i]) * i;
        }
        return soma;
    }

    private int getSumValueCnpj(String[] cnpj, int lenth) {
        var soma = 0;
        List<Integer> numbers = this.getCnpjNumbersMultiply(lenth);

        for(int i = 0; i < 12; i++) {
            soma += Integer.parseInt(cnpj[i]) * numbers.get(i);
        }

        return soma;
    }

    private String getRest(int soma) {
        return soma % 11 < 2 ? "0" : String.valueOf(11 - (soma % 11));
    }

    private List<Integer> getCnpjNumbersMultiply(int length) {
        List<Integer> numbers = new ArrayList<>();
        if(length == 13) {
            numbers.add(6);
        }
        for(CnpjDigEnum e : CnpjDigEnum.values()) {
            numbers.add(e.getId());
        }
        return numbers;
    }
}