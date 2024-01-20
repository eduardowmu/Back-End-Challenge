package br.edu.challenge.baas.service;

import br.edu.challenge.baas.dto.SignupDto;
import br.edu.challenge.baas.dto.SignupRespDto;

public interface SignupService {
    SignupRespDto signup(SignupDto dto);
}