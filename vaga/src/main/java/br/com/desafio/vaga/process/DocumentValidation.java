package br.com.desafio.vaga.process;

import br.com.desafio.vaga.dto.RegisterReqDto;
import br.com.desafio.vaga.exception.BusinessException;
import br.com.desafio.vaga.model.EntityModel;
import br.com.desafio.vaga.repository.ClientRepository;
import br.com.desafio.vaga.utils.FormatUtils;

public class DocumentValidation implements Validation {
    private final ClientRepository clientRepository;
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