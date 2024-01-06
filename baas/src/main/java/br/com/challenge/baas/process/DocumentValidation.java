package br.com.challenge.baas.process;

import br.com.challenge.baas.dto.RegisterReqDto;
import br.com.challenge.baas.exception.BusinessException;
import br.com.challenge.baas.model.EntityModel;
import br.com.challenge.baas.repository.ClientRepository;
import br.com.challenge.baas.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentValidation implements Validation {
    private final ClientRepository clientRepository;
    @Autowired
    public DocumentValidation(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public void process(EntityModel em) {
        RegisterReqDto dto = (RegisterReqDto)em;
        if(this.clientRepository.findByDocument(FormatUtils.toWithoutFormat(dto.cpfCnpj())).isPresent()) {
            throw new BusinessException("Ja existe um usuário com este documento");
        } else if (dto.cpfCnpj().length() > 11) {

        } else {

        }
    }
}